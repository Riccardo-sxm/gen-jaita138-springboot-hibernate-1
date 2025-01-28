package org.generation.es1.es1.db.service;

import java.util.List;

import org.generation.es1.es1.db.entity.Utente;
import org.generation.es1.es1.db.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public void save(Utente utente) {

        utenteRepo.save(utente);
    }

    public void delete(Utente utente) {

        utenteRepo.delete(utente);
    }

    public List<Utente> findAll() {

        return utenteRepo.findAll();
    }

    public Utente findById(Long id) {

        return utenteRepo.findById(id).orElse(null);
    }

}
