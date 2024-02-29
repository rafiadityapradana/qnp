package com.qnp.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qnp.entitys.KontakEntity;
import com.qnp.repositorys.KontakRepository;

@Service
public class KontakService {

     
     @Autowired
     private KontakRepository kontakRepository;

     public List<KontakEntity> getAllKontak() {
          return kontakRepository.findAll();
     }

     public KontakEntity getKontakById(UUID id) {
          return kontakRepository.findById(id).orElse(null);
     }

     public KontakEntity createKontak(KontakEntity kontak) {
          
          try {
               return kontakRepository.saveAndFlush(kontak);
          } catch (Exception e) {
               // TODO: handle exception
               System.out.println(e);
               return null;
          }
          
     }

     public KontakEntity updateKontak(UUID id, KontakEntity kontakDetails) {
          KontakEntity existingKontak = kontakRepository.findById(id).orElse(null);
          if (existingKontak != null) {
               existingKontak.setNama(kontakDetails.getNama());
               existingKontak.setEmail(kontakDetails.getEmail());
               existingKontak.setPassword(kontakDetails.getPassword());
               existingKontak.setTelepon(kontakDetails.getTelepon());
               existingKontak.setAlamat(kontakDetails.getAlamat());
               return kontakRepository.save(existingKontak);
          }
          return null;
     }

     public void deleteKontak(UUID id) {
          kontakRepository.deleteById(id);
     }
}