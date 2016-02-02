package org.bfo.service;

import java.util.List;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeVO;

public interface NoticeService {
	
	public List<NoticeVO> list(Criteria cri) throws Exception;
	
	public int listCount(Criteria cri) throws Exception;
	
	public void regist(NoticeVO vo) throws Exception;
	
	public NoticeVO view(Integer nno) throws Exception;
	
	public void modify(NoticeVO vo) throws Exception;
	
	public void remove(Integer nno) throws Exception;
}
