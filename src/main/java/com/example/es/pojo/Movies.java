package com.example.es.pojo;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhwu(zhwu @ tmindtech.com)
 */
@Document(indexName = "movies")
public class Movies implements Serializable {
    @Id
    private Long id;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String title;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String director;

    private Integer year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
