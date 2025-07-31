package com.eazybytes.backend.service;

import com.eazybytes.backend.dto.GenreDto;
import com.eazybytes.backend.exception.GenreAlreadyExistsException;
import com.eazybytes.backend.exception.ResourceNotFoundException;
import com.eazybytes.backend.mapper.GenreMapper;
import com.eazybytes.backend.model.Genre;
import com.eazybytes.backend.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public void createGenre(GenreDto genreDto) {
        Optional<Genre> optionalGenre = genreRepository.findByGenreName(genreDto.getGenreName());
        if (optionalGenre.isPresent()) {
            throw new GenreAlreadyExistsException(String.format("Genre with name %s already exists", genreDto.getGenreName()));
        }
        Genre newGenre = GenreMapper.mapToGenre(genreDto, new Genre());
        genreRepository.save(newGenre);
    }

    public void updateGenre(GenreDto genreDto) {
        Optional<Genre> optionalGenre = genreRepository.findByGenreName(genreDto.getGenreName());
        if (optionalGenre.isEmpty()) {
            throw new ResourceNotFoundException("Genre", "name", genreDto.getGenreName());
        }
        GenreMapper.mapToGenre(genreDto, optionalGenre.get());
        genreRepository.save(optionalGenre.get());
    }

    public GenreDto getGenre(String genreName) {
        Optional<Genre> optionalGenre = genreRepository.findByGenreName(genreName);
        if (optionalGenre.isEmpty()) {
            throw new ResourceNotFoundException("Genre", "name", genreName);
        }
        GenreDto genreDto = GenreMapper.mapToGenreDto(optionalGenre.get(), new GenreDto());
        return genreDto;
    }

    public void deleteGenre(String genreName) {
        Optional<Genre> optionalGenre = genreRepository.findByGenreName(genreName);
        if (optionalGenre.isEmpty()) {
            throw new ResourceNotFoundException("Genre", "name", genreName);
        }
        genreRepository.delete(optionalGenre.get());
    }
}
