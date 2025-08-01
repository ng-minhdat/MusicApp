package com.eazybytes.backend.dto;

import lombok.Data;

@Data
public class TitleDto {
    private String title;
    private int year;
    private Long genreId;
    private String country;
}
