package com.example.wattawatchapi.services;

import com.example.wattawatchapi.models.showsModel;
import com.example.wattawatchapi.repositories.showsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class showsService {

    @Autowired
    private showsRepository showRepository;

    public Optional<showsModel> getShowById(String id) {
        return showRepository.findById(id);
    }

    public showsModel createShow(showsModel show) {
        return showRepository.save(show);
    }

    public Boolean checkById(String id) {
        return showRepository.existsById(id);
    }

    public void deleteShowById(String id) {
        showRepository.deleteById(id);
    }

    public List<showsModel> getTVSeries() {
        return showRepository.findShowsByType("series");
    }

    public List<showsModel> getMovies() {
        return showRepository.findShowsByType("movies");
    }

    public List<showsModel> getAllShows() {
        return showRepository.findAll();
    }

    public showsModel updateShow(showsModel show) {
        return showRepository.save(show);
    }

    public List<showsModel> getFeaturedShows(@Nullable String type) {
        if (type == null) return showRepository.findByFeaturedTrue();
        return showRepository.findByTypeAndFeaturedTrue(type);
    }
}