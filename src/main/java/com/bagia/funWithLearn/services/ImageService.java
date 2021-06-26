package com.bagia.funWithLearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bagia.funWithLearn.entities.ImgMaster;
import com.bagia.funWithLearn.repositories.ImgMasterRepository;

@Component
public class ImageService {

	@Autowired
	private ImgMasterRepository imgRepo;
	
	public ImgMaster getImage(Long imgId) {
		return imgRepo.findByImgId(imgId);
	}
	
	public boolean deleteImage(ImgMaster img) throws Exception {
		try {
			imgRepo.delete(img);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public void saveImage(ImgMaster img) {
		try {
			imgRepo.save(img);
		}
		catch(Exception e) {
			System.out.println("Failed to run: " + e);
		}
	}
}
