package im430.MyBatisXmas.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import im430.MyBatisXmas.business.Child;
import im430.MyBatisXmas.business.Gift;
import im430.MyBatisXmas.business.Address;
import im430.MyBatisXmas.dao.ChildrenDAO;
import im430.MyBatisXmas.dao.ChildWithGiftsDAO;
//import im430.simpleblog.dao.MemoryBlogEntryDAOImpl;
//import im430.MyBatisXmas.dao.MySqlChildDAOImpl;
import im430.MyBatisXmas.dao.AddressDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("DAOTest-context.xml")
//@Transactional

public class ChildDAOTest {
	
	@Autowired
	private ChildWithGiftsDAO ChildDAO;
	
	
	@Test
	public void testChildDAO() {
		
		Child e1 = new Child();
		e1.setName("Test Entry "+new Date());
		
		int len1 = ChildDAO.getAllChild().size();
		ChildDAO.addChild(e1);
		int len2 = ChildDAO.getAllChild().size();
		
		assertEquals(len1+1, len2);
		
		//Child e2 = ChildDAO.getChild(e1.getId());
		//assertEquals(e1.getContents(),e2.getContents());
		//assertEquals(e1,e2);
		
		ChildDAO.removeChild(e1);
		assertEquals(len1, ChildDAO.getAllChild().size());
		
	}
	
	

}
