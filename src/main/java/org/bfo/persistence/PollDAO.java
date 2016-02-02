package org.bfo.persistence;

import java.util.List;

import org.bfo.domain.AllVO;
import org.bfo.domain.CategoryVO;
import org.bfo.domain.Criteria;
import org.bfo.domain.FileVO;
import org.bfo.domain.PollVO;
import org.bfo.domain.TextVO;

public interface PollDAO {

	public List<PollVO> list(Criteria cri) throws Exception;

	public int listCount(Criteria cri) throws Exception;

	public void create(PollVO vo) throws Exception;

	public PollVO read(int pno) throws Exception;

	public void update(PollVO vo) throws Exception;

	public void delete(int pno) throws Exception;

	public PollVO setting(int pno) throws Exception;

	public List<CategoryVO> categoryList() throws Exception;

	public int newPno() throws Exception;

	public void createUpt(PollVO vo) throws Exception;

	public void addAttach(FileVO file) throws Exception;

	public void addItem(TextVO item) throws Exception;
	
	public List<FileVO> readAttach(int pno) throws Exception;
	
	public List<TextVO> readItem(int pno) throws Exception;
	
	public int checkFile(int pno) throws Exception;
	public void deleteFile(int pno) throws Exception;
	
	public int checkItem(int pno) throws Exception;
	public void deleteItem(int pno) throws Exception;

	public AllVO readAll(int pno) throws Exception;

}
