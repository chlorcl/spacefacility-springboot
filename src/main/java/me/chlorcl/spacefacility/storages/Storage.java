package me.chlorcl.spacefacility.storages;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.areas.Area;
import me.chlorcl.spacefacility.items.Item;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Data
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

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "area_id", referencedColumnName = "id")
        private Area area;

        @ManyToMany(mappedBy = "storages")
        private Set<Item> items = new HashSet<>();

}
