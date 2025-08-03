package com.eazybytes.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Song extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    private Long titleId;
    private LocalDate releaseDate;
    private Long artistId;
    private int length;
    private Long userId;
    private String path;
}
