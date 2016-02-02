package org.bfo.service;

import org.bfo.domain.MemberDTO;
import org.bfo.domain.MemberVO;
import org.bfo.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	
	@Override
	public void createAccount(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.createAccount(vo);
	}


	@Override
	public MemberVO login(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

}
