package cn.com.taiji.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "application")
public class Application  extends Audited implements Serializable {

	/**
	 * Description:资源，即第三方应用信息，需要从"统一认证"项目库抽取到本地数据库
	 * @author 陈克成
	 */
	private static final long serialVersionUID = -602942328218470582L;
	
	@Column(name = "name")
	private String name;// app名称
	
	@Column(name = "url")
	private String url;// url路径
	
	@Column(name = "des")
	private String des;// 资源简介
	
	@Column(name = "type")
	private String type;// 资源分类
	
	@Column(name = "platform")
	private String platform;// 资源平台
	
	@Column(name = "client_id")
	private String clientId;// 
	
	@Column(name = "client_secret")
	private String clientSecret;//
	
	private String synUserUrl; //用户同步url
	
	private String synEnterpriseUrl; //企业同步url
	
	private String synOrgUrl; //机构同步url
	@Column(name = "is_need_role")
	private String isNeedRole; //是否需要授权，1是需要, 0是不需要
 
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER) 
	@JoinTable(name="app_user_rel", joinColumns={@JoinColumn(name="app_id")},
	inverseJoinColumns={@JoinColumn(name="user_id")})  
	private List<User> users;
	
	
	
	//----------------20180108--------------
	private String code;//资源编码
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getSynUserUrl() {
		return synUserUrl;
	}

	public void setSynUserUrl(String synUserUrl) {
		this.synUserUrl = synUserUrl;
	}

	public String getSynEnterpriseUrl() {
		return synEnterpriseUrl;
	}

	public void setSynEnterpriseUrl(String synEnterpriseUrl) {
		this.synEnterpriseUrl = synEnterpriseUrl;
	}

	public String getSynOrgUrl() {
		return synOrgUrl;
	}

	public void setSynOrgUrl(String synOrgUrl) {
		this.synOrgUrl = synOrgUrl;
	}

	public String getIsNeedRole() {
		return isNeedRole;
	}

	public void setIsNeedRole(String isNeedRole) {
		this.isNeedRole = isNeedRole;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
