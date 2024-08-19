package com.omer.elastic.repository;

import com.omer.elastic.domain.Musteri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface MusteriRepository extends ElasticsearchRepository<Musteri, String> {
    Iterable<Musteri> findAllByAdLike(String ad);


    /**
     * POST musteri/_search
     * {
     *     "query":{
     *         "bool":{
     *             "must":{
     *                 {"query_string":{"query":"?", "fields":["ad"]}},
     *                 {"query_string":{"query":"?", "fields":["soyad"]}}
     *             }
     *         }
     *     }
     * }
     *
     */
    List<Musteri> findAllByAdAndSoyad(String ad, String soyad);

    @Query("select m from Musteri")
    Stream<Musteri> findAllStream();

    Page<Musteri> findAllByAdLike(String ad, Pageable pageable);

    @Async
    Future<Musteri> findAllByAd(String ad);

    @Query("{\"match\":{\"ad\": {\"query\": \"?0\"}}}")
    Page<Musteri> getirAdinaGore(String ad, Pageable pageable);

    @Query("""
            {
                "bool":{
                    "must":[
                        {
                            "term":{
                                "ad": "#{#ad}"
                            }
                        }
                    ]
                }
            }
        """)
    List<Musteri> bulBakayimBulabilirsen(String ad);

    List<Musteri> findTop10ByAd(String ad);
    List<Musteri> findAllByAdOrSoyad(String ad, String soyad);
    List<Musteri> findAllBySoyadContaining(String soyad);
    List<Musteri> findAllByYasBetween(Long start, Long end);
    List<Musteri> findAllByYasGreaterThanEqual(Long yas);
    List<Musteri> findAllByAdIn(List<String> adlar);
    List<Musteri> findAllByAdStartingWith(String ad);
    List<Musteri> findAllByIsActiveTrue();
}

/**
 *
 * Repository Query Keywords
 * findAllBy
 * findBy
 * read...
 * get...
 * search...
 * stream...By
 * exists...
 * count...
 * delete...
 * remove...
 * findTop -> 1 sonuc
 * findTop5 -> 5 sonuc
 * findTop5ByUserName
 * --------------------
 *
 * Repository Return Types
 * List
 * Iterable
 * Iterator
 * Collection<>
 * Optional
 * Stream
 * Future
 * Slice
 * Page
 * Window
 * GeoResult
 *
 *
 *
 */

