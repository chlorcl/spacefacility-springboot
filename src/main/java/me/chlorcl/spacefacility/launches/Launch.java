package me.chlorcl.spacefacility.launches;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.employees.Employee;
import me.chlorcl.spacefacility.vehicles.Vehicle;

import java.sql.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="launches")
public class Launch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Date launch_date;
    private Integer mission_manager;
    private Integer vehicle_id;


    @OneToMany
    @JoinTable (
            name = "launch_employees",
            joinColumns = @JoinColumn(name = "launch_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> employee;

    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Vehicle vehicle;





}
