package cn.com.taiji.entity;

import java.io.Serializable;
import java.util.Date;

public class EnterpriseFromServerDto implements Serializable {

	    private String id;
	    // 企业名称
		private String enterpriseName;
		// 社会统一信用代码
		private String creditCode;
		// 注册日期
		private Date registerTime;
		// 法定代表人
		private String legalPerson;
		// 注册资金（万元）
		private String registerCapital;
		// 单位性质
		private String companyType;
		// 服务类别category（一级）
		private String firstCategory;
		// 服务类别（二级）
		private String secondCategory;
		// 联系人
		private String linkMan;
		// 手机号码
		private String cellPhone;
		// 办公电话
		private String linkPhone;
		// 电子邮箱
		private String email;
		// 传真
		private String fax;
		// 通讯地址
		private String postalAddress;
		// 企业网址
		private String webSite;
		// 是否有在线服务系统
		private String isServerSys;
		//
		private String isServerSysInput;
		// 是否有固定经营场所
		private String isBusinessPlace;
		// 服务场地总面积（平方米）
		private String serverPlaceArea;
		// 从业人员总数（人）
		private String employees;
		// 营业执照
		private String businessLicence;
		// 办公场所的产权证明或租用合同：
		private String contractAttachment;
		// 其他附件
		private String otherAttachment;
		
		// 注册日期------String类型
		private String registTime;
		
		public EnterpriseFromServerDto() {
			// TODO Auto-generated constructor stub
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEnterpriseName() {
			return enterpriseName;
		}

		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}

		public String getCreditCode() {
			return creditCode;
		}

		public void setCreditCode(String creditCode) {
			this.creditCode = creditCode;
		}

		public Date getRegisterTime() {
			return registerTime;
		}

		public void setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
		}

		public String getLegalPerson() {
			return legalPerson;
		}

		public void setLegalPerson(String legalPerson) {
			this.legalPerson = legalPerson;
		}

		public String getRegisterCapital() {
			return registerCapital;
		}

		public void setRegisterCapital(String registerCapital) {
			this.registerCapital = registerCapital;
		}

		public String getCompanyType() {
			return companyType;
		}

		public void setCompanyType(String companyType) {
			this.companyType = companyType;
		}

		public String getFirstCategory() {
			return firstCategory;
		}

		public void setFirstCategory(String firstCategory) {
			this.firstCategory = firstCategory;
		}

		public String getSecondCategory() {
			return secondCategory;
		}

		public void setSecondCategory(String secondCategory) {
			this.secondCategory = secondCategory;
		}

		public String getLinkMan() {
			return linkMan;
		}

		public void setLinkMan(String linkMan) {
			this.linkMan = linkMan;
		}

		public String getCellPhone() {
			return cellPhone;
		}

		public void setCellPhone(String cellPhone) {
			this.cellPhone = cellPhone;
		}

		public String getLinkPhone() {
			return linkPhone;
		}

		public void setLinkPhone(String linkPhone) {
			this.linkPhone = linkPhone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFax() {
			return fax;
		}

		public void setFax(String fax) {
			this.fax = fax;
		}

		public String getPostalAddress() {
			return postalAddress;
		}

		public void setPostalAddress(String postalAddress) {
			this.postalAddress = postalAddress;
		}

		public String getWebSite() {
			return webSite;
		}

		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}

		public String getIsServerSys() {
			return isServerSys;
		}

		public void setIsServerSys(String isServerSys) {
			this.isServerSys = isServerSys;
		}

		public String getIsServerSysInput() {
			return isServerSysInput;
		}

		public void setIsServerSysInput(String isServerSysInput) {
			this.isServerSysInput = isServerSysInput;
		}

		public String getIsBusinessPlace() {
			return isBusinessPlace;
		}

		public void setIsBusinessPlace(String isBusinessPlace) {
			this.isBusinessPlace = isBusinessPlace;
		}

		public String getServerPlaceArea() {
			return serverPlaceArea;
		}

		public void setServerPlaceArea(String serverPlaceArea) {
			this.serverPlaceArea = serverPlaceArea;
		}

		

		public String getEmployees() {
			return employees;
		}

		public void setEmployees(String employees) {
			this.employees = employees;
		}

		public String getBusinessLicence() {
			return businessLicence;
		}

		public void setBusinessLicence(String businessLicence) {
			this.businessLicence = businessLicence;
		}

		public String getContractAttachment() {
			return contractAttachment;
		}

		public void setContractAttachment(String contractAttachment) {
			this.contractAttachment = contractAttachment;
		}

		public String getOtherAttachment() {
			return otherAttachment;
		}

		public void setOtherAttachment(String otherAttachment) {
			this.otherAttachment = otherAttachment;
		}

		public String getRegistTime() {
			return registTime;
		}

		public void setRegistTime(String registTime) {
			this.registTime = registTime;
		}
		
		
}
