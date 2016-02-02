package org.bfo.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bfo.domain.MemberDTO;
import org.bfo.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession session;

	public static String namespace = "org.bfo.persistence.MemberDAO";
	
	@Override
	public void createAccount(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		session.insert(namespace+".createAccount", vo);
	}

	@Override
	public MemberVO login(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".login" , dto);
	}

}
