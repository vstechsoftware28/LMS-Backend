package com.lms.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.TablRecordedVideo;

public interface RecordedVideoRepositary extends JpaRepository<TablRecordedVideo, Long> {

}
