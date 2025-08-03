package com.eazybytes.backend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SongDto {
    private Long songId;
    private Long titleId;
    private LocalDate releaseDate;
    private Long artistId;
    private int length;
    private Long userId;
    private String path;
}
