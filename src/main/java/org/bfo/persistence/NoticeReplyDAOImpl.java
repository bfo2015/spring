package org.bfo.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeReplyDAOImpl implements NoticeReplyDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.bfo.persistence.NoticeReplyDAO";
	
	@Override
	public List<NoticeReplyVO> list(Integer nno) throws Exception {
		return session.selectList(namespace + ".list", nno);
	}

	@Override
	public void create(NoticeReplyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(NoticeReplyVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<NoticeReplyVO> listPage(Integer nno, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("nno", nno);
		paramMap.put("cri", cri);
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(Integer nno) throws Exception {
		return session.selectOne(namespace + ".count", nno);
	}
}
