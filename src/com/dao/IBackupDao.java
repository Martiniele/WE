package com.dao;

import com.model.Backup;

public interface IBackupDao {
	public void SaveBackUp(Backup backup);
	public String DownloadBackUp(String name);
}
