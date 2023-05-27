package me.chlorcl.spacefacility.storages;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.areas.Area;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="storages")
public class Storage {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String description;

        @ManyToOne
        @JoinColumn(name = "area_id", referencedColumnName = "id", insertable = false, updatable = false)
        private Area area;

}
