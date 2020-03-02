package com.hnsic.jpa.service;

import com.hnsic.jpa.entity.po.Recording;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecordingService {
    public List<Recording> saveRecordings(List<Recording> vos);
    public Recording saveRecording(Recording vo);
    public Page<Recording> findall(Integer page);
    public int deleteRecording(Integer id);
}
