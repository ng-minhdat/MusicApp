package com.eazybytes.backend.controller;

import com.eazybytes.backend.constants.ResponseConstants;
import com.eazybytes.backend.dto.GenreDto;
import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/genre")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createGenre(@RequestBody GenreDto genreDto) {
        genreService.createGenre(genreDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ResponseConstants.STATUS_201, ResponseConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateGenre(@RequestBody GenreDto genreDto) {
        genreService.updateGenre(genreDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }

    @GetMapping("/get")
    public ResponseEntity<GenreDto> getGenre(@RequestParam String genreName) {
        GenreDto genreDto = genreService.getGenre(genreName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(genreDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteGenre(@RequestParam String genreName) {
        genreService.deleteGenre(genreName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }
}
