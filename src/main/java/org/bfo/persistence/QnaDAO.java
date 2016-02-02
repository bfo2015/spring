package org.bfo.persistence;

import java.util.List;

import org.bfo.domain.Criteria;
import org.bfo.domain.QnaVO;

public interface QnaDAO {

	public List<QnaVO> qnaList(Criteria cri) throws Exception;
	
	public int qnaCount(Criteria cri) throws Exception;
	
	public void create(QnaVO vo) throws Exception;
	
	public void update(QnaVO vo)throws Exception;
	
	public QnaVO read(int qnano)throws Exception;
	
	public void delete(int qnano)throws Exception;
	
}
