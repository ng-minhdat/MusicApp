package com.eazybytes.backend.mapper;

import com.eazybytes.backend.dto.ArtistDto;
import com.eazybytes.backend.model.Artist;

public class ArtistMapper {
    private ArtistMapper() {}

    public static Artist mapToArtist(ArtistDto artistDto, Artist artist) {
        artist.setName(artistDto.getName());
        artist.setDateOfBirth(artistDto.getDateOfBirth());
        artist.setCountry(artistDto.getCountry());
        artist.setImagePath(artistDto.getImagePath());
        return artist;
    }

    public static ArtistDto mapToArtistDto(Artist artist, ArtistDto artistDto) {
        artistDto.setArtistId(artist.getArtistId());
        artistDto.setName(artist.getName());
        artistDto.setDateOfBirth(artist.getDateOfBirth());
        artistDto.setCountry(artist.getCountry());
        artistDto.setImagePath(artist.getImagePath());
        return artistDto;
    }
}
