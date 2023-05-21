package me.chlorcl.spacefacility.misions;

import me.chlorcl.spacefacility.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer> {
    List<Mission> findByDone(Boolean done);

}
