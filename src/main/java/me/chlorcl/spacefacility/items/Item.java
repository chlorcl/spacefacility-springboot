package me.chlorcl.spacefacility.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.items.categories.ItemCategory;
import me.chlorcl.spacefacility.launches.Launch;
import me.chlorcl.spacefacility.misions.Mission;
import me.chlorcl.spacefacility.storages.Storage;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class Item {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String description;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "item_category_id")
        private ItemCategory itemCategory;

        @JsonIgnore
        @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinTable (
                name = "storage_items",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "storage_id")
        )
        private Set<Storage> storages = new HashSet<>();

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinTable(
                name = "mission_items",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "mission_id")
        )
        private Set<Mission> missions = new HashSet<>();

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinTable (
                name = "launch_items",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "launch_id")
        )
        private Set<Launch> launches = new HashSet<>();

}