package org.bfo.service;

import java.util.List;

import javax.inject.Inject;

import org.bfo.domain.Criteria;
import org.bfo.domain.QnaReplyVO;
import org.bfo.persistence.QnaReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {

	@Inject
	private QnaReplyDAO dao;
	
	
	@Override
	public List<QnaReplyVO> listReply(int qnano,Criteria cri) throws Exception {
		
		return dao.listpage(qnano,cri);
	}

	@Override
	public void addReply(QnaReplyVO vo) throws Exception {
	
		dao.create(vo);

	}

	@Override
	public void modifyReply(QnaReplyVO vo) throws Exception {
		
		dao.modify(vo);

	}

	@Override
	public void removeReply(int rno) throws Exception {
		
		dao.delete(rno);

	}

	@Override
	public int count(int qnano) throws Exception {
		
		return dao.count(qnano);
	}

	@Override
	public List<QnaReplyVO> listAll(int qnano) throws Exception {
		
		return dao.list(qnano);
	}

}
