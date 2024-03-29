package me.chlorcl.spacefacility.security.auth;

import lombok.*;
import me.chlorcl.spacefacility.employees.Employee;
import me.chlorcl.spacefacility.employees.EmployeePrincipal;
import me.chlorcl.spacefacility.employees.EmployeeRepository;
import me.chlorcl.spacefacility.employees.PrivilegeType;
import me.chlorcl.spacefacility.security.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final EmployeeRepository employeeRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty() ||
                request.getPassword() == null || request.getPassword().isEmpty() ||
                request.getName() == null || request.getName().isEmpty() ||
                request.getSurname() == null || request.getSurname().isEmpty()) {
            throw new RuntimeException("All fields must be filled");
        }

        var employee = Employee.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .ssn(request.getSsn())
                .country(request.getCountry())
                .city(request.getCity())
                .address(request.getAddress())
                .areaId(0)
                .profession(null)
                .privilegeType(PrivilegeType.EMPLOYEE)
                .build();
        employeeRepository.save(employee);
        EmployeePrincipal employeePrincipal = new EmployeePrincipal(employee);
        var token = jwtService.generateToken(employeePrincipal);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var employee = employeeRepository.findByEmail(request.getEmail());
        if (employee.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        EmployeePrincipal employeePrincipal = new EmployeePrincipal(employee.get());
        var token = jwtService.generateToken(employeePrincipal);
        return AuthenticationResponse.builder()
                .token(token)
                .email(employee.get().getEmail())
                .name(employee.get().getName())
                .surname(employee.get().getSurname())
                .privilegeType(employee.get().getPrivilegeType())
                .build();
    }

    public Boolean authenticateToken(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        if (!jwtService.isTokenSignatureValid(token)) {
            return false;
        }

        var employee = employeeRepository.findByEmail(jwtService.extractEmail(token));
        if (employee.isEmpty()) {
            return false;
        }

        return true;
    }

}
