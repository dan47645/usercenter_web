package cn.com.taiji.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "app_user_rel")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "SEQ_APP_USER_REL")
public class AppUserRel implements Serializable {
	

	private static final long serialVersionUID = -4280782187788847181L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "app_id")
	private String appId;
	
	@Column(name = "org_id")
	private String orgId;
	
	@Column(name = "auditor_status")
	private Integer auditorStatus;
	
	@Column(name = "des")
	private String des;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Integer getAuditorStatus() {
		return auditorStatus;
	}

	public void setAuditorStatus(Integer auditorStatus) {
		this.auditorStatus = auditorStatus;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	

}
