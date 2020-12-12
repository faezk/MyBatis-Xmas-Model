package im430.MyBatisXmas.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import im430.MyBatisXmas.business.Address;
import im430.MyBatisXmas.dao.AddressDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("DAOTest-context.xml")
@Transactional

public class AddressDAOTest {
	
	@Autowired
	private AddressDAO AddressDAO;
	
	@Test
	public void AddressDAOTest() {
		
		Address u1 = new Address();
		u1.setText("Testtext "+new Date());
		
		int len1 = AddressDAO.getAllAddress().size();
		AddressDAO.addAddress(u1);
		assertEquals(len1+1, AddressDAO.getAllAddress().size());
		
		
		AddressDAO.removeAddress(u1);
		assertEquals(len1, AddressDAO.getAllAddress().size());
		
	}

}
