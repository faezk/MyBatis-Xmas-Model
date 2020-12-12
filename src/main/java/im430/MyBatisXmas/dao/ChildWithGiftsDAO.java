package im430.MyBatisXmas.dao;

import im430.MyBatisXmas.business.Child;
import im430.MyBatisXmas.business.Gift;

public interface ChildWithGiftsDAO extends ChildrenDAO{
	
	public void addGift(Child child, Gift gifts);
	public void removeGifts(Child child, Gift gifts);

}