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
 * 资质证书 2018-03-06
 *
 */
@Entity
@Table(name = "certification")
public class Certification extends AuditedOther implements Serializable {

	@Column(name = "name")
	private String name;// 资质名称

	@Column(name = "get_time")
	private String getTime;// 获得时间

	@Column(name = "validity")
	private String validity;// 有效期

	@Column(name = "file_name")
	private String fileName;// 资质证明文件

	@Column(name = "file_path")
	private String filePath;// 资质证明文件地址
	
	/*
	@ManyToOne(cascade = { CascadeType.ALL }, optional = false)
	@NotFound(action=NotFoundAction.IGNORE) 
	@JoinColumn(name="s_org_id", insertable = true, updatable = true)
	private ServerOrg serverOrg;//服务机构 */
	
	private String sid;

	public Certification() {
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
