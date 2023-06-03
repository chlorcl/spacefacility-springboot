package me.chlorcl.spacefacility.items.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itemcategories")
@RequiredArgsConstructor
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @GetMapping
    public ResponseEntity<List<ItemCategory>> getAllItemCategories() {
        return ResponseEntity.ok(itemCategoryService.getAllItemCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable String id) {
        var itemCategory = itemCategoryService.getItemCategoryById(Integer.valueOf(id));
        return itemCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory) {
        return ResponseEntity.ok(itemCategoryService.createItemCategory(itemCategory));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<ItemCategory> updateItemCategory(@RequestBody ItemCategory itemCategory) {
        return ResponseEntity.ok(itemCategoryService.updateItemCategory(itemCategory));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemCategory(@PathVariable String id) {
        itemCategoryService.deleteItemCategory(Integer.valueOf(id));
        return ResponseEntity.ok().build();
    }

}
