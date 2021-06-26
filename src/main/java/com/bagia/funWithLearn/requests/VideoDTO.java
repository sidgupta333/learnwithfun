package com.bagia.funWithLearn.requests;

public class VideoDTO {

	private String title;
	private String url;
	private Long imgId;

	public VideoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoDTO(String title, String url, Long imgId) {
		super();
		this.title = title;
		this.url = url;
		this.imgId = imgId;
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

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

}
