package cn.com.taiji.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 荣誉证书
 * 2018-03-06
 *
 */
@Entity
@Table(name = "honor_certificate")
public class HonorCertificate extends Audited implements Serializable{

	@Column(name = "name")
	private String name;//荣誉称号
	
	@Column(name = "get_time")
	private String getTime;//获得时间 
	
	@Column(name = "validity")
	private String validity;//有效期
	
	@Column(name = "file_name")
	private String fileName;//荣誉证书文件
	
	@Column(name = "file_path")
	private String filePath;//荣誉证书文件地址
	
	/*
	@ManyToOne(cascade = { CascadeType.ALL }, optional = false)
	@NotFound(action=NotFoundAction.IGNORE) 
	@JoinColumn(name="s_org_id", insertable = true, updatable = true)
	private ServerOrg serverDept;//服务机构*/
	
	private String sid;//服务机构ID
	
	public HonorCertificate() {
		// TODO Auto-generated constructor stub
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	
	
}
