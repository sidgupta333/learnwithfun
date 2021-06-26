package com.bagia.funWithLearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bagia.funWithLearn.entities.Video;
import com.bagia.funWithLearn.requests.VideoDTO;
import com.bagia.funWithLearn.responses.VideoResponse;
import com.bagia.funWithLearn.services.VideoService;
import com.bagia.funWithLearn.responses.GeneralResponse;

@RestController
@CrossOrigin
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoService vService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewVideo(@RequestBody VideoDTO dto) {
		
		VideoResponse res = vService.createNewVideo(dto);
		if (res == null) {
			return ResponseEntity.status(500).body(new GeneralResponse("failure"));
		} else {
			return ResponseEntity.ok(res);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllVideos() {
		List<VideoResponse> res = vService.getAllVideos();
		return ResponseEntity.ok(res);
	}
	
	@DeleteMapping("/remove/{videoId}")
	public ResponseEntity<?> removeVideo(@PathVariable("videoId") Long videoId) {
		boolean result = vService.deleteVideo(videoId);
		if (result) {
			return ResponseEntity.ok(new GeneralResponse("Success"));
		} else {
			return ResponseEntity.status(500).body(new GeneralResponse("Failure"));
		}
	}
	
}
