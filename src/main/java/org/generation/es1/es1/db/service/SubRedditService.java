package org.generation.es1.es1.db.service;

import java.util.List;

import org.generation.es1.es1.db.entity.SubReddit;
import org.generation.es1.es1.db.repo.SubRedditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubRedditService {

    @Autowired
    private SubRedditRepo subRedditRepo;

    public List<SubReddit> findAll() {

        return subRedditRepo.findAll();
    }

    public void save(SubReddit subReddit) {

        subRedditRepo.save(subReddit);
    }

    public SubReddit findById(Long id) {

        return subRedditRepo.findById(id).orElse(null);
    }

}
