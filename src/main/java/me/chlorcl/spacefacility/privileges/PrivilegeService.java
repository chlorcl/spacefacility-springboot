package me.chlorcl.spacefacility.privileges;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivilegeService {
    private final PrivilegeRepository privilegeRepository;

    public Privilege createPrivilege(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    public Privilege getPrivilegeById(Integer id) {
        return privilegeRepository.findById(id).orElseThrow();
    }

    public Privilege updatePrivilege(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    public void deletePrivilege(Integer id) {
        privilegeRepository.deleteById(id);
    }

    public List<Privilege> getAllPrivileges() {
        return privilegeRepository.findAll();
    }
}
