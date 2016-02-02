package org.bfo.service;

import java.util.List;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeVO;
import org.bfo.persistence.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO dao;
	
	@Override
	public List<NoticeVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		return dao.listCount(cri);
	}

	@Override
	public void regist(NoticeVO vo) throws Exception {
		dao.create(vo);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public NoticeVO view(Integer nno) throws Exception {
		dao.updateViewCnt(nno);
		return dao.read(nno);
	}

	@Override
	public void modify(NoticeVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(Integer nno) throws Exception {
		dao.delete(nno);
	}
}
