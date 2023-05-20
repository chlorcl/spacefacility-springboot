package me.chlorcl.spacefacility.missions;

import lombok.RequiredArgsConstructor;
import me.chlorcl.spacefacility.mision.Mission;
import me.chlorcl.spacefacility.mision.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionsService {
    private final MissionRepository missionRepository;

    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    public List<Mission> getMissionsByDone(Boolean done) {
        return missionRepository.findByDone(done);
    }

}
