package restaurant.restaurantManagement.cmmn;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.fdl.idgnr.impl.Base64;

public class Util_bin {

	/**
	 * responseCode, result 주입용 responseCode가 200인경우만 result success 처리 리스트내 객체를
	 * JSON으로 바꿔 ResponseEntity로 반환
	 * 
	 * @throws JsonProcessingException
	 */
	public static String AddHttpStateAndJson(Map<String, Object> list, HttpStatus state)
			throws JsonProcessingException {

		String result;
		if (state == HttpStatus.OK) {
			result = "success";
		} else {
			result = "fail";
		}
		list.put("responseCode", state.value());
		list.put("result", result);

		String json = new ObjectMapper().writeValueAsString(list);
		return json;
	}

	/**
	 * responseCode, result 주입용 issuccess 여부에 따라 result success 처리 리스트내 객체를 JSON으로
	 * 바꿔 ResponseEntity로 반환
	 * 
	 * @throws JsonProcessingException
	 */
	public static String AddHttpStateAndJson(Map<String, Object> list, HttpStatus state, boolean issuccess)
			throws JsonProcessingException {

		String result;
		if (issuccess) {
			result = "success";
		} else {
			result = "fail";
		}
		list.put("responseCode", state.value());
		list.put("result", result);

		String json = new ObjectMapper().writeValueAsString(list);
		return json;
	}

	public static String ImgTobyte(String ImgPath) {
		File file = new File(ImgPath);
		try {
			BufferedImage image = ImageIO.read(file);
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", b);

			byte[] jpgByteArray = b.toByteArray();
			return new String(java.util.Base64.getEncoder().encode(jpgByteArray));
		} catch (Exception e) {
			System.out.println("ImgTobyte Fail " + ImgPath);
			return null;

		}
	}

	
	public static String fileUpload(MultipartFile file) throws Exception
	{
		
		String filePath = "c:\\upload\\image";
	
		File Folder = new File(filePath);

		String orgFileNm = file.getOriginalFilename();
		String fileExt = orgFileNm.substring(orgFileNm.lastIndexOf('.')+1);
		String fileName =orgFileNm.substring(0, orgFileNm.lastIndexOf('.'));
		
		String fullFileName =fileName +"_"+ new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + "." + fileExt;
		String fullfilepath =filePath + File.separator + fullFileName;
		System.out.println(fullFileName);
		
		try {
			
			if (!Folder.exists()) 
				Folder.mkdirs();
			
			file.transferTo(new File(fullfilepath));
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return fullfilepath;
	}
	
}
