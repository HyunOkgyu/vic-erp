package com.vic.erp.project.mapper.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.AttachFileVO;
import com.vic.erp.project.VO.BoardVO;

@Mapper
public interface BoardMapper {
	//게시판 사이드바 메뉴
	public List<BoardVO> brdMenu();
	//게시판 리스트 토탈
	public int boardTotal(HashMap<String, Object> data);
	//게시판 리스트
	public List<BoardVO> brdList(HashMap<String, Object> data);
	//첨부파일
	List<AttachFileVO> getAttachFiles(int boms_no);
	//게시판 글쓰기
	public void brdWrt(BoardVO board);
	//게시판 글쓰기 첨부파일
	void attachFileWrt(Map<String, Object> attachFile);
	//게시글 선택 사원
	public void brdSelNo(BoardVO board);
	
	public List<BoardVO> brdRead2(int boms_no);
	
	public String findFileNo(int file_no);
	
	public void replyBrd2(BoardVO board);
	
	public List<BoardVO> getBrdMessage2(int up_boms_no);
}
