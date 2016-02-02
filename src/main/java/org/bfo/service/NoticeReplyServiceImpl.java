package org.bfo.service;

import java.util.List;
import javax.inject.Inject;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeReplyVO;
import org.bfo.persistence.NoticeReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class NoticeReplyServiceImpl implements NoticeReplyService {

	@Inject
	private NoticeReplyDAO dao;
	
	@Override
	public List<NoticeReplyVO> listReply(Integer nno) throws Exception {
		return dao.list(nno);
	}

	@Override
	public void registReply(NoticeReplyVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public void modifyReply(NoticeReplyVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		dao.delete(rno);
	}

	@Override
	public List<NoticeReplyVO> listReplyPage(Integer nno, Criteria cri) throws Exception {
		return dao.listPage(nno, cri);
	}

	@Override
	public int count(Integer nno) throws Exception {
		return dao.count(nno);
	}
}
