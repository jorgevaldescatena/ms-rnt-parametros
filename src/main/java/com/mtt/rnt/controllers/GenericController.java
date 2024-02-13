package com.mtt.rnt.controllers;

import com.mtt.rnt.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/generic", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenericController<T> {

    @Autowired
    GenericService<T> genericService;

    @GetMapping("/data-count")
    public ResponseEntity<Long> getDataCount() {
        Long count = genericService.getDataCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/data-count-criteria")
    public ResponseEntity<Long> getDataCountWithCriteria(@RequestBody Map<String, Map<String, Object>> criteria) {
        Long count = genericService.getDataCount(criteria);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/data-count-criteria-optional")
    public ResponseEntity<Long> getDataCountWithCriteriaOptional(@RequestBody Map<String, Object> simpleCriteria,
                                                                 @RequestBody List<Map<String, Object>> optionalsCriteria) {
        Long count = genericService.getDataCount(simpleCriteria, optionalsCriteria);
        return ResponseEntity.ok(count);
    }

}
