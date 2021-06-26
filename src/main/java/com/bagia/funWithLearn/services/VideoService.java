package com.bagia.funWithLearn.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bagia.funWithLearn.entities.ImgMaster;
import com.bagia.funWithLearn.entities.Video;
import com.bagia.funWithLearn.repositories.VideoRepository;
import com.bagia.funWithLearn.requests.VideoDTO;
import com.bagia.funWithLearn.responses.VideoResponse;

@Component
public class VideoService {

	@Autowired
	private VideoRepository repo;

	@Autowired
	private ImageService imgService;

	@Value("${app.server}")
	private String serverAddress;

	public VideoResponse createNewVideo(VideoDTO dto) {
		if (dto.getUrl() == null || dto.getTitle() == null || dto.getImgId() == null) {
			return null;
		}
		Video video = new Video();
		BeanUtils.copyProperties(dto, video);
		try {
			ImgMaster img = imgService.getImage(dto.getImgId());
			if (img == null) {
				return null;
			}
			video.setVideoImage(img);
			video.setCreated_on(LocalDate.now());
			repo.save(video);
			VideoResponse res = new VideoResponse();
			BeanUtils.copyProperties(video, res);
			res.setImageUrl(serverAddress + "images/download/" + video.getVideoImage().getImgId());
			return res;
		} catch (Exception e) {
			System.out.println("Error in creating video: " + e);
			return null;
		}
	}

	public boolean deleteVideo(Long videoId) {
		try {
			Video v = repo.findByVideoId(videoId);
			imgService.deleteImage(v.getVideoImage());
			repo.delete(v);
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete video: " + e);
			return false;
		}
	}

	public List<VideoResponse> getAllVideos() {
		try {
			List<Video> videos = repo.findAll();
			List<VideoResponse> res = new ArrayList<>();
			for (Video v : videos) {
				VideoResponse rsp = new VideoResponse();
				BeanUtils.copyProperties(v, rsp);
				rsp.setImageUrl(serverAddress + "images/download/" + v.getVideoImage().getImgId());
				res.add(rsp);
			}
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
