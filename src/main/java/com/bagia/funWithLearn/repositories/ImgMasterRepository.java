package com.bagia.funWithLearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bagia.funWithLearn.entities.ImgMaster;

public interface ImgMasterRepository extends JpaRepository<ImgMaster, Long> {
	
	public ImgMaster findByImgId(Long imgId);

}
