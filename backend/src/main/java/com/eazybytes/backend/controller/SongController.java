package com.eazybytes.backend.controller;

import com.eazybytes.backend.constants.ResponseConstants;
import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.dto.SongDto;
import com.eazybytes.backend.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/song")
@AllArgsConstructor
public class SongController {
    private final SongService songService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createSong(@RequestBody SongDto songDto) {
        songService.createSong(songDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ResponseConstants.STATUS_201, ResponseConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateSong(@RequestBody SongDto songDto) {
        songService.updateSong(songDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }

    @GetMapping("/get")
    public ResponseEntity<SongDto> getSong(@RequestParam Long songId) {
        SongDto songDto = songService.getSong(songId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(songDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SongDto>> getAllSongs() {
        List<SongDto> songDtos = songService.getAllSongs();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(songDtos);
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<List<SongDto>> getSongsByTitle(@RequestParam String title) {
        List<SongDto> songDtos = songService.getSongsByTitle(title);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(songDtos);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteSong(@RequestParam Long songId) {
        songService.deleteSong(songId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }
}
