package com.bagia.funWithLearn.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long videoId;

	@Column
	private String title;

	@Column
	private String url;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "img_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ImgMaster videoImage;
	
	@Column(nullable = false)
	private LocalDate created_on;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(Long videoId, String title, String url, ImgMaster videoImage, LocalDate created_on) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.url = url;
		this.videoImage = videoImage;
		this.created_on = created_on;
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

	public ImgMaster getVideoImage() {
		return videoImage;
	}

	public void setVideoImage(ImgMaster videoImage) {
		this.videoImage = videoImage;
	}

	public LocalDate getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDate created_on) {
		this.created_on = created_on;
	}

}
