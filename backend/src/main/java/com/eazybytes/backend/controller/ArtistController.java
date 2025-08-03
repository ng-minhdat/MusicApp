package com.eazybytes.backend.controller;

import com.eazybytes.backend.constants.ResponseConstants;
import com.eazybytes.backend.dto.ArtistDto;
import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.service.ArtistService;
import com.eazybytes.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
@AllArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createArtist(@RequestBody ArtistDto artistDto) {
        artistService.createArtist(artistDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ResponseConstants.STATUS_201, ResponseConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateArtist(@RequestBody ArtistDto artistDto) {
        artistService.updateArtist(artistDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }

    @GetMapping("/get")
    public ResponseEntity<ArtistDto> getArtist(@RequestParam String name) {
        ArtistDto artistDto = artistService.getArtist(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(artistDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ArtistDto>> getAllArtists() {
        List<ArtistDto> artistDtos = artistService.getAllArtists();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(artistDtos);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteArtist(@RequestParam String name) {
        artistService.deleteArtist(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }
}
