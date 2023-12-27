package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Document;
import com.bezkoder.springjwt.payload.response.ResponseMessage;
import com.bezkoder.springjwt.services.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/doc")
@Tag(name = "DocController")
public class DocController {



	@Autowired
	private FileStorageService storageService;


	@Operation(description = "UploadFile")
	@PostMapping(path = "/upload")
	public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		Document fileDB=new Document();
		try {
			fileDB=storageService.store(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body( fileDB.getId());
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}



	}




