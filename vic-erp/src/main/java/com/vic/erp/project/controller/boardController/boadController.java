package com.vic.erp.project.controller.boardController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vic.erp.project.VO.BoardVO;
import com.vic.erp.project.service.boardService.BoardService;
import com.vic.erp.project.util.FileUtils;

@Controller
public class boadController {

	@Autowired
	private BoardService boardService;

	
	@Autowired private FileUtils fileUtils;
	 
	
	@RequestMapping("/vicglobal/board")
	public String board() {
		return "/board/noticeBoard";
	}

	@GetMapping("/vicglobal/board/read/page")
	public String boardReadPage() {
		return "/board/brdRead";
	}

	
	@RequestMapping("/vicglobal/board1")
	@ResponseBody
	public void board1(HttpServletRequest request) {
		
	    String brd_id = request.getParameter("brd_id");
	    HttpSession session = request.getSession();
	    session.setAttribute("brd_id", brd_id);
	}

	// 게시판 사이드바 메뉴
	@RequestMapping("/vicglobal/board/menu")
	@ResponseBody
	public List<BoardVO> boardMenu(HttpServletRequest request) {

		List<BoardVO> menu = boardService.brdMenu();

		return menu;
	}

	// 게시판 리스트
	@RequestMapping("/vicglobal/board/list")
	@ResponseBody
	public HashMap<String, Object> boardList(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<>();
		String brd_id = request.getParameter("brd_id");
		String keyword = request.getParameter("keyword");
		String category = request.getParameter("category");
		String numString = request.getParameter("num");
		System.out.println("num: "+numString);
		int num = 1;
		try {
		    num = Integer.parseInt(numString);
		} catch (NumberFormatException e) {}

		 // 게시물 총 갯수
		int count = boardService.boardTotal(keyword, category, brd_id);
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		// 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		// 출력할 게시물
		int displayPost = (num-1) * postNum;
		List<BoardVO> brdList = boardService.brdList(brd_id, keyword, category, displayPost, postNum);
		map.put("brd_id", brd_id);
		map.put("keyword", keyword);
		map.put("category", category);
		map.put("brdList", brdList);
		map.put("pageNum", pageNum);
		map.put("num", num);
		map.put("count", count);
		return map;
	}

	// 게시판 글쓰기
	@RequestMapping("/vicglobal/board/write")
	public void boardWrite(MultipartHttpServletRequest mpRequest) {
	    LocalDateTime dateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = dateTime.format(formatter);

	    // 게시글 정보 설정
	    String brd_id = mpRequest.getParameter("brd_id"); // 게시글아이디 *필수
	    String make_emp_no = mpRequest.getParameter("make_emp_no"); // 작성사원번호 *필수
	    String boms_title = mpRequest.getParameter("boms_title"); // 게시글제목 *필수
	    String boms_desc = mpRequest.getParameter("boms_desc"); // 게시글내용 *필수
	    String boms_del_yn = "n"; // 게시글삭제여부 *필수
	    String popup_yn = "n"; // 팝업여부 *필수
	    int inq_cnt = 0; // 조회수 *필수
	    String total_emp_tg_yn = "y"; // 전체사원대상여부 *필수
	    int up_boms_no = 0; // 상위게시글번호 *필수

	    Timestamp reg_dttm = Timestamp.valueOf(formattedDateTime); // 등록일시 *필수
	    Timestamp modf_dttm = Timestamp.valueOf(formattedDateTime); // 변경일시 *필수

	    // authority 추가
	    String authority = mpRequest.getParameter("authority");

	    BoardVO board = new BoardVO();

	    board.setBrd_id(brd_id);
	    board.setMake_emp_no(make_emp_no);
	    board.setBoms_title(boms_title);
	    board.setBoms_desc(boms_desc);
	    board.setBoms_del_yn(boms_del_yn);
	    board.setPopup_yn(popup_yn);
	    board.setInq_cnt(inq_cnt);
	    board.setTotal_emp_tg_yn(total_emp_tg_yn);
	    board.setUp_boms_no(up_boms_no);
	    board.setReg_dttm(reg_dttm);
	    board.setReg_emp_no(make_emp_no); // 등록사원번호 추가
	    board.setModf_dttm(modf_dttm);
	    board.setModf_emp_no(make_emp_no); // 변경사원 추가
	    board.setAuthority(authority); // authority 추가

	    // 첨부 파일 처리
	    List<Map<String, Object>> attachFileList = new ArrayList<>();
	    Map<String, List<MultipartFile>> fileMap = mpRequest.getMultiFileMap();
	    for (List<MultipartFile> multipartFiles : fileMap.values()) {
	        for (MultipartFile multipartFile : multipartFiles) {
	            if (!multipartFile.isEmpty()) {
	                String originalFileName = multipartFile.getOriginalFilename();
	                String storedFileName = null;
					try {
						storedFileName = FileUtils.getRandomString() + FileUtils.getFileExtension(originalFileName);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                String filePath = FileUtils.FILE_STORAGE_PATH + storedFileName;
	                String atch_file_use_div_cd = "y";
	                // 파일 저장
	                try {
	                    File file = new File(filePath);
	                    multipartFile.transferTo(file);

	                    // 파일 정보 저장
	                    Map<String, Object> fileMap1 = new HashMap<>();
	                    fileMap1.put("emp_no", make_emp_no);
	                    fileMap1.put("atch_file_nm", originalFileName);
	                    fileMap1.put("stored_file_nm", storedFileName);
	                    fileMap1.put("atch_file_size", multipartFile.getSize());
	                    fileMap1.put("atch_file_path_nm", filePath);
	                    fileMap1.put("atch_file_use_div_cd", atch_file_use_div_cd);
	                    fileMap1.put("reg_dttm", reg_dttm);
	                    fileMap1.put("reg_emp_no", make_emp_no);
	                    fileMap1.put("modf_dttm", modf_dttm);
	                    fileMap1.put("modf_emp_no", make_emp_no);
	                    attachFileList.add(fileMap1);
	                } catch (IOException e) {
	                    // 파일 저장 중 오류 처리
	                    e.printStackTrace();
	                    // 실패 처리 로직 추가
	                }
	            }
	        }
	    }
	   
	    // 첨부 파일 정보를 게시글 객체에 추가
	    board.setFile(attachFileList); 
	    boardService.brdWrt(board);
	    boardService.brdSelNo(board);
	}

	
	@RequestMapping("/vicglobal/board/read")
	@ResponseBody
	public List<BoardVO> brdRead(HttpServletRequest request) {
		String boms_no = request.getParameter("boms_no");
	    List<BoardVO> brd = boardService.brdRead1(boms_no);
	    
	    return brd;
	}
	
	@GetMapping("/vicglobal/board/download")
	public void downloadFile(@RequestParam int fileNo, @RequestParam String fileName, HttpServletResponse response) throws IOException {
	    try {
	        // 클라이언트에서 전달한 파일 이름을 기반으로 서버에서 실제 파일의 경로를 구성
	        String storedFileName = boardService.findFileNo(fileNo);
	        String filePath = FileUtils.FILE_STORAGE_PATH + storedFileName;
	        System.out.println(filePath);
	        File file = new File(filePath);
	        String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
	        if (file.exists()) {
	            // 파일이 존재하는 경우에만 다운로드 처리
	            InputStream inputStream = new FileInputStream(file);
	            response.setContentType("application/octet-stream");
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");

	            // 파일을 읽어서 response로 전송
	            byte[] buffer = new byte[4096];
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                response.getOutputStream().write(buffer, 0, bytesRead);
	            }

	            inputStream.close();
	        } else {
	            // 파일이 존재하지 않을 경우 예외 처리 또는 적절한 응답을 보냅니다.
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
	        }
	    } catch (IOException e) {
	        // 예외 처리
	        e.printStackTrace();
	        // 클라이언트에게 오류 응답을 보냅니다.
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error");
	    }
	}

	@RequestMapping("/vicglobal/board/read/reply")
	@ResponseBody
	public void replyBrd(HttpServletRequest request) {
		LocalDateTime dateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = dateTime.format(formatter);
		
		String make_emp_no = request.getParameter("make_emp_no");
		int up_boms_no = Integer.parseInt(request.getParameter("up_boms_no"));
		String boms_desc = request.getParameter("boms_desc");
	    
		Timestamp reg_dttm = Timestamp.valueOf(formattedDateTime); // 등록일시 *필수
	    Timestamp modf_dttm = Timestamp.valueOf(formattedDateTime); // 변경일시 *필수
		
	    BoardVO board = new BoardVO();
	    
	    board.setMake_emp_no(make_emp_no);
	    board.setBoms_desc(boms_desc);
	    board.setUp_boms_no(up_boms_no);
	    board.setReg_dttm(reg_dttm);
	    board.setReg_emp_no(make_emp_no);
	    board.setModf_dttm(modf_dttm);
	    board.setModf_emp_no(make_emp_no);
	    
		boardService.replyBrd1(board);
	}
	
	@RequestMapping("/vicglobal/board/read/getmessage")
	@ResponseBody
	public List<BoardVO> getBrdMessage(HttpServletRequest request) {
		String up_boms_no = request.getParameter("up_boms_no");
		List<BoardVO> result = boardService.getBrdMessage1(up_boms_no);
		
		return result;
	}
}
