package com.vic.erp.project.mapper.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.vic.erp.project.VO.AttachFileVO;
import com.vic.erp.project.VO.BoardVO;

@Mapper
public interface BoardMapper {
	//�Խ��� ���̵�� �޴�
	public List<BoardVO> brdMenu();
	//�Խ��� ����Ʈ ��Ż
	public int boardTotal(HashMap<String, Object> data);
	//�Խ��� ����Ʈ
	public List<BoardVO> brdList(HashMap<String, Object> data);
	//÷������
	List<AttachFileVO> getAttachFiles(int boms_no);
	//�Խ��� �۾���
	public void brdWrt(BoardVO board);
	//�Խ��� �۾��� ÷������
	void attachFileWrt(Map<String, Object> attachFile);
	//�Խñ� ���� ���
	public void brdSelNo(BoardVO board);
	
	public List<BoardVO> brdRead2(int boms_no);
	
	public String findFileNo(int file_no);
	
	public void replyBrd2(BoardVO board);
	
	public List<BoardVO> getBrdMessage2(int up_boms_no);
}
