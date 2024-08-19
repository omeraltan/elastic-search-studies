package com.omer.elastic.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MusteriSaveRequestDto {

    String ad;
    String soyad;
    Long yas;
}
