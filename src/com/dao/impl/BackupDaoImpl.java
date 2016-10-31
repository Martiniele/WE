package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.dao.IBackupDao;
import com.model.Backup;

public class BackupDaoImpl implements IBackupDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void SaveBackUp(Backup backup) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(backup);
		tx.commit();
		session.close();
	}
	@Override
	public String DownloadBackUp(String name) {
		
		return null;
	}

}
