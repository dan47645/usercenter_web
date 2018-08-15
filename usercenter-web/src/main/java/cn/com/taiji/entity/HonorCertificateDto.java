package cn.com.taiji.entity;

import java.io.Serializable;
import java.util.Date;



public class HonorCertificateDto extends QueryBase implements Serializable {

	private String id;
	private String name;// 荣誉
	private String getTime;// 获得时间
	private String validity;// 有效期
	private String filePath;// 文件地址
	private String fileName;// 文件
	private ServerOrg serverOrg;//服务机构
	private String sid;
	
	public HonorCertificateDto() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGetTime() {
		return getTime;
	}

	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ServerOrg getServerOrg() {
		return serverOrg;
	}

	public void setServerOrg(ServerOrg serverOrg) {
		this.serverOrg = serverOrg;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
