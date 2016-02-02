package org.bfo.persistence;

import org.bfo.domain.MemberDTO;
import org.bfo.domain.MemberVO;

public interface MemberDAO {

	//회원 가입
	public void createAccount(MemberVO vo)throws Exception;
	
	//아이디와 패스워드를 이용해서 사용자 정보를 조회
	public MemberVO login(MemberDTO dto)throws Exception;
	
}
