package com.service.impl;

import com.dao.IBackupDao;
import com.model.Backup;
import com.service.IBackupService;

public class BackupServiceImpl implements IBackupService {
	private IBackupDao backupDao;
	
	public IBackupDao getBackupDao() {
		return backupDao;
	}

	public void setBackupDao(IBackupDao backupDao) {
		this.backupDao = backupDao;
	}

	@Override
	public void SaveBackUp(Backup backup) {
		backupDao.SaveBackUp(backup);
	}

	@Override
	public String DownloadBackUp(String name) {
		return backupDao.DownloadBackUp(name);
	}

}
