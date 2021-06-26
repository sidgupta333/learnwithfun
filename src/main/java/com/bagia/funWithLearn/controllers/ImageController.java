package com.bagia.funWithLearn.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bagia.funWithLearn.entities.ImgMaster;
import com.bagia.funWithLearn.responses.GeneralResponse;
import com.bagia.funWithLearn.services.ImageService;

@RestController
@CrossOrigin
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageService imgService;

	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
		ImgMaster imgMaster = new ImgMaster();
		imgMaster.setImgPath(file.getOriginalFilename());
		imgMaster.setFileExtension(file.getContentType());
		String base64String;
		try {
			base64String = Base64.getEncoder().encodeToString(file.getBytes());
			imgMaster.setImgData(base64String);
			imgService.saveImage(imgMaster);
		}

		catch (Exception e) {
			System.out.println("Failed to run: " + e);
			return ResponseEntity.status(500).body(new GeneralResponse("failure"));
		}

		return ResponseEntity.ok(imgMaster);
	}
	
	@GetMapping("/download/{imgId}")
	public ResponseEntity<?> downloadImage(@PathVariable Long imgId) {

		ImgMaster img = imgService.getImage(imgId);

		if (img == null) {
			return ResponseEntity.status(404).body(new GeneralResponse("not found"));
		}

		byte[] byteData;
		try {
			byteData = Base64.getDecoder().decode(new String(img.getImgData()).getBytes("UTF-8"));
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(byteData);
		}

		catch (UnsupportedEncodingException e) {
			System.out.println("Failed to run: " + e);
			return ResponseEntity.status(404).body(new GeneralResponse("failure"));
		}

	}
}
