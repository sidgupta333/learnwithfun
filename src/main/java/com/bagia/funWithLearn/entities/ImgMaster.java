package com.bagia.funWithLearn.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IMG_MASTER")
public class ImgMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imgId;

	@Column(nullable = false)
	private String imgPath;

	@Column(nullable = false)
	private String fileExtension;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String imgData;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "videoImage")
	private Video video;

	public ImgMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImgMaster(Long imgId, String imgPath, String fileExtension, String imgData, Video video) {
		super();
		this.imgId = imgId;
		this.imgPath = imgPath;
		this.fileExtension = fileExtension;
		this.imgData = imgData;
		this.video = video;
	}

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getImgData() {
		return imgData;
	}

	public void setImgData(String imgData) {
		this.imgData = imgData;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}
