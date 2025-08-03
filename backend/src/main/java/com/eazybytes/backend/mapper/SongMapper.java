package com.eazybytes.backend.mapper;

import com.eazybytes.backend.dto.SongDto;
import com.eazybytes.backend.model.Song;

public class SongMapper {
    private SongMapper() {}

    public static Song mapToSong(SongDto songDto, Song song) {
        song.setTitleId(songDto.getTitleId());
        song.setReleaseDate(songDto.getReleaseDate());
        song.setArtistId(songDto.getArtistId());
        song.setLength(songDto.getLength());
        song.setUserId(songDto.getUserId());
        song.setPath(songDto.getPath());
        return song;
    }

    public static SongDto mapToSongDto(Song song, SongDto songDto) {
        songDto.setSongId(song.getSongId());
        songDto.setTitleId(song.getTitleId());
        songDto.setReleaseDate(song.getReleaseDate());
        songDto.setArtistId(song.getArtistId());
        songDto.setLength(song.getLength());
        songDto.setUserId(song.getUserId());
        songDto.setPath(song.getPath());
        return songDto;
    }
}
