package org.bfo.service;

import java.util.List;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeReplyVO;

public interface NoticeReplyService {
	
	public List<NoticeReplyVO> listReply(Integer nno) throws Exception;
	
	public void registReply(NoticeReplyVO vo) throws Exception;
	
	public void modifyReply(NoticeReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<NoticeReplyVO> listReplyPage(Integer nno, Criteria cri) throws Exception;
	
	public int count(Integer nno) throws Exception;
}
