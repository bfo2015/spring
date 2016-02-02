package org.bfo.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeVO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Inject
	private SqlSession session;

	public static String namespace = "org.bfo.persistence.NoticeDAO";

	@Override
	public List<NoticeVO> list(Criteria cri) throws Exception {
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".listCount", cri);
	}

	@Override
	public void create(NoticeVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public NoticeVO read(Integer nno) throws Exception {
		return session.selectOne(namespace + ".read", nno);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer nno) throws Exception {
		session.delete(namespace + ".delete", nno);
	}

	@Override
	public void updateViewCnt(Integer nno) throws Exception {
		session.update(namespace + ".updateViewCnt", nno);
	}
}
