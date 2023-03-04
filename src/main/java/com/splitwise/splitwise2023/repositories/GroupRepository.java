package com.splitwise.splitwise2023.repositories;

import com.splitwise.splitwise2023.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Optional<Group> findById(Long id);
}
