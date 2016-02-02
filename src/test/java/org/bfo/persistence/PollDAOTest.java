package org.bfo.persistence;

import java.util.List;

import org.bfo.domain.Criteria;
import org.bfo.domain.PollVO;
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
public class PollDAOTest {

	@Autowired
	private PollDAO dao;
	@Autowired
	private PollService service;
	
	
	
	private final static Logger logger = LoggerFactory.getLogger(PollDAOTest.class);
	
	
	@Test
	public void searchTest() throws Exception{
		
		Criteria cri = new Criteria();
		
		cri.setPage(1);
		cri.setKeyword("testman");
		cri.setSearchType("n");
		logger.info("================================");
		
		List<PollVO> list = dao.list(cri);
		
		for (PollVO vo : list) {
			logger.info(vo.getPno() + ":" + vo.getTopic());
		}
		
		
		//logger.info("count : " + dao.listCount(cri));
		
	}
	
	
	@Test
	public void serviceTest() throws Exception{
		logger.info("===============================");
		
		
		
		//logger.info(service.list().toString());
		
	}
	
	
	@Test
	public void readTest() throws Exception{
		logger.info("===============================");
		logger.info(dao.read(2).toString());
	}
	
	@Test
	public void createTest() throws Exception{

		
		
		PollVO vo = new PollVO();
		
		vo.setPollAddr("www.naver.com");
		vo.setTopic("�꽕�씠踰꾩� �떎�쓬以� 萸먭��뜑醫뗭짛?");
		vo.setMno(1);
		vo.setCategoryCode("category2");
		vo.setAnswerCode("answer1");
		vo.setPublicCode("public1");
		vo.setCloseCode("close1");
		vo.setLoginCode("login1");
		
		System.out.println(vo);
		logger.info("===============================");
		dao.create(vo);
		
	}
	
	@Test
	public void listTest() throws Exception{
		Criteria cri = new Criteria();
		
		cri.setPage(3);
		
		logger.info(dao.list(cri).toString());
	}
	
	@Test
	public void updateTest() throws Exception{
PollVO vo = new PollVO();
		
		vo.setPollAddr("www.daum.com");
		vo.setTopic("�꽕�씠踰꾩� �떎�쓬以� 萸먭��뜑醫뗭짛?");
		vo.setMno(1);
		vo.setCategoryCode("category2");
		vo.setAnswerCode("answer1");
		vo.setPublicCode("public1");
		vo.setCloseCode("close1");
		vo.setLoginCode("login1");
		vo.setPno(5);
		
		dao.update(vo);
	}

	@Test
	public void deleteTest() throws Exception{
		dao.delete(5);
	}

}
