package com.eazybytes.backend.controller;

import com.eazybytes.backend.constants.ResponseConstants;
import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.dto.TitleDto;
import com.eazybytes.backend.service.TitleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/title")
@AllArgsConstructor
public class TitleController {
    private final TitleService titleService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createTitle(@RequestBody TitleDto titleDto) {
        titleService.createTitle(titleDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ResponseConstants.STATUS_201, ResponseConstants.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateTitle(@RequestBody TitleDto titleDto) {
        titleService.updateTitle(titleDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }

    @GetMapping("/get")
    public ResponseEntity<TitleDto> getTitle(@RequestParam String title) {
        TitleDto titleDto = titleService.getTitle(title);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(titleDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteTitle(@RequestParam String title) {
        titleService.deleteTitle(title);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }
}