package org.bfo.service;

import java.util.List;

import org.bfo.domain.Criteria;
import org.bfo.domain.QnaVO;

public interface QnaService {

	public List<QnaVO> getQnaList(Criteria cri) throws Exception;
	
	public int qnaCount(Criteria cri) throws Exception;
	
	public QnaVO QnaView(int qnano) throws Exception;
	
	public void qnaReigster(QnaVO vo)throws Exception;
	
	public void qnaModify(QnaVO vo)throws Exception;
	
	public void qnaRemove(int qnano) throws Exception;
	
}
