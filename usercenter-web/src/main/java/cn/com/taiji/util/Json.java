package cn.com.taiji.util;

import java.util.ArrayList;
import java.util.List;

public class Json {
	private String msg="";
	private boolean isSuccess=false;
	private Object obj=null;
	private List list=new ArrayList();
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	

}
