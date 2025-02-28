package com.example.demo.travel.service;

import com.example.demo.travel.controller.dto.TravelDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TravelService {
    ResponseEntity<TravelDto> createTravel(TravelDto reqForm);

    ResponseEntity<List<String>> getCountries();

    ResponseEntity<List<String>> getCities(String country);

    ResponseEntity<List<String>> getAirports();

    ResponseEntity<List<String>> getAirports(String country, String city);

     ResponseEntity<TravelDto>getTravel(String country, String city, String departureAirport);

    ResponseEntity<TravelDto> modifyImg(TravelDto travelDto);

    ResponseEntity<String> getImagePath(String country, String city, String airport);

    ResponseEntity<Map<String, Object>> modifyTravel(TravelDto travelDto);
}
