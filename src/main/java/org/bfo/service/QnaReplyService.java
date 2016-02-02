package org.bfo.service;

import java.util.List;

import org.bfo.domain.Criteria;
import org.bfo.domain.QnaReplyVO;

public interface QnaReplyService {

	
	public List<QnaReplyVO> listReply(int qnano,Criteria cri) throws Exception;
	
	public List<QnaReplyVO> listAll(int qnano) throws Exception;
	
	public int count(int qnano) throws Exception;
	
	public void addReply(QnaReplyVO vo) throws Exception;
	
	public void modifyReply(QnaReplyVO vo)throws Exception;
	
	public void removeReply(int rno) throws Exception;
	
}
