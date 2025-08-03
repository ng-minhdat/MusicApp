package com.eazybytes.backend.repository;

import com.eazybytes.backend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByPath(String path);
    List<Song> findByTitleId(Long titleId);
}
