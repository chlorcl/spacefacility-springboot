package me.chlorcl.spacefacility.misions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/missions")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    @GetMapping
    public ResponseEntity<Iterable<Mission>> getAllMissions() {
        return ResponseEntity.ok(missionService.getAllMissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable String id) {
        return ResponseEntity.ok(missionService.getMissionById(Integer.valueOf(id)));
    }

    @GetMapping("/done")
    public ResponseEntity<Iterable<Mission>> getMissionsByDone() {
        return ResponseEntity.ok(missionService.getMissionsByDone(true));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Mission> createMission(@RequestBody Mission mission) {
        return ResponseEntity.ok(missionService.createMission(mission));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<Mission> updateMission(@RequestBody Mission mission) {
        return ResponseEntity.ok(missionService.updateMission(mission));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Void> deleteMission(@RequestBody Integer id) {
        missionService.deleteMission(id);
        return ResponseEntity.ok().build();
    }

}