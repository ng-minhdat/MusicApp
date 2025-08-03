package com.eazybytes.backend.service;

import com.eazybytes.backend.dto.TitleDto;
import com.eazybytes.backend.exception.ResourceNotFoundException;
import com.eazybytes.backend.exception.TitleAlreadyExistsException;
import com.eazybytes.backend.mapper.TitleMapper;
import com.eazybytes.backend.model.Genre;
import com.eazybytes.backend.model.Title;
import com.eazybytes.backend.repository.GenreRepository;
import com.eazybytes.backend.repository.TitleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TitleService {
    private final GenreRepository genreRepository;
    private final TitleRepository titleRepository;

    public void createTitle(TitleDto titleDto) {
        Optional<Genre> optionalGenre = genreRepository.findById(titleDto.getGenreId());
        if (optionalGenre.isEmpty()) {
            throw new ResourceNotFoundException("Genre", "genreId", titleDto.getGenreId().toString());
        }
        Optional<Title> optionalTitle = titleRepository.findByTitle(titleDto.getTitle());
        if (optionalTitle.isPresent()) {
            throw new TitleAlreadyExistsException(String.format("Title with name %s already exists", titleDto.getTitle()));
        }
        Title newTitle = TitleMapper.mapToTitle(titleDto, new Title());
        titleRepository.save(newTitle);
    }

    public void updateTitle(TitleDto titleDto) {
        Optional<Genre> optionalGenre = genreRepository.findById(titleDto.getGenreId());
        if (optionalGenre.isEmpty()) {
            throw new ResourceNotFoundException("Genre", "genreId", titleDto.getGenreId().toString());
        }
        Optional<Title> optionalTitle = titleRepository.findByTitle(titleDto.getTitle());
        if (optionalTitle.isEmpty()) {
            throw new ResourceNotFoundException("Title", "title", titleDto.getTitle());
        }
        TitleMapper.mapToTitle(titleDto, optionalTitle.get());
        titleRepository.save(optionalTitle.get());
    }

    public TitleDto getTitle(String title) {
        Optional<Title> optionalTitle = titleRepository.findByTitle(title);
        if (optionalTitle.isEmpty()) {
            throw new ResourceNotFoundException("Title", "title", title);
        }
        TitleDto titleDto = TitleMapper.mapToTitleDto(optionalTitle.get(), new TitleDto());
        return titleDto;
    }

    public List<TitleDto> getAllTitles() {
        List<Title> titles = titleRepository.findAll();
        return titles.stream()
                .map(title -> TitleMapper.mapToTitleDto(title, new TitleDto()))
                .toList();
    }

    public void deleteTitle(String title) {
        Optional<Title> optionalTitle = titleRepository.findByTitle(title);
        if (optionalTitle.isEmpty()) {
            throw new ResourceNotFoundException("Title", "title", title);
        }
        titleRepository.delete(optionalTitle.get());
    }
}
