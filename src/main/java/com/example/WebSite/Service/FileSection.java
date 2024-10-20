package com.example.WebSite.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.WebSite.Models.FileModel;
import com.example.WebSite.Repository.FileRepository;

@Service
public class FileSection {
	
	@Autowired
	FileRepository fileRepository;
	
	public FileModel addFile(MultipartFile file) throws Exception{
		UUID uuid = UUID.randomUUID();
		String file_name = uuid+"_"+file.getOriginalFilename();
		FileModel fileModel =  new FileModel();
		String filePath = System.getProperty("user.dir") + "\\src\\resources\\"+ file_name; 
		fileModel.setFileName(file.getOriginalFilename());
		fileModel.setFilePath(filePath);
		fileModel.setFileType(file.getContentType());
		fileModel.setOriginal_name(file.getOriginalFilename());
		fileModel.setSize(file.getSize());
		fileRepository.save(fileModel);
		return fileModel;
	}
	
	
}
