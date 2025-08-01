package com.eazybytes.backend.repository;

import com.eazybytes.backend.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
    Optional<Title> findByTitle(String title);
}
