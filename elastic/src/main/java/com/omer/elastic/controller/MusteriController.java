package com.omer.elastic.controller;


import com.omer.elastic.domain.Musteri;
import com.omer.elastic.dto.request.MusteriSaveRequestDto;
import com.omer.elastic.service.MusteriService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.omer.elastic.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MUSTERI)
public class MusteriController {
    private final MusteriService musteriService;

    @PostMapping(SAVE)
    public ResponseEntity<Musteri> save(@RequestBody MusteriSaveRequestDto dto){
        return ResponseEntity.ok( musteriService.save(dto));
    }

    @GetMapping(GETALL)
    public ResponseEntity<Iterable<Musteri>> getAll(){
        return ResponseEntity.ok(musteriService.findAll());
    }

}
