package me.chlorcl.spacefacility.storages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageRepository storageRepository;

    public Storage createStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    public Storage getStorageById(Integer id) {
        return storageRepository.findById(id).orElseThrow();
    }

    public Storage updateStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    public void deleteStorage(Integer id) {
        storageRepository.deleteById(id);
    }

    public List<Storage> getAllStorages() {
        return storageRepository.findAll();
    }
}
