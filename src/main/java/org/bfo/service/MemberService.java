package org.bfo.service;

import org.bfo.domain.MemberDTO;
import org.bfo.domain.MemberVO;

public interface MemberService {

	public void createAccount(MemberVO vo)throws Exception;
	
	public MemberVO login(MemberDTO dto)throws Exception;
	
}
