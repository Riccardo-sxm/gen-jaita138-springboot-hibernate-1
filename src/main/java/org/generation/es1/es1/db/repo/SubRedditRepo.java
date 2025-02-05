package org.generation.es1.es1.db.repo;

import org.generation.es1.es1.db.entity.SubReddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRedditRepo extends JpaRepository<SubReddit, Long> {

}
