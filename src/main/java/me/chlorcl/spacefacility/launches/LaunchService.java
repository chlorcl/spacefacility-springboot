package me.chlorcl.spacefacility.launches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaunchService {
    private final LaunchRepository launchRepository;

    @Autowired
    public LaunchService(LaunchRepository launchRepository) {
        this.launchRepository = launchRepository;
    }

    public List<Launch> getAllLaunches() {
        return launchRepository.findAll();
    }

    public Launch getLaunchesById(Integer id) {
        return launchRepository.findById(id).orElse(null);
    }

    public Launch createLaunches(Launch launches) {
        return launchRepository.save(launches);
    }

    public Launch updateLaunches(Launch launches) {
        return launchRepository.save(launches);
    }

    public void deleteLaunches(Integer id) {
        launchRepository.deleteById(id);
    }
}
