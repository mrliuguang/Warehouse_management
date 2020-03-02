package com.hnsic.jpa.respository;

import com.hnsic.jpa.entity.po.Recording;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingRespository extends JpaRepository<Recording,Integer> {
}
