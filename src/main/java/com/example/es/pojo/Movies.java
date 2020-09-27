package com.example.es.pojo;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhwu
 * 如果es服务器上没有movies索引，项目启动时会自动创建，并使用下面定义的分词器
 * 如果es服务器上已经存在了movies索引，下面定义的属性会失效，因为es的索引不允许覆盖，只能先删除，再新建
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
