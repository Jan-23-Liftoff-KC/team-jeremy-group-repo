package com.digitalfilingcabinet.demo.models.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalfilingcabinet.demo.models.Files;

@Repository
public interface FilesRepository extends JpaRepository<Files, Integer> {
}
