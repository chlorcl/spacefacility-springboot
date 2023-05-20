package me.chlorcl.spacefacility.mision;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;

    public Mission createMission(Mission mission) {
        return missionRepository.save(mission);
    }

    public Mission getMissionById(Integer id) {
        return missionRepository.findById(id).orElseThrow();
    }

    public Mission updateMission(Mission mission) {
        return missionRepository.save(mission);
    }

    public void deleteMission(Integer id) {
        missionRepository.deleteById(id);
    }


}
