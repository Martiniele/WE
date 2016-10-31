package com.actions;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.criteria.Root;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.model.Backup;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IBackupService;

public class BackupAction extends ActionSupport {
	private IBackupService backupService;

	public IBackupService getBackupService() {
		return backupService;
	}

	public void setBackupService(IBackupService backupService) {
		this.backupService = backupService;
	}

	public void saveBackup() throws IOException, FileUploadException {
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(ServletActionContext.HTTP_REQUEST);
		String uid = "";
		String uname = "";
		System.out.println("UUID="+request.getParameter("Id"));
		System.out.println("UUNAME="+request.getParameter("Username"));
		System.out.println("File="+request.getInputStream());
  		String savepath = ServletActionContext.getServletContext().getRealPath("/files/backup");
		File file = new File(savepath);
		if(!file.exists() && !file.isDirectory()){
			System.out.println("目录不存在");
			file.mkdir();
			System.out.println("目录已经创建！");
			System.out.println(file.getPath());
		}
		File f = new File("D:/我的临时文件");
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024 * 1024, f);
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		servletFileUpload.setFileSizeMax(1024*1024*1024);
		servletFileUpload.setHeaderEncoding("UTF-8");
		if(!servletFileUpload.isMultipartContent(request)){
			System.out.println("出错");
			return;
		}
		List<FileItem> list = new ArrayList<FileItem>();
		list = servletFileUpload.parseRequest(request);
		System.out.println("获取的集合大小="+list.size());
		System.out.println("执行到这里");
		for(FileItem item:list){
			System.out.println("进入循环");
			if(item.isFormField()){
				System.out.println("表结构");
				String name = item.getFieldName();
				String value = item.getString("UTF-8");
				if(name.equals("Id")){
					uid = value;
					System.out.println("ID="+uid);
				}
				if(name.equals("Username")){
					uname = value;
					System.out.println("Name="+uname);
				}
				System.out.println("获取其他字段完毕");
			}else {
				System.out.println("准备文件读取");
				String filename = item.getName().toLowerCase();
				System.out.println(filename);
				if(filename == null || filename.trim().equals("")){
					continue;
				}
				filename = filename.substring(filename.lastIndexOf(".")+1);
				Calendar CC = Calendar.getInstance();
				int YY = CC.get(Calendar.YEAR);
				int MM = CC.get(Calendar.MONTH)+1;
				int DD = CC.get(Calendar.DATE);
				int HH = CC.get(Calendar.HOUR);
				int NN = CC.get(Calendar.MINUTE);
				int SS = CC.get(Calendar.SECOND);
				int MS = CC.get(Calendar.MILLISECOND);
				int min = 0;
				int max = 10000;
				Random random = new Random();
				int s = random.nextInt(max) % (max-min+1)+min;
				String rename = String.valueOf(YY)+String.valueOf(MM)+String.valueOf(DD)
								+String.valueOf(HH)+String.valueOf(NN)+String.valueOf(SS)
								+String.valueOf(MS)+String.valueOf(s);
				filename = rename + "." + filename;
				String path = savepath + "/" +filename;
				InputStream in = item.getInputStream();
				FileOutputStream filestr = new FileOutputStream(path);
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len = in.read(buffer))>0){
					filestr.write(buffer,0,len);
				}
				in.close();
				filestr.close();
				item.delete();
				System.out.println("文件获取完毕");
			}
		}
		System.out.println("执行完毕");
	}
}