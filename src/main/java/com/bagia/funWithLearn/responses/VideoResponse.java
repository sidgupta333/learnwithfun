package com.bagia.funWithLearn.responses;

public class VideoResponse {

	private Long videoId;
	private String title;
	private String url;
	private String imageUrl;

	public VideoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoResponse(Long videoId, String title, String url, String imageUrl) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.url = url;
		this.imageUrl = imageUrl;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
