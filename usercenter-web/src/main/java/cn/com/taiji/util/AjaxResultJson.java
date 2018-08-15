package cn.com.taiji.util;

/**
 * 自定义ajax交互返回数据结果类
 * @author SunJingyan
 * @date 2014年5月1日
 *
 */
public class AjaxResultJson {
	
	private boolean success=false;
	
	private Object obj;
	
	private String msg;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
