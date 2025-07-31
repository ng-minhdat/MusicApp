package com.eazybytes.backend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ArtistDto {
    private String name;
    private LocalDate dateOfBirth;
    private String country;
    private String imagePath;
}
