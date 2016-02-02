package org.bfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.bfo.util.MediaUtils;
import org.bfo.util.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class UploadController {

	private static final Logger logger = 
			LoggerFactory.getLogger(UploadController.class);
	
	private static final String uploadPath = "C:\\zzz\\upload";
	
	@RequestMapping(value="/poll/uploadForm", method=RequestMethod.GET)
	public void uploadForm(){
		
	}

	  @RequestMapping(value = "/poll/uploadForm", method = RequestMethod.POST)
	  public String uploadForm(MultipartFile file, Model model) throws Exception {

	    logger.info("originalName: " + file.getOriginalFilename());
	    logger.info("size: " + file.getSize());
	    logger.info("contentType: " + file.getContentType());

	    String savedName = UploadFileUtils.uploadFile(uploadPath, 
                file.getOriginalFilename(), 
                file.getBytes());

	    model.addAttribute("savedName", savedName);

	    return "/poll/uploadResult";
	  }
	 
/*	  private String uploadFile(String originalName, byte[] fileData) throws Exception {

		    UUID uid = UUID.randomUUID();

		    String savedName = uid.toString() + "_" + originalName;

		    File target = new File(uploadPath, savedName);

		    FileCopyUtils.copy(fileData, target);

		    return savedName;

		  }*/
	  
	  @RequestMapping(value="/poll/uploadAjax", method = RequestMethod.GET)
	  public void uploadAjax(){
		  
	  }
	  
	  @ResponseBody
	  @RequestMapping(value ="/poll/uploadAjax", method=RequestMethod.POST, 
	                  produces = "text/plain;charset=UTF-8")
	  public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{
	    
	    logger.info("originalName: " + file.getOriginalFilename());
	    
	   
	    return 
	      new ResponseEntity<>(
	          UploadFileUtils.uploadFile(uploadPath, 
	                file.getOriginalFilename(), 
	                file.getBytes()), 
	          HttpStatus.CREATED);
	  }
	  
	  @ResponseBody
	  @RequestMapping("/poll/displayFile")
	  public ResponseEntity<byte[]>  displayFile(String fileName)throws Exception{
	    
	    InputStream in = null; 
	    ResponseEntity<byte[]> entity = null;
	    
	    logger.info("================FILE NAME: " + fileName);
	    
	    try{
	      
	      String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	      
	      MediaType mType = MediaUtils.getMediaType(formatName);
	      
	      HttpHeaders headers = new HttpHeaders();
	      
	      in = new FileInputStream(uploadPath+fileName);
	      
	      if(mType != null){
	        headers.setContentType(mType);
	      }else{
	        
	        fileName = fileName.substring(fileName.indexOf("_")+1);       
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition", "attachment; filename=\""+ 
	          new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	      }

	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), 
	          headers, 
	          HttpStatus.CREATED);
	    }catch(Exception e){
	      e.printStackTrace();
	      entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally{
	      in.close();
	    }
	      return entity;    
	  }//이미지 올려주기
	  
	  @ResponseBody
	  @RequestMapping(value="/poll/deleteFile", method=RequestMethod.POST)
	  public ResponseEntity<String> deleteFile(String fileName){
	    
	    logger.info("delete file: "+ fileName);
	    System.out.println("여길왜 들어오지?=================================================");
	    
	    String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	    
	    MediaType mType = MediaUtils.getMediaType(formatName);
	    
	    if(mType != null){      
	      
	      String front = fileName.substring(0,12);
	      String end = fileName.substring(14);
	      new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();//파일삭제, 썸네일도
	    }
	    
	    new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
	    
	    
	    return new ResponseEntity<String>("deleted", HttpStatus.OK);
	  }  //첨부파일 삭제
	  
}
