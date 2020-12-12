package im430.MyBatisXmas.dao;

import java.util.List;

import im430.MyBatisXmas.business.Child;

public interface ChildrenDAO {
	
	public void addChild(Child child);

	public Child getChild(int id);

	public List<Child> getAllChild();

	public void updateChild(Child child);

	public void removeChild(Child child);

}
