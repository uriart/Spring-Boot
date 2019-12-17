package com.uriart.workout.repository;

import com.uriart.workout.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    
}
