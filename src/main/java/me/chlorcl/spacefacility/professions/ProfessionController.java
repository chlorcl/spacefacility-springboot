package me.chlorcl.spacefacility.professions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/professions")
@RequiredArgsConstructor
public class ProfessionController {
    private final ProfessionService professionService;

    @GetMapping
    public ResponseEntity<List<Profession>> getAllProfessions() {
        return ResponseEntity.ok(professionService.getAllProfessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profession> getProfessionById(@PathVariable String id) {
        return ResponseEntity.ok(professionService.getProfessionById(Integer.valueOf(id)));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Profession> createProfession(@RequestBody Profession profession) {
        return ResponseEntity.ok(professionService.createProfession(profession));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<Profession> updateProfession(@RequestBody Profession profession) {
        return ResponseEntity.ok(professionService.updateProfession(profession));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Void> deleteProfession(@RequestBody Integer id) {
        professionService.deleteProfession(id);
        return ResponseEntity.ok().build();
    }
}
