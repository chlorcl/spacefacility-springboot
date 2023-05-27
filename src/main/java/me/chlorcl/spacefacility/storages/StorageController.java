package me.chlorcl.spacefacility.storages;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/storages")
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<List<Storage>> getAllStorages() {
        return ResponseEntity.ok(storageService.getAllStorages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Storage> getStorageById(@PathVariable String id) {
        return ResponseEntity.ok(storageService.getStorageById(Integer.valueOf(id)));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Storage> createStorage(@RequestBody Storage storage) {
        return ResponseEntity.ok(storageService.createStorage(storage));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<Storage> updateStorage(@RequestBody Storage storage) {
        return ResponseEntity.ok(storageService.updateStorage(storage));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Void> deleteStorage(@RequestBody Integer id) {
        storageService.deleteStorage(id);
        return ResponseEntity.ok().build();
    }
}
