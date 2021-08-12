package com.example.wattawatchapi.repositories;

import com.example.wattawatchapi.models.showsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface showsRepository extends MongoRepository<showsModel, String> {
    List<showsModel> findByFeaturedTrue();
    List<showsModel> findByTypeAndFeaturedTrue(String type);
    List<showsModel> findShowsByType(String type);
    List<showsModel> findByTitleContainingIgnoreCase(String title);
    List<showsModel> findShowsByTypeAndTitleContainingIgnoreCase(String type, String title);
}
