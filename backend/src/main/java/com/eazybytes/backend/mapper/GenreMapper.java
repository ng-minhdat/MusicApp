package com.eazybytes.backend.mapper;

import com.eazybytes.backend.dto.GenreDto;
import com.eazybytes.backend.model.Genre;

public class GenreMapper {
    private GenreMapper() {}

    public static Genre mapToGenre(GenreDto genreDto, Genre genre) {
        genre.setGenreName(genreDto.getGenreName());
        return genre;
    }

    public static GenreDto mapToGenreDto(Genre genre, GenreDto genreDto) {
        genreDto.setGenreId(genre.getGenreId());
        genreDto.setGenreName(genre.getGenreName());
        return genreDto;
    }
}
