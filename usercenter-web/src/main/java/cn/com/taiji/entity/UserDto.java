package cn.com.taiji.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Id;

public class UserDto {

	public UserDto() {

	}

	// 设置主键
	@Id
	// 配置uuid，本来jpa是不支持uuid的，但借用hibernate的方法可以实现。

	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	private String userName;

	private String password;

	private String loginName;

	private String email;

	private String phoneNum;

	private String telephone;

	private String documentType;// 证件类型

	private String documentNum;// 证件号码

	protected Timestamp createdDate;

	protected Timestamp modifiedDate;

	private Integer delFlag;

	private Integer flag;

	private String state;

	// 用户类型
	private String puname;// 1.企业用户、2.管理机构用户、3.服务机构用户,4.个人用户

	// 用户标识
	private String userType;// 1.业务用户2.管理用户

	private Integer operateId;// 11新增,12修改，13删除

	private String openId;// 微信绑定openId

	private List<Application> applicationsList;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getDocumentNum() {
		return documentNum;
	}

	public void setDocumentNum(String documentNum) {
		this.documentNum = documentNum;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserName() {
		return userName;
	}

	public UserDto setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserDto setPassword(String password) {
		this.password = password;
		return this;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getPuname() {
		return puname;
	}

	public void setPuname(String puname) {
		this.puname = puname;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserDto(String id, String userName, String password, String loginName, String email, String phoneNum,
			String telephone, String documentNum, Timestamp createdDate, Timestamp modifiedDate, Integer delFlag,
			Integer flag, String state, String puname, String userType) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.loginName = loginName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.telephone = telephone;
		this.documentNum = documentNum;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.delFlag = delFlag;
		this.flag = flag;
		this.state = state;
		this.puname = puname;
		this.userType = userType;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public List<Application> getApplicationsList() {
		return applicationsList;
	}

	public void setApplicationsList(List<Application> applicationsList) {
		this.applicationsList = applicationsList;
	}

}
