package org.bfo.persistence;

import java.util.List;

import org.bfo.domain.Criteria;
import org.bfo.domain.QnaReplyVO;

public interface QnaReplyDAO {

	public List<QnaReplyVO> listpage(int qnano,Criteria cri) throws Exception;
	
	public List<QnaReplyVO> list(int qnano) throws Exception;
	
	public int count(int qnano)throws Exception;
	
	public void create(QnaReplyVO vo) throws Exception;
	
	public void modify(QnaReplyVO vo) throws Exception;
	
	public void delete(int rno) throws Exception;
	
}
