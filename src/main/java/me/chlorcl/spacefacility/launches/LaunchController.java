package me.chlorcl.spacefacility.launches;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/launches")
@RequiredArgsConstructor

public class LaunchController {
    private final LaunchService launchService;

    @GetMapping
    public ResponseEntity<List<Launch>> getAllLaunches() {
        return ResponseEntity.ok(launchService.getAllLaunches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Launch> getLaunchesById(@PathVariable String id) {
        return ResponseEntity.ok(launchService.getLaunchesById(Integer.valueOf(id)));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Launch> createLaunches(@RequestBody Launch launches) {
        return ResponseEntity.ok(launchService.createLaunches(launches));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<Launch> updateLaunches(@RequestBody Launch launches) {
        return ResponseEntity.ok(launchService.updateLaunches(launches));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Void> deleteLaunches(@RequestBody Integer id) {
        launchService.deleteLaunches(id);
        return ResponseEntity.ok().build();
    }
}
