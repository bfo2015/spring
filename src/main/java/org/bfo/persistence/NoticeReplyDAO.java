package org.bfo.persistence;

import java.util.List;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeReplyVO;

public interface NoticeReplyDAO {

	public List<NoticeReplyVO> list(Integer nno) throws Exception;
	
	public void create(NoticeReplyVO vo) throws Exception;
	
	public void update(NoticeReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
	public List<NoticeReplyVO> listPage(Integer nno, Criteria cri) throws Exception;
	
	public int count(Integer nno) throws Exception;
}
