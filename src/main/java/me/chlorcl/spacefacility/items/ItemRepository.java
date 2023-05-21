package me.chlorcl.spacefacility.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i INNER JOIN Mission m ON i.missionId = m.id WHERE m.id = ?1")
    List<Item> findByMissionId(Integer id);

}
