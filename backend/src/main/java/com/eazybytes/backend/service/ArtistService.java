package com.eazybytes.backend.service;

import com.eazybytes.backend.dto.ArtistDto;
import com.eazybytes.backend.exception.ArtistAlreadyExistsException;
import com.eazybytes.backend.exception.ResourceNotFoundException;
import com.eazybytes.backend.mapper.ArtistMapper;
import com.eazybytes.backend.model.Artist;
import com.eazybytes.backend.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public void createArtist(ArtistDto artistDto) {
        Optional<Artist> optionalArtist = artistRepository.findByName(artistDto.getName());
        if (optionalArtist.isPresent()) {
            throw new ArtistAlreadyExistsException("Artist with name " + artistDto.getName() + " already exists");
        }
        Artist newArtist = ArtistMapper.mapToArtist(artistDto, new Artist());
        artistRepository.save(newArtist);
    }

    public void updateArtist(ArtistDto artistDto) {
        Optional<Artist> optionalArtist = artistRepository.findByName(artistDto.getName());
        if (optionalArtist.isEmpty()) {
            throw new ResourceNotFoundException("Artist", "name", artistDto.getName());
        }
        ArtistMapper.mapToArtist(artistDto, optionalArtist.get());
        artistRepository.save(optionalArtist.get());
    }

    public ArtistDto getArtist(String name) {
        Optional<Artist> optionalArtist = artistRepository.findByName(name);
        if (optionalArtist.isEmpty()) {
            throw new ResourceNotFoundException("Artist", "name", name);
        }
        ArtistDto artistDto = ArtistMapper.mapToArtistDto(optionalArtist.get(), new ArtistDto());
        return artistDto;
    }

    public List<ArtistDto> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();
        return artists.stream()
                .map(artist -> ArtistMapper.mapToArtistDto(artist, new ArtistDto()))
                .toList();
    }

    public void deleteArtist(String name) {
        Optional<Artist> optionalArtist = artistRepository.findByName(name);
        if (optionalArtist.isEmpty()) {
            throw new ResourceNotFoundException("Artist", "name", name);
        }
        artistRepository.delete(optionalArtist.get());
    }
}
