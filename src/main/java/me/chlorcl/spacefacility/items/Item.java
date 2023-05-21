package me.chlorcl.spacefacility.items;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chlorcl.spacefacility.itemcategories.ItemCategory;

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

}