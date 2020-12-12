package im430.MyBatisXmas.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import im430.MyBatisXmas.business.Child;
import im430.MyBatisXmas.business.Gift;

public class MappedSqlSessionChildDAOImpl implements ChildWithGiftsDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addChild(Child child) {
		sqlSession.insert(
				"im430.MyBatisXmas.dao.MappedSqlSessionChildDAOImpl.addChild", 
				child);
	}

	@Override
	@Transactional(readOnly=true)
	public Child getChild(int id) {
		return 	sqlSession.selectOne(
				"im430.MyBatisXmas.dao.MappedSqlSessionChildDAOImpl.joinedGetChildById", 
				//"im430.simpleblog.dao.MappedSqlSessionBlogEntryDAOImpl.getBlogEntryById", 
				id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Child> getAllChild() {
		return 	sqlSession.selectList(
				"im430.MyBatisXmas.dao.MappedSqlSessionChildDAOImpl.joinedGetAllChild");
				//"im430.simpleblog.dao.MappedSqlSessionBlogEntryDAOImpl.getAllBlogEntries");
	}

	@Override
	public void updateChild(Child child) {
		sqlSession.update(
				"im430.MyBatisXmas.dao.MappedSqlSessionChildDAOImpl.updateChild", 
				child);
	}

	@Override
	public void removeChild(Child child) {
		sqlSession.delete(
				"im430.MyBatisXmas.dao.MappedSqlSessionChildDAOImpl.deleteChild", 
				child);
	}

	@Override
	public void addGift(Child child, Gift gifts) {
		Map<String, Object> sqlParameters = new HashMap<String, Object>();
		sqlParameters.put("gifts", gifts);
		sqlParameters.put("childId", child.getId());
		
		sqlSession.insert(
				"im430.MyBatisXmas.dao.MappedSqlSessionChildDAOImpl.addGift",
				sqlParameters);
		
		child.getGifts().add(gifts);	
	}

	@Override
	public void removeGifts(Child child, Gift gifts) {
		
		sqlSession.delete(
				"im430.MyBatisXmas.dao.MappedSqlSessionChildDAOImpl.removeGifts",
				gifts);
		
		child.getGifts().remove(gifts);
		gifts.setId(-1);
	}

}
