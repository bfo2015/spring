package org.bfo.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bfo.domain.Criteria;
import org.bfo.domain.QnaReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class QnaReplyDAOImpl implements QnaReplyDAO {

	
	@Inject
	private SqlSession session;
	
	
	private static String namespace = "org.bfo.persistence.QnaReplyDAO";
	
	@Override
	public List<QnaReplyVO> listpage(int qnano,Criteria cri) throws Exception {
		
		Map<String,Object> paramMap = new HashMap<>();
		
		paramMap.put("qnano", qnano);
		
		paramMap.put("cri", cri);
		
		return session.selectList(namespace+".listpage", paramMap);
	}

	@Override
	public void create(QnaReplyVO vo) throws Exception {
		
		session.insert(namespace+".create", vo);
	}

	@Override
	public void modify(QnaReplyVO vo) throws Exception {
		
		session.update(namespace+".modify", vo);

	}

	@Override
	public void delete(int rno) throws Exception {
		
		session.delete(namespace+".delete", rno);

	}

	@Override
	public int count(int qnano) throws Exception {
		
		return session.selectOne(namespace+".count", qnano);
	}

	@Override
	public List<QnaReplyVO> list(int qnano) throws Exception {
		
		return session.selectList(namespace+".list", qnano);
	}

}
