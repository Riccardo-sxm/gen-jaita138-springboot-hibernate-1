package org.generation.es1.es1.db.service;

import java.util.List;

import org.generation.es1.es1.db.entity.Ruolo;
import org.generation.es1.es1.db.repo.RuoloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepo ruoloRepo;

    public List<Ruolo> findAll() {
        return ruoloRepo.findAll();
    }

    public void save(Ruolo ruolo) {
        ruoloRepo.save(ruolo);
    }

    public Ruolo findById(Long id) {
        return ruoloRepo.findById(id).orElse(null);
    }
}
