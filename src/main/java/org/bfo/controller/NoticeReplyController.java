package org.bfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.bfo.domain.Criteria;
import org.bfo.domain.NoticeReplyVO;
import org.bfo.domain.PageMaker;
import org.bfo.service.NoticeReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nReplies")
public class NoticeReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(PollController.class);

	@Inject
	private NoticeReplyService service;
	
	@RequestMapping(value="/all/{nno}", method=RequestMethod.GET)
	public ResponseEntity<List<NoticeReplyVO>> list(@PathVariable("nno") Integer nno) {
		logger.info("============ noticereply list get ============");
		ResponseEntity<List<NoticeReplyVO>> entity = null;
		try{
			entity = new ResponseEntity<>(service.listReply(nno), HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> regist(@RequestBody NoticeReplyVO vo) {
		logger.info("============ noticereply regist post ============");
		ResponseEntity<String> entity = null;
		try{
			service.registReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> modify(@PathVariable("rno") Integer rno, @RequestBody NoticeReplyVO vo) {
		logger.info("============ noticereply modify put ============");
		ResponseEntity<String> entity = null;
		try{
			vo.setRno(rno);
			service.modifyReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno) {
		logger.info("============ noticereply remove delete ============");
		ResponseEntity<String> entity = null;
		try{
			service.removeReply(rno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{nno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("nno") Integer nno, @PathVariable("page") Integer page) {
		logger.info("============ noticereply listpage get ============");
		ResponseEntity<Map<String, Object>> entity = null;
		try{
			Criteria cri = new Criteria();
			cri.setPage(page);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			Map<String, Object> map = new HashMap<String, Object>();
			List<NoticeReplyVO> list = service.listReplyPage(nno, cri);
			map.put("list", list);
			int replyCount = service.count(nno);
			pageMaker.setTotalCount(replyCount);
			map.put("pageMaker", pageMaker);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
