package com.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class NetSendMsg {
	/**
	 * @Description HTTP发送信息
	 * @param sendObject
	 * @throws IOException
	 * @author Wei_Xinxiang
	 * @time 2016年10月17日  下午2:19:53
	 */
	public static void send_object(Object sendObject) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				response.getOutputStream());
		objectOutputStream.writeObject(sendObject);
		objectOutputStream.flush();
		objectOutputStream.close();
	}
}
