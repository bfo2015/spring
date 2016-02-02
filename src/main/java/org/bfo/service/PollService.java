package org.bfo.service;

import java.util.List;

import org.bfo.domain.AllVO;
import org.bfo.domain.CategoryVO;
import org.bfo.domain.Criteria;
import org.bfo.domain.FileVO;
import org.bfo.domain.ItemVO;
import org.bfo.domain.PollVO;
import org.bfo.domain.TextVO;

public interface PollService {

	public List<PollVO> list(Criteria cri) throws Exception;
	
	public int listCount(Criteria cri) throws Exception; 
	
	public void regist(PollVO vo) throws Exception;
	
	public PollVO view(int pno) throws Exception;
	
	public void modify(PollVO vo,ItemVO itemVO) throws Exception;
	
	public void remove(int pno) throws Exception;
	
	public PollVO setting(int pno) throws Exception;	
	
	public List<CategoryVO> categoryList()throws Exception;
	
	public int newPno() throws Exception;
	
	public void registUpt(PollVO vo,ItemVO itemVO) throws Exception;
	
	public List<FileVO> readAttach(int pno) throws Exception;
	
	public List<TextVO> readItem(int pno) throws Exception;
	
	public int checkFile(int pno) throws Exception;	
	public void removeFile(int pno) throws Exception;
	
	public int checkItem(int pno) throws Exception;
	public void removeItem(int pno) throws Exception;
	
	public AllVO viewAll(int pno)throws Exception;
	
}
