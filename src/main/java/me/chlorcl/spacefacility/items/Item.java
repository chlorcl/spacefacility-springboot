package me.chlorcl.spacefacility.items;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.itemcategories.ItemCategory;
import me.chlorcl.spacefacility.misions.Mission;

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

        @ManyToOne
        @JoinColumn(name = "item_category_id")
        private ItemCategory itemCategoryId;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
            name = "mission_items",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
        )
        private Set<Mission> missionId;

}