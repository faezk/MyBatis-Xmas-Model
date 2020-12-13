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
import im430.MyBatisXmas.dao.AddressDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("DAOTest-context.xml")
//@Transactional

public class ChildDAOTest {
	
	@Autowired
	private ChildWithGiftsDAO childDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	
	//@Test
	public void testChildDAO() {
		
		Child e1 = new Child();
		e1.setGifts("Test Entry "+new Date());
		
		int len1 = childDAO.getAllChild().size();
		childDAO.addChild(e1);
		int len2 = childDAO.getAllChild().size();
		
		assertEquals(len1+1, len2);
		
		Child e2 = childDAO.getChild(e1.getId());
		assertEquals(e1.getGifts(),e2.getGifts());
		assertEquals(e1,e2);
		
		childDAO.removeChild(e1);
		assertEquals(len1, childDAO.getAllChild().size());
		
	}
	
	
	@Test
	public void shouldAddAddressToBlogEntry() {
		
		Address a1 = new Address();
		a1.setText("TestAddress "+new Date());
		addressDAO.addAddress(a1);
		
		Child e1 = new Child();
		e1.setGifts("Test Entry "+new Date());
		e1.setaddress(a1);
		
		childDAO.addChild(e1);
		Child e2 = childDAO.getChild(e1.getId());
		
		assertEquals(a1, e1.getaddress());
		assertEquals(e1.getaddress(),e2.getaddress());
				
		
	}
	
	
	@Test
	public void shouldAddAndRemoveGift() {
		
		Address a1 = new Address();
		a1.setText("Testlogin "+new Date());
		addressDAO.addAddress(a1);
		
		Child e1 = new Child();
		e1.setGifts("Test Entry "+new Date());
		e1.setaddress(a1);
		
		childDAO.addChild(e1);
		
		Gift  g1 = new Gift();
		g1.setGifts("Test Comment "+ new Date());
		
		int len1 = e1.getGifts().size();
		childDAO.addGift(e1, g1);
		
		assertEquals(len1+1, e1.getGifts().size());
		assertEquals(len1+1, childDAO.getChild(e1.getId()).getGifts().size());
		
	//	blogEntryDAO.removeComment(e1, c1);
		
	//	assertEquals(len1, e1.getComments().size());
	//	assertEquals(len1, blogEntryDAO.getBlogEntry(e1.getId()).getComments().size());
		
	}
	
	

}
