package com.service;

import com.model.Backup;

public interface IBackupService {
	public void SaveBackUp(Backup backup);
	public String DownloadBackUp(String name);
}
