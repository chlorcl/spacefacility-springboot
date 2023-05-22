package me.chlorcl.spacefacility.privileges;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/privileges")
@RequiredArgsConstructor
public class PrivilegeController {
    private final PrivilegeService PrivilegeService;

    @GetMapping
        public ResponseEntity<List<Privilege>> getAllPrivileges() {
        return ResponseEntity.ok(PrivilegeService.getAllPrivileges());
    }

    @GetMapping("/{id}")
        public ResponseEntity<Privilege> getPrivilegeById(@PathVariable String id) {
        return ResponseEntity.ok(PrivilegeService.getPrivilegeById(Integer.valueOf(id)));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
        public ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privileges) {
        return ResponseEntity.ok(PrivilegeService.createPrivilege(privileges));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
        public ResponseEntity<Privilege> updatePrivilege(@RequestBody Privilege privileges) {
        return ResponseEntity.ok(PrivilegeService.updatePrivilege(privileges));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
        public ResponseEntity<Void> deletePrivilege(@RequestBody Integer id) {
        PrivilegeService.deletePrivilege(id);
        return ResponseEntity.ok().build();
    }
}
