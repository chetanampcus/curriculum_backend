package com.highscope.curriculum.repository;

import com.highscope.curriculum.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SiteRepository extends JpaRepository<Site, UUID> {
    List<Site> findAllByIsDeletedFalse();

    Optional<Site> findByIdAndIsDeletedFalse(UUID id);
}
