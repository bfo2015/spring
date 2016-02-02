package org.bfo.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bfo.domain.AllVO;
import org.bfo.domain.CategoryVO;
import org.bfo.domain.Criteria;
import org.bfo.domain.FileVO;
import org.bfo.domain.TextVO;
import org.bfo.domain.PollVO;
import org.springframework.stereotype.Repository;

@Repository
public class PollDAOImpl implements PollDAO {

	@Inject
	private SqlSession session;

	public static String namespace = "org.bfo.persistence.PollDAO";

	@Override
	public List<PollVO> list(Criteria cri) throws Exception {
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public void create(PollVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public PollVO read(int pno) throws Exception {
		return session.selectOne(namespace + ".read", pno);
	}

	@Override
	public void update(PollVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int pno) throws Exception {
		session.delete(namespace + ".delete", pno);
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".listCount", cri);
	}

	@Override
	public PollVO setting(int pno) throws Exception {
		return session.selectOne(namespace + ".setting", pno);
	}

	@Override
	public List<CategoryVO> categoryList() throws Exception {
		return session.selectList(namespace + ".categoryList");
	}

	@Override
	public int newPno() throws Exception {
		return session.selectOne(namespace + ".newPno");
	}

	@Override
	public void createUpt(PollVO vo) throws Exception {
		session.update(namespace + ".createupt", vo);
	}

	@Override
	public void addAttach(FileVO file) throws Exception {
		session.insert(namespace + ".addAttach", file);
	}

	@Override
	public void addItem(TextVO item) throws Exception {
		session.insert(namespace + ".addItem", item);
	}


	
	@Override
	public void deleteFile(int pno) throws Exception {
		session.delete(namespace + ".deleteFile", pno);
	}
	
	@Override
	public void deleteItem(int pno) throws Exception {
		session.delete(namespace + ".deleteItem", pno);
	}

	@Override
	public int checkFile(int pno) throws Exception {
		return session.selectOne(namespace + ".checkFile", pno);
		
	}

	@Override
	public int checkItem(int pno) throws Exception {
		return session.selectOne(namespace + ".checkItem", pno);
	}

	@Override
	public AllVO readAll(int pno) throws Exception {
		return session.selectOne(namespace + ".readAll", pno);
	}
	
	
	@Override
	public List<FileVO> readAttach(int pno) throws Exception {
		return session.selectList(namespace + ".readAttach", pno);
	}

	@Override
	public List<TextVO> readItem(int pno) throws Exception {
		return session.selectList(namespace + ".readItem", pno);
	}
}
