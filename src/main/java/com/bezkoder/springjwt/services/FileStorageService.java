package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.Document;
import com.bezkoder.springjwt.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    @Autowired
    private DocumentRepo fileDBRepository;

    public Document store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document FileDB = new Document(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(FileDB);
    }

    public Document getFile(Long id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<Document> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}