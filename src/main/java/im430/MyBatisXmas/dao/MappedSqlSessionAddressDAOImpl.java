package im430.MyBatisXmas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import im430.MyBatisXmas.business.Address;
import im430.MyBatisXmas.business.Child;

@Repository
@Transactional
public class MappedSqlSessionAddressDAOImpl implements AddressDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addAddress(Address address) {
		sqlSession.insert("im430.MyBatisXmas.dao.MappedSqlSessionAddressDAOImpl.addAddress", address);
	}

	@Override
	@Transactional(readOnly=true)
	public Address getAddress(int id) {
		return sqlSession.selectOne("im430.MyBatisXmas.dao.MappedSqlSessionAddressDAOImpl.getAddressById", id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Address> getAllAddress() {
		return sqlSession.selectList("im430.MyBatisXmas.dao.MappedSqlSessionAddressDAOImpl.getAllAddress");
	}

	@Override
	public void removeAddress(Address address) {
		sqlSession.delete("im430.MyBatisXmas.dao.MappedSqlSessionAddressDAOImpl.deleteAddress", address);
	}
	
	@Override
	public void updateAddress(Address address) {
		sqlSession.update(
				"im430.MyBatisXmas.dao.MappedSqlSessionAddressDAOImpl.updateAddress", 
				address);
	}


}
