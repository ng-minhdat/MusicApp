package com.eazybytes.backend.service;

import com.eazybytes.backend.dto.SongDto;
import com.eazybytes.backend.exception.ResourceNotFoundException;
import com.eazybytes.backend.exception.SongAlreadyExistsException;
import com.eazybytes.backend.mapper.SongMapper;
import com.eazybytes.backend.model.Artist;
import com.eazybytes.backend.model.Song;
import com.eazybytes.backend.model.Title;
import com.eazybytes.backend.model.User;
import com.eazybytes.backend.repository.ArtistRepository;
import com.eazybytes.backend.repository.SongRepository;
import com.eazybytes.backend.repository.TitleRepository;
import com.eazybytes.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final TitleRepository titleRepository;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;

    public void createSong(SongDto songDto) {
        Optional<Song> optionalSong = songRepository.findByPath(songDto.getPath());
        if (optionalSong.isPresent()) {
            throw new SongAlreadyExistsException(String.format("Song with path %s already exists", songDto.getPath()));
        }
        Optional<Title> optionalTitle = titleRepository.findById(songDto.getTitleId());
        if (optionalTitle.isEmpty()) {
            throw new ResourceNotFoundException("Title", "titleId", songDto.getTitleId().toString());
        }
        Optional<Artist> optionalArtist = artistRepository.findById(songDto.getArtistId());
        if (optionalArtist.isEmpty()) {
            throw new ResourceNotFoundException("Artist", "artistId", songDto.getArtistId().toString());
        }
        Optional<User> optionalUser = userRepository.findById(songDto.getUserId());
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "userId", songDto.getUserId().toString());
        }
        Song song = SongMapper.mapToSong(songDto, new Song());
        songRepository.save(song);
    }

    public void updateSong(SongDto songDto) {
        if (songDto.getSongId() == null) {
            throw new ResourceNotFoundException("Song", "songId", null);
        } else if (songRepository.findById(songDto.getSongId()).isEmpty()) {
            throw new ResourceNotFoundException("Song", "songId", songDto.getSongId().toString());
        }
        Optional<Song> optionalSong = songRepository.findByPath(songDto.getPath());
        if (optionalSong.isEmpty()) {
            throw new ResourceNotFoundException("Song", "path", songDto.getPath());
        }
        Optional<Title> optionalTitle = titleRepository.findById(songDto.getTitleId());
        if (optionalTitle.isEmpty()) {
            throw new ResourceNotFoundException("Title", "titleId", songDto.getTitleId().toString());
        }
        Optional<Artist> optionalArtist = artistRepository.findById(songDto.getArtistId());
        if (optionalArtist.isEmpty()) {
            throw new ResourceNotFoundException("Artist", "artistId", songDto.getArtistId().toString());
        }
        Optional<User> optionalUser = userRepository.findById(songDto.getUserId());
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "userId", songDto.getUserId().toString());
        }
        SongMapper.mapToSong(songDto, optionalSong.get());
        songRepository.save(optionalSong.get());
    }

    public SongDto getSong(Long songId) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        if (optionalSong.isEmpty()) {
            throw new ResourceNotFoundException("Song", "songId", songId.toString());
        }
        SongDto songDto = SongMapper.mapToSongDto(optionalSong.get(), new SongDto());
        return songDto;
    }

    public List<SongDto> getAllSongs() {
        List<Song> songs = songRepository.findAll();
        return songs.stream()
                .map(song -> SongMapper.mapToSongDto(song, new SongDto()))
                .toList();
    }

    public List<SongDto> getSongsByTitle(String title) {
        Optional<Title> optionalTitle = titleRepository.findByTitle(title);
        if (optionalTitle.isEmpty()) {
            throw new ResourceNotFoundException("Title", "name", title);
        }
        List<Song> songs = songRepository.findByTitleId(optionalTitle.get().getTitleId());
        return songs.stream()
                .map(song -> SongMapper.mapToSongDto(song, new SongDto()))
                .toList();
    }

    public void deleteSong(Long songId) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        if (optionalSong.isEmpty()) {
            throw new ResourceNotFoundException("Song", "songId", songId.toString());
        }
        songRepository.deleteById(songId);
    }
}
