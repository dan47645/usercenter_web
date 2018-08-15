package cn.com.taiji.entity;

import java.io.Serializable;


public class AppUserRelDto extends QueryBase implements Serializable{

	/**
	 * Description:
	 * @author 陈克成
	 */
	private static final long serialVersionUID = -2357996082388573376L;
	
	private String token = "";
	
	private Long id;
	
	private String userId;
	
	private String appId; 
	
	private Integer auditorStatus;
	
	private String orgId;
	
	private String des;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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
