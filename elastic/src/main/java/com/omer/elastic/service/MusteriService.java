package com.omer.elastic.service;

import com.omer.elastic.domain.Musteri;
import com.omer.elastic.dto.request.MusteriSaveRequestDto;
import com.omer.elastic.repository.MusteriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusteriService {
    private final MusteriRepository repository;


    public Musteri save(MusteriSaveRequestDto dto) {
        return repository.save(Musteri.builder()
                .ad(dto.getAd())
                .soyad(dto.getSoyad())
                .adSoyad(dto.getAd()+ " " +dto.getSoyad())
                .yas(dto.getYas())
                .isActive(true)
            .build());
    }

    public Iterable<Musteri> findAll() {
        return repository.findAll();
    }
}
