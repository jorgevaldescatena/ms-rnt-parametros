package com.mtt.rnt.controllers;

import com.mtt.rnt.services.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/comuna", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComunaController {

    @Autowired
    ComunaService comunaService;

}
