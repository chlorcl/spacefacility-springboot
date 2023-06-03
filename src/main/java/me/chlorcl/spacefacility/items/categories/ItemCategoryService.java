package me.chlorcl.spacefacility.items.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemCategoryService {

    private final ItemCategoryRepository ItemCategoryRepository;

    public Optional<ItemCategory> getItemCategoryById(Integer id) {
        return ItemCategoryRepository.findById(id);
    }

    public ItemCategory createItemCategory(ItemCategory ItemCategory) {
        return ItemCategoryRepository.save(ItemCategory);
    }

    public ItemCategory updateItemCategory(ItemCategory ItemCategory) {
        return ItemCategoryRepository.save(ItemCategory);
    }

    public void deleteItemCategory(Integer id) {
        ItemCategoryRepository.deleteById(id);
    }

    public List<ItemCategory> getAllItemCategories() {
        return ItemCategoryRepository.findAll();
    }

}
