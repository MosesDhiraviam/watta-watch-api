package com.example.wattawatchapi.controllers;

import com.example.wattawatchapi.controller;
import com.example.wattawatchapi.models.showsModel;
import com.example.wattawatchapi.services.showsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shows")
public class showsController extends controller {

    @Autowired
    private showsService showsService;

    @GetMapping("/")
    public ResponseEntity<List<showsModel>> getShows() {
        return success(showsService.getAllShows());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<showsModel> createShow(@Valid @RequestBody showsModel show) {
        return success(showsService.createShow(show));
    }

    @GetMapping("/series")
    public ResponseEntity<List<showsModel>> getTvShows() {
        return success(showsService.getTVSeries());
    }

    @GetMapping("/movies")
    public ResponseEntity<List<showsModel>> getMovies() {
        return success(showsService.getMovies());
    }

    @GetMapping("/featured")
    public ResponseEntity<List<showsModel>> getFeaturedShows(
            @RequestParam(value = "type", required = false) String type) {
        if (type == null || type.equals("movies") || type.equals("series")) {
            return success(showsService.getFeaturedShows(type));
        } else return badRequest();
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<showsModel>> searchShows(
//            @RequestParam("q") String q,
//            @RequestParam(value = "type", required = false) String type) {
//        if (type == null || type.equals("movies") || type.equals("series")) {
//            return success(showsService.searchByQueryAndType(q, type));
//        } else return badRequest();
//    }

    @GetMapping("/details/{id}")
    public ResponseEntity<showsModel> getShowById(@PathVariable("id") String id) {
        Optional<showsModel> show = showsService.getShowById(id);
        if (show.isPresent()) {
            return success(show.get());
        } else {
            return notFound();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<showsModel> updateShowById(
            @PathVariable("id") String id,
            @Valid @RequestBody showsModel show) {

        Optional<showsModel> showData = showsService.getShowById(id);
        if (showData.isPresent()) {
            showsModel _show = showData.get();
            _show.setTitle(show.getTitle());
            _show.setFeatured(show.getFeatured());
            _show.setBanner(show.getBanner());
            _show.setPoster(show.getPoster());
            _show.setDescription(show.getDescription());
            _show.setBuyPrice(show.getBuyPrice());
            _show.setRentPrice(show.getRentPrice());
            return success(showsService.updateShow(_show));
        }
        return notFound();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteShowById(@PathVariable("id") String id) {
        if (showsService.checkById(id)) {
            showsService.deleteShowById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return notFound();
    }
}
