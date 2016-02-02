package org.bfo.persistence;

import java.util.List;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeVO;

public interface NoticeDAO {

	public List<NoticeVO> list(Criteria cri) throws Exception;
	
	public int listCount(Criteria cri) throws Exception;
	
	public void create(NoticeVO vo) throws Exception;
	
	public NoticeVO read(Integer nno) throws Exception;
	
	public void update(NoticeVO vo) throws Exception;
	
	public void delete(Integer nno) throws Exception;
	
	public void updateViewCnt(Integer nno) throws Exception;
}