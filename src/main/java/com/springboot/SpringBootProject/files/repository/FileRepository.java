package com.springboot.SpringBootProject.files.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.models.ImageModel;

@Repository
public interface FileRepository extends JpaRepository<ImageModel,Integer>{

	Optional<ImageModel> findByName(String name);

}
