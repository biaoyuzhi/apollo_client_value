package com.example.es.mapper;

import com.example.es.pojo.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhwu
 */
@Repository
public interface MoviesRepository extends ElasticsearchRepository<Movies, Long> {

    Page<Movies> findByTitleOrDirectorOrYear(String title, String director, Integer year, Pageable page);
}
