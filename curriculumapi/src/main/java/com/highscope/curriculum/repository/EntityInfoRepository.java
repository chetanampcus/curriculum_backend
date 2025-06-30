package com.highscope.curriculum.repository;

import com.highscope.curriculum.model.EntityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityInfoRepository extends JpaRepository<EntityInfo, Long> {
}
