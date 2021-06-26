package com.bagia.funWithLearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bagia.funWithLearn.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

	public Video findByVideoId(Long videoId);
}
