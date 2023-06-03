package me.chlorcl.spacefacility.employees;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.professions.Profession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String ssn;
    private String country;
    private String city;
    private String address;
    private Integer areaId;

    @Enumerated(EnumType.STRING)
    private PrivilegeType privilegeType;

    @OneToOne
    @JoinColumn(name = "profession_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Profession profession;
}
