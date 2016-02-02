package org.bfo.service;

import java.util.List;

import javax.inject.Inject;

import org.bfo.domain.Criteria;
import org.bfo.domain.QnaVO;
import org.bfo.persistence.QnaDAO;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject
	private QnaDAO dao;
	
	@Override
	public List<QnaVO> getQnaList(Criteria cri) throws Exception {
		
		return dao.qnaList(cri);
	}

	@Override
	public QnaVO QnaView(int qnano) throws Exception {
		
		return dao.read(qnano);
	}

	@Override
	public void qnaReigster(QnaVO vo) throws Exception {
		
		dao.create(vo);

	}

	@Override
	public void qnaModify(QnaVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void qnaRemove(int qnano) throws Exception {
		
		dao.delete(qnano);

	}

	@Override
	public int qnaCount(Criteria cri) throws Exception {
		
		return dao.qnaCount(cri);
	}

}
