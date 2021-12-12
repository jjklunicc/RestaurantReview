package restaurant.restaurantManagement.web;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import restaurant.restaurantManagement.service.RestaurantManagementService;
import restaurant.restaurantManagement.service.RestaurantVO;

@Controller("genericFileUploadController")
public class GenericFileUploadController {
 
	
	@Resource(name = "restaurantManagementService")
	private RestaurantManagementService restaurantService;
	
	//해당 Mapping을 사용하는 jsp페이지는 아직없음.
	//이미지업데이트용, 이미지를 서버에 저장, 디비에 경로를 입력한다
	//request 
	//req - 파일
	//restaurantID 업데이트할 식당 아이디
	@RequestMapping(value="/updateRestaurantImage.do") 
	public String updateRestaurantImage(MultipartHttpServletRequest req,@RequestParam("restaurantID") String restaurantID) throws Exception {
		
		System.out.println("파일 업로드 시작");
		Iterator<String> itr = req.getFileNames();
		
		RestaurantVO vo = new RestaurantVO();
		vo.setIndex(Integer.parseInt(req.getParameter("restaurantID")));
		String requestUrl = new String(req.getRequestURL());
		System.out.println(requestUrl);		
		String fullpath;
		while(itr.hasNext()) {
			MultipartFile mpf = req.getFile(itr.next());
			fullpath=fileUpload(mpf);
			
			vo.setImg_path_str(fullpath);
			restaurantService.UpdateRestaurantImage(vo);
		}
		
		return "업로드 완료";
	}
	
	@RequestMapping(value="/test_fileUpload.do") 
	public String fileUploadTest(MultipartHttpServletRequest req) throws Exception {
		
		System.out.println("파일 업로드 시작");
		Iterator<String> itr = req.getFileNames();
		
		
		RestaurantVO vo = new RestaurantVO();
		vo.setIndex(Integer.parseInt(req.getParameter("id")));
		String requestUrl = new String(req.getRequestURL());
		System.out.println(requestUrl);		
		String fullpath;
		while(itr.hasNext()) {
			MultipartFile mpf = req.getFile(itr.next());
			fullpath=fileUpload(mpf);
			
			vo.setImg_path_str(fullpath);
			restaurantService.UpdateRestaurantImage(vo);
		}
		
		return "업로드 완료";
	}
	
	public String fileUpload(MultipartFile file) throws Exception
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