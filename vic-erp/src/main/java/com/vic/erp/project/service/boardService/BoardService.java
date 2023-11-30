package com.vic.erp.project.service.boardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.erp.project.VO.AttachFileVO;
import com.vic.erp.project.VO.BoardVO;
import com.vic.erp.project.mapper.board.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;  
	//게시판 사이드바 메뉴
	public List<BoardVO> brdMenu() {
		return boardMapper.brdMenu();
	}
	//게시판 리스트 토탈
	public int boardTotal(String keyword, String category, String brd_id) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("brd_id", brd_id);
		data.put("keyword", keyword);
		data.put("category", category);
	
		return boardMapper.boardTotal(data);
	}
	
	//게시판 리스트
	public List<BoardVO> brdList(String brd_id, String keyword, String category, int displayPost, int postNum){
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("brd_id", brd_id);
		data.put("keyword", keyword);
		data.put("category", category);
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return boardMapper.brdList(data);
	}
	//첨부파일
	public List<AttachFileVO> getAttachFiles(int boms_no) {
	    return boardMapper.getAttachFiles(boms_no); 
	}
	//게시판 글쓰기
    public void brdWrt(BoardVO board) {
        // 게시글 저장
        boardMapper.brdWrt(board);

        // 첨부 파일 리스트 저장
        List<Map<String, Object>> attachFileList = board.getFile();
        if (attachFileList != null && !attachFileList.isEmpty()) {
            for (Map<String, Object> attachFile : attachFileList) {
                boardMapper.attachFileWrt(attachFile);
            }
        }
    }

    public void brdSelNo(BoardVO board) {
    	boardMapper.brdSelNo(board);
    }
    
    public List<BoardVO> brdRead1(String boms_no1){
    	int boms_no=Integer.parseInt(boms_no1);
    	
    	List<BoardVO> read = boardMapper.brdRead2(boms_no);
    	return read;
    }
    public String findFileNo(int file_no){
    	String file= boardMapper.findFileNo(file_no);
    	
    	return file;
    }
    public void replyBrd1(BoardVO board) {
    	boardMapper.replyBrd2(board);
    }
    
    public List<BoardVO> getBrdMessage1(String up_boms_no){
    	int upBomsNo = Integer.parseInt(up_boms_no);
    	List<BoardVO> getBM = boardMapper.getBrdMessage2(upBomsNo);
    	return getBM;
    }
}
