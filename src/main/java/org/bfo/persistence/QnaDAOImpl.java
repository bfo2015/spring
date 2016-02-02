package org.bfo.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bfo.domain.Criteria;
import org.bfo.domain.QnaVO;
import org.springframework.stereotype.Controller;

@Controller
public class QnaDAOImpl implements QnaDAO {

	@Inject
	private SqlSession session;
	
	static private String namespace = "org.bfo.persistence.QnaDAO";
	
	@Override
	public List<QnaVO> qnaList(Criteria cri) throws Exception {
		
		return session.selectList(namespace+".qnaList",cri);
	}

	@Override
	public void create(QnaVO vo) throws Exception {
		
		session.insert(namespace+".create", vo);

	}

	@Override
	public void update(QnaVO vo) throws Exception {
		
		session.update(namespace+".update", vo);

	}

	@Override
	public QnaVO read(int qnano) throws Exception {
		
		return session.selectOne(namespace+".read", qnano);
	}

	@Override
	public void delete(int qnano) throws Exception {
		
		session.delete(namespace+".delete", qnano);

	}

	@Override
	public int qnaCount(Criteria cri) throws Exception {
		
		return session.selectOne(namespace+".qnaCount", cri);
	}

}
