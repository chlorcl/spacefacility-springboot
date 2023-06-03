package me.chlorcl.spacefacility.checkouts;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.employees.Employee;
import me.chlorcl.spacefacility.rooms.Room;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checkouts")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private Employee employee;

    private Date checkout_date;

    @OneToOne
    @JoinColumn(
            name = "room_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private Room room;


}

