package me.chlorcl.spacefacility.misions;

import lombok.RequiredArgsConstructor;
import me.chlorcl.spacefacility.items.Item;
import me.chlorcl.spacefacility.items.ItemRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;
    private final ItemRepository itemRepository;

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

    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    public List<Mission> getMissionsByDone(Boolean done) {
        return missionRepository.findByDone(done);
    }


}
