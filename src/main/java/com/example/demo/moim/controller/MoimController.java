package com.example.demo.moim.controller;

import com.example.demo.moim.controller.form.MoimReqForm;
import com.example.demo.moim.controller.form.MoimResForm;
import com.example.demo.moim.service.MoimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/moim")
@RequiredArgsConstructor
@Slf4j
public class MoimController {
    final MoimService moimService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createMoim(@RequestBody MoimReqForm reqForm) {
        log.info("createMoim()");
        return moimService.createMoim(reqForm);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getMoim(@PathVariable Long id) {
        return moimService.requestMoim(id);
    }
    @PostMapping("/{id}/user")
    public ResponseEntity<Map<String, Object>> participateInMoim(@PathVariable Long id) {
        return moimService.participateInMoim(id);
    }
    @GetMapping(value = "/list", params = {"page", "size"})
    public ResponseEntity<Map<String, Object>> getRecentMoimList(@RequestParam Integer page, @RequestParam Integer size) {
        log.info("getRecentMoimList");
        return moimService.getRecentMoimList(page, size);
    }
    @GetMapping("/{id}/joinable")
    public ResponseEntity<Map<String, Object>> getJoinable(@PathVariable Long id) {
        log.info("getJoinable()");
        return moimService.getJoinable(id);
    }
}
