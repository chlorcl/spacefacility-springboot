package me.chlorcl.spacefacility.professions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionService {
    private final ProfessionRepository professionRepository;

    public Profession createProfession(Profession profession) {
        return professionRepository.save(profession);
    }

    public Profession getProfessionById(Integer id) {
        return professionRepository.findById(id).orElseThrow();
    }

    public Profession updateProfession(Profession profession) {
        return professionRepository.save(profession);
    }

    public void deleteProfession(Integer id) {
        professionRepository.deleteById(id);
    }

    public List<Profession> getAllProfessions() {
        return professionRepository.findAll();
    }
}
