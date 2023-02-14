package com.digitalfilingcabinet.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.digitalfilingcabinet.demo.models.Files;
import com.digitalfilingcabinet.demo.models.data.FilesRepository;

@Service
public class FileStorageService {

    @Autowired
    private FilesRepository filesRepository;

    public Files store(MultipartFile file) throws IOException {
        String name = StringUtils.cleanPath(file.getOriginalName());
        Files files = new Files(name, file.getContentType(), file.getBytes());

        return FilesRepository.save(Files);
    }

    public Files getFile(Integer id) {
        return FilesRepository.findById(id).get();
    }

    public Stream<Files> getAllFiles() {
        return Files.findAll().stream();
    }
}
