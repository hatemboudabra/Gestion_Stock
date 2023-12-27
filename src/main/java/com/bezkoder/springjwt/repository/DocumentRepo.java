package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Long> {

//    List<Document> findAllByActualityAndInteraction( actuality);
}
