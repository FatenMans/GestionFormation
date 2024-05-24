package com.example.jwtauth.Controllers;
import com.example.jwtauth.Entity.Formateur;
import com.example.jwtauth.Service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/formateurs")
public class FormateurController {

    private final FormateurService formateurService;

    @Autowired
    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Formateur>> getAllFormateurs() {
        List<Formateur> formateurs = formateurService.getAllFormateurs();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable("id") Long id) {
        Optional<Formateur> formateur = formateurService.getFormateurById(id);
        return formateur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        Formateur newFormateur = formateurService.saveFormateur(formateur);
        return new ResponseEntity<>(newFormateur, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable("id") Long id) {
        formateurService.deleteFormateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

