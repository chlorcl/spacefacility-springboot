package me.chlorcl.spacefacility.itemcategories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.items.Item;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="item_categories")
public class ItemCategory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String description;

        @OneToMany(mappedBy = "itemCategoryId")
        private Set<Item> itemId;


}
