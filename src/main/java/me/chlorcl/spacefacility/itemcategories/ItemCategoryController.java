package me.chlorcl.spacefacility.itemcategories;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory) {
        return ResponseEntity.ok(itemCategoryService.createItemCategory(itemCategory));
    }

    @PutMapping
    public ResponseEntity<ItemCategory> updateItemCategory(@RequestBody ItemCategory itemCategory) {
        return ResponseEntity.ok(itemCategoryService.updateItemCategory(itemCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemCategory(@PathVariable String id) {
        itemCategoryService.deleteItemCategory(Integer.valueOf(id));
        return ResponseEntity.ok().build();
    }

}
