package com.example.demo.Dao;

import com.example.demo.Model.DockerImages;

public interface DockerImagesMapper {
    int insert(DockerImages record);

    int insertSelective(DockerImages record);
}