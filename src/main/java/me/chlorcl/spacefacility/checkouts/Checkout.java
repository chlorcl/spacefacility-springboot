package me.chlorcl.spacefacility.checkouts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.employees.Employee;
import me.chlorcl.spacefacility.rooms.Room;

import java.sql.Date;

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

