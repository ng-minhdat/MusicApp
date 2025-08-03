package com.eazybytes.backend.mapper;

import com.eazybytes.backend.dto.TitleDto;
import com.eazybytes.backend.model.Title;

public class TitleMapper {
    private TitleMapper() {}

    public static Title mapToTitle(TitleDto titleDto, Title title) {
        title.setTitle(titleDto.getTitle());
        title.setYear(titleDto.getYear());
        title.setGenreId(titleDto.getGenreId());
        title.setCountry(titleDto.getCountry());
        return title;
    }

    public static TitleDto mapToTitleDto(Title title, TitleDto titleDto) {
        titleDto.setTitleId(title.getTitleId());
        titleDto.setTitle(title.getTitle());
        titleDto.setYear(title.getYear());
        titleDto.setGenreId(title.getGenreId());
        titleDto.setCountry(title.getCountry());
        return titleDto;
    }
}
