package kr.or.dgit.fishing;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.dgit.domain.PageMaker;
import kr.or.dgit.domain.Point;
import kr.or.dgit.domain.SerchCriteria;
import kr.or.dgit.service.PointReplyService;
import kr.or.dgit.service.PointService;
import kr.or.dgit.util.MediaUtils;
import kr.or.dgit.util.UploadUtils;

@Controller
@RequestMapping("/point")
public class PointController {
	private static final Logger logger = LoggerFactory.getLogger(PointController.class);
	
	@Autowired
	private PointService service;
	
	@Autowired
	private PointReplyService prService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertGet()throws Exception{
		return "point/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertPost(Point p,List<MultipartFile> uploadPfile)throws Exception{
		
		ArrayList<String>list = new ArrayList<>();
		
		for(MultipartFile file : uploadPfile){
			logger.info("파일이름 ---------"+file.getOriginalFilename());
			String thumb = UploadUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
			list.add(thumb);
		}
		p.setPointfile(list);
		logger.info("사진넣엇냐"+p.getPointfile());
		service.pointInsert(p);
		return"redirect:listPage";
	}
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listAll(Model model,@ModelAttribute("cri")SerchCriteria cri,Point p)throws Exception{
		
		List<Point> list= service.listSearch(cri);
		logger.info("뭐잇나요"+list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchCount(cri));
		model.addAttribute("pageMaker",pageMaker);
		
		/*for(int i=0; i<list.size();i++){
			double avg = prService.AvgPrf(list.get(i).getPointNo());
			list.get(i).setAvg(avg);
		}*/
		model.addAttribute("list",list);
		model.addAttribute("pr",list);
		
		/*ArrayList<String> file = new ArrayList<>();
		logger.info("file"+file);
		String thumb = UploadUtils.uploadFile(uploadPath,  filePfile.getOriginalFilename(), filePfile.getBytes());
		file.add(thumb);
		p.setPointfile(file);*/
		
		return "point/listPage";
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String read(int pointNo,Model model,@ModelAttribute("cri")SerchCriteria cri,boolean isModify)throws Exception{
		Point p = service.pointByno(pointNo);
		if(isModify == false){
			service.updateCnt(pointNo);
		}
		model.addAttribute("point",p);
		return "point/read";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(int pointNo,@ModelAttribute("cri") SerchCriteria cri,Model model)throws Exception{
		service.pointDel(pointNo);
		
		model.addAttribute("page",cri.getPage());
		model.addAttribute("searcgType",cri.getSearchType());
		model.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:listPage";
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String updateGet(int pointNo,Model model,@ModelAttribute("cri")SerchCriteria cri)throws Exception{
		Point p = service.pointByno(pointNo);
		model.addAttribute("point",p);
		return "point/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String updatePost(Point p,RedirectAttributes ba,@ModelAttribute("cri") SerchCriteria cri)throws Exception{
		service.pointUpdate(p);
		ba.addAttribute("pointNo",p.getPointNo());
		return "redirect:read";
	}
	
	@ResponseBody
	@RequestMapping(value="displayFile")// displayFile?filename=파일이름 <- 커맨드 형식
	public ResponseEntity<byte[]>displayFile(String uploadPfile) throws IOException{
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		logger.info("displayFile"+uploadPfile);
		
		try {
			String formatName = uploadPfile.substring(uploadPfile.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			/*logger.info("이건 오냐"+mType);*/
			HttpHeaders header = new HttpHeaders();
			
		/*	logger.info("뭐없냐"+header);*/
			header.setContentType(mType);
			
			/*logger.info("주소좀"+uploadPath+"/"+uploadPfile);*/
			in = new FileInputStream(uploadPath+"/"+uploadPfile);
			logger.info("in"+in);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),header,HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			
		}finally {
			in.close();
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="imageUpload",method=RequestMethod.POST)
	public ResponseEntity<String> dragUploadResult(MultipartFile file){
		ResponseEntity<String> entity = null;
	/*	logger.info("--------------------result---------------------");
	
		
			logger.info("files.size:"+file.getSize());
			logger.info("files.getOriginalFilename():"+file.getOriginalFilename());*/
	
		try {
			//c:zzz/upload 폴더에 file를 upload 한다
			
		
				String thum = UploadUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
				logger.info("thum -- " + thum);
				
			
			entity = new ResponseEntity<String>(thum,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@ResponseBody
	   @RequestMapping(value="displayTitleFile") //displayFile?filename=******.jpg
	   public ResponseEntity<byte[]> displayTitleFile(String uploadPfile){
	      ResponseEntity<byte[]> entity=null;
	      InputStream in = null;
	      try{

	         String formetName= uploadPfile.substring(uploadPfile.lastIndexOf(".")+1);
	         MediaType mtype= MediaUtils.getMediaType(formetName);
	         HttpHeaders header= new HttpHeaders();
	         header.setContentType(mtype);

	         String front=uploadPfile.substring(0,12);
	         String end= uploadPfile.substring(14);

	         in= new FileInputStream(uploadPath+"/"+front+end);
	         entity= new ResponseEntity<byte[]>(IOUtils.toByteArray(in),header,HttpStatus.CREATED);
	      }catch (Exception e) {
	         e.printStackTrace();
	         entity= new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	      }finally{
	         try {
	            in.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	      return entity;
	   }
}
