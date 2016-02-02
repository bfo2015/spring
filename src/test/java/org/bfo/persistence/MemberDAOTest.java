package org.bfo.persistence;

import static org.junit.Assert.*;

import org.bfo.domain.MemberVO;
import org.bfo.service.MemberService;
import org.bfo.service.PollService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Autowired
	private MemberDAO dao;
	@Autowired
	private MemberService service;
	
	
	
	private final static Logger logger = LoggerFactory.getLogger(PollDAOTest.class);
	
	@Test
	public void test()throws Exception {
		
		MemberVO vo = new MemberVO();
		
		vo.setUserMail("junit@1.1");
		vo.setUserPw("1234");
		vo.setNickName("junitTestCase");
		
		service.createAccount(vo);
	}

}
