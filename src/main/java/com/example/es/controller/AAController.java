package com.example.es.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.es.mapper.MoviesRepository;
import com.example.es.pojo.CoinExcel;
import com.example.es.pojo.Movies;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wuzh on 2020/9/22.
 * Description:
 */
@RestController
public class AAController {
    @Autowired
    private MoviesRepository repository;

    @GetMapping("/index")
    public Page<Movies> getIndex(@RequestParam("title") String title,
                           @RequestParam("director") String director,
                           @RequestParam("year") Integer year,
                           @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                           @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Movies> movies = repository.findByTitleOrDirectorOrYear(title, director, year, pageable);
        return movies;
    }

    @PostMapping("/import")
    public void importCoins(@RequestParam(value = "filename") MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<CoinExcel> list;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), CoinExcel.class, params);
        } catch (Exception ex) {
            throw new RuntimeException("导入失败。请检查格式。");
        }
        System.out.println(list.get(0).toString());
        System.err.println(new Date());
    }
}
