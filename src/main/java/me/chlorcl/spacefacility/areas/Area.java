package me.chlorcl.spacefacility.areas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.storages.Storage;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="areas")
public class Area {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;

}
