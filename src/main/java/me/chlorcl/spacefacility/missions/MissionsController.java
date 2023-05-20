package me.chlorcl.spacefacility.missions;

import lombok.RequiredArgsConstructor;
import me.chlorcl.spacefacility.mision.Mission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/missions")
public class MissionsController {

    private final MissionsService missionsService;

    @GetMapping
    public ResponseEntity<List<Mission>> getAllMissions() {
        return ResponseEntity.ok(missionsService.getAllMissions());
    }

    @GetMapping("/done")
    public ResponseEntity<List<Mission>> getMissionsByDone() {
        return ResponseEntity.ok(missionsService.getMissionsByDone(true));
    }

}
