package im430.MyBatisXmas.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import im430.MyBatisXmas.business.Address;
import im430.MyBatisXmas.business.Gift;


public class Child {

	private int id;
	private String name;
	private Address address;
	private List<Gift> gifts;
	
	public Child(){
		this.id=-1;
		this.name="";
		this.address = null;
		this.gifts = new ArrayList<Gift>();		
	}
	
	public Address getaddress() {
		return address;
	}

	public void setAuthor(Address address) {
		this.address = address;
	}
	
	public List<Gift> getGifts() {
		return gifts;
	}

	public void setGifts(List<Gift> gifts) {
		this.gifts = gifts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}