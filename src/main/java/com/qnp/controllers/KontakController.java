package com.qnp.controllers;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.qnp.entitys.KontakEntity;
import com.qnp.services.KontakService;
import com.qnp.services.JsonPlaceholderService;


@RestController
@RequestMapping("/api/kontak")
@Validated
public class KontakController {
     @Autowired
    private KontakService kontakService;

    @Autowired
    private JsonPlaceholderService jsonPlaceholderService;


    // Get all contacts
    @GetMapping
    public ResponseEntity<List<KontakEntity>> getAllKontak() {
    
        List<KontakEntity> kontakList = kontakService.getAllKontak();
        return new ResponseEntity<>(kontakList, HttpStatus.OK);
    }

    // Get contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<KontakEntity> getKontakById(@PathVariable("id") UUID id) {
        KontakEntity kontak = kontakService.getKontakById(id);
        if (kontak != null) {
            return new ResponseEntity<>(kontak, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create new contact
    @PostMapping
    public ResponseEntity<KontakEntity> createKontak(@RequestBody KontakEntity kontak) {
        KontakEntity createdKontak = kontakService.createKontak(kontak);
        return new ResponseEntity<>(createdKontak, HttpStatus.CREATED);
    }

    // Update contact
    @PutMapping("/{id}")
    public ResponseEntity<KontakEntity> updateKontak(@PathVariable("id") UUID id, @RequestBody KontakEntity kontakDetails) {
        KontakEntity updatedKontak = kontakService.updateKontak(id, kontakDetails);
        if (updatedKontak != null) {
            return new ResponseEntity<>(updatedKontak, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKontak(@PathVariable("id") UUID id) {
        kontakService.deleteKontak(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/jsonplaceholder")
    public ResponseEntity<Object> jsonplaceholder() {
        return new ResponseEntity<>(jsonPlaceholderService.fetchDataFromJsonPlaceholder(), HttpStatus.OK);
    }

}
