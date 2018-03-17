package net.aurore.datamanager;

import net.aurore.util.HibernateUtil;

public class DataManagerBuilder {

	public DataManager build(){
		return new DataManagerImpl(HibernateUtil.getSessionFactory().openSession());
	}
}
