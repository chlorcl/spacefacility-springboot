package me.chlorcl.spacefacility.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String ssn;
    private String country;
    private String city;
    private String address;
}
