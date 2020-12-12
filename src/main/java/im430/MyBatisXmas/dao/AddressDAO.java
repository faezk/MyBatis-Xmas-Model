package im430.MyBatisXmas.dao;

import java.util.List;

import im430.MyBatisXmas.business.Address;

public interface AddressDAO {
	public void addAddress(Address address);

	public Address getAddress(int id);

	public List<Address> getAllAddress();

	public void updateAddress(Address address);

	public void removeAddress(Address address);


}
