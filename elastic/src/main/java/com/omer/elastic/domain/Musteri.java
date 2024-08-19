package com.omer.elastic.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.domain.Range;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "musteri")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Musteri {

    @Id
    String id;
    String ad;
    String soyad;
    @Transient
    String adSoyad;
    Long yas;
    Boolean isActive;





}
