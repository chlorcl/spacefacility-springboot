package me.chlorcl.spacefacility.areas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;

    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    public Area getAreaById(Integer id) {
        return areaRepository.findById(id).orElseThrow();
    }

    public Area updateArea(Area area) {
        return areaRepository.save(area);
    }

    public void deleteArea(Integer id) {
        areaRepository.deleteById(id);
    }

    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }
}
