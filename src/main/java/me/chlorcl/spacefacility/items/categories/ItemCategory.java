package me.chlorcl.spacefacility.items.categories;

import jakarta.persistence.*;
import lombok.*;
import me.chlorcl.spacefacility.items.Item;
import org.hibernate.Hibernate;

import java.util.Objects;
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

}
