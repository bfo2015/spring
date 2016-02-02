package org.bfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bfo.domain.Criteria;
import org.bfo.domain.PageMaker;
import org.bfo.domain.PollVO;
import org.bfo.domain.QnaReplyVO;
import org.bfo.service.QnaReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/replies")
public class QnaReplyController {

	
	@Autowired
	private QnaReplyService service;
	
	private static final Logger logger = LoggerFactory.getLogger(QnaReplyController.class);
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody QnaReplyVO vo){
		
		logger.info("====================댓글 등록할라고");
		ResponseEntity<String> entity = null;
		
		logger.info("====================vo의 내용은");
		logger.info("------------vo: "+vo.toString());
		
		try {
			service.addReply(vo);
			logger.info("====================등록은 잘 되었다");
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
					
		} catch (Exception e) {
			
			e.printStackTrace();
			
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value="/all/{qnano}",method=RequestMethod.GET)
	public ResponseEntity<List<QnaReplyVO>> list(@PathVariable("qnano")int qnano){
		
		ResponseEntity<List<QnaReplyVO>> entity =null;
		
		try {
			List<QnaReplyVO> list = service.listAll(qnano);
			entity = new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	
	@RequestMapping(value="/all/{qnano}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listPage(@PathVariable("qnano") int qnano,@PathVariable("page") int page){
		
		logger.info("====================댓글 볼라고");
		
		ResponseEntity<Map<String,Object>> entity = null;
		
		try {
			Criteria cri = new Criteria();
			
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			
			pageMaker.setCri(cri);
			
			Map<String,Object> map = new HashMap<String,Object>();
			
			List<QnaReplyVO> list = service.listReply(qnano, cri);
			
			logger.info("====================리스트는 잘 가져왔다. ");
			
			map.put("list", list);
			
			int replyCount = service.count(qnano);
			
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	@RequestMapping(value="/{rno}",method={RequestMethod.PATCH,RequestMethod.PUT})
	public ResponseEntity<String> update(@PathVariable("rno") int rno,@RequestBody QnaReplyVO vo){
		
		ResponseEntity entity = null;
		
		logger.info("--------------------------수--------정-------------------");
		
		vo.setRno(rno);
		try {
			service.modifyReply(vo);
			entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);
			logger.info("--------------------------수--------정----끝---------------");
		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno")int rno){
		
		logger.info("--------------------------삭--------제-------------------");
		ResponseEntity<String> entity = null;
		
		try {
			service.removeReply(rno);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			logger.info("--------------------------삭--------제--------끝-----------");
		} catch (Exception e) {

			e.printStackTrace();

			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
