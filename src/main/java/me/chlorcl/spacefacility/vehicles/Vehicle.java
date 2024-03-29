package me.chlorcl.spacefacility.vehicles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.launches.Launch;

import java.sql.Date;
import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @Column(name="store_date")
    private Date storeDate;

    @Column(name="checkout_id")
    private Integer checkoutId;

}
