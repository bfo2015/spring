package org.bfo.service;

import java.util.List;

import org.bfo.domain.AllVO;
import org.bfo.domain.CategoryVO;
import org.bfo.domain.Criteria;
import org.bfo.domain.FileVO;
import org.bfo.domain.ItemVO;
import org.bfo.domain.PollVO;
import org.bfo.domain.TextVO;
import org.bfo.persistence.PollDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PollServiceImpl implements PollService {

   @Autowired
   private PollDAO dao;

   @Override
   public List<PollVO> list(Criteria cri) throws Exception {
      return dao.list(cri);
   }

   @Override
   public void regist(PollVO vo) throws Exception {
      dao.create(vo);
   }

   @Override
   public PollVO view(int pno) throws Exception {
      return dao.read(pno);
   }
   
   @Override
   public AllVO viewAll(int pno) throws Exception {
	  AllVO allVO = new AllVO();
	  allVO = dao.readAll(pno);
	  List<FileVO> files = dao.readAttach(pno);
	  List<TextVO> texts = dao.readItem(pno);
	  
	  allVO.setFiles(files);
	  allVO.setTexts(texts);
	  
	  return allVO;
   }
	
   @Transactional
   @Override
   public void modify(PollVO vo, ItemVO itemVO) throws Exception {
	  
	  dao.deleteFile(vo.getPno());
	  dao.deleteItem(vo.getPno());
	  
	  dao.update(vo);
	  
	  List<String> files = itemVO.getFiles();
      List<String> texts = itemVO.getTexts();
      
      for(int i=0; i<files.size(); i++){
         if(files.get(i) == ""){
            continue;
         }
         FileVO file = new FileVO();
         file.setFullName(files.get(i));
         file.setPno(vo.getPno());
         file.setPnoFileNo(i);
         
         dao.addAttach(file);
      }

      if(texts != null){
         for(int i=0; i<texts.size(); i++){
            if(texts.get(i) == ""){
               continue;
            }
            TextVO item = new TextVO();
            item.setSelectItem(texts.get(i));
            item.setPno(vo.getPno());
            item.setPnoItemNo(i+1);
            
            dao.addItem(item);
         }
      }
	  
   }

   @Override
   public void remove(int pno) throws Exception {
      dao.delete(pno);
   }

   @Override
   public int listCount(Criteria cri) throws Exception {
      return dao.listCount(cri);
   }

   @Override
   public PollVO setting(int pno) throws Exception {
      return dao.setting(pno);
   }

   @Override
   public List<CategoryVO> categoryList() throws Exception {
      return dao.categoryList();
   }
   
   @Transactional
   @Override
   public void registUpt(PollVO vo,ItemVO itemVO) throws Exception {
      dao.update(vo);
      
      List<String> files = itemVO.getFiles();
      List<String> texts = itemVO.getTexts();
      
      for(int i=0; i<files.size(); i++){
         if(files.get(i) == ""){
            continue;
         }
         FileVO file = new FileVO();
         file.setFullName(files.get(i));
         file.setPno(vo.getPno());
         file.setPnoFileNo(i);
         
         dao.addAttach(file);
      }

      if(texts != null){
         for(int i=0; i<texts.size(); i++){
            if(texts.get(i) == ""){
               continue;
            }
            TextVO item = new TextVO();
            item.setSelectItem(texts.get(i));
            item.setPno(vo.getPno());
            item.setPnoItemNo(i+1);
            
            dao.addItem(item);
         }
      }
   }

   @Override
	public int newPno() throws Exception {
		return dao.newPno();
	}

	@Override
	public List<FileVO> readAttach(int pno) throws Exception {
		return dao.readAttach(pno);
	}
	
	@Override
	public List<TextVO> readItem(int pno) throws Exception {
		return dao.readItem(pno);
	}
      
      @Override
	public void removeFile(int pno) throws Exception {
		dao.deleteFile(pno);
	}
	
	@Override
	public void removeItem(int pno) throws Exception {
		dao.deleteItem(pno);
	}

	@Override
	public int checkFile(int pno) throws Exception {
		return dao.checkFile(pno);
	}

	@Override
	public int checkItem(int pno) throws Exception {
		return dao.checkItem(pno);
	}

}

