package cn.com.taiji.entity;

import java.io.Serializable;

import javax.persistence.Column;



/**
 * @ClassName: EnterpriseInfoNewDto
 * @Description: TODO(前端显示vo)
 * @author lyp
 * @date 2018年1月23日 下午3:26:31
 * @version V1.0
 */
public class EnterpriseAndServerOrgInfoDto extends QueryBase implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	/************************* 企业信息 ***************************/
	// 企业ID
	private String enterpriseId;

	// 企业名称
	private String enterpriseName;
	// 社会统一信用代码
	private String creditCode;
	// 注册日期
	private String registerTime;
	// 法定代表人
	private String legalPerson;
	// 注册资金（万元）
	private String registerCapital;
	// 单位性质
	private String companyType;
	//单位性质名称
	private String companyTypeName;
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
	/*********************** 服务机构 ********************************/
	// 服务机构ID
	private String serverOrgId;
	// 资产总额
	private String totalAsset;
	// 净资产总额
	private String totalNetAsset;
	// 营业收入
	private String operatingIncome;
	//利润总额
	private String totalProfit;
	// 服务中小企业户数
	private String establishment;
	//服务简介------机构简介
	private String sAbstract;
	// 版权号
	private String publishNum;
	//特色服务产品介绍
	private String sCompant;
	private Integer delFlag=1;
	private Integer flag;
	
	
	public String getPublishNum() {
		return publishNum;
	}
	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
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
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
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
	public String getServerOrgId() {
		return serverOrgId;
	}
	public void setServerOrgId(String serverOrgId) {
		this.serverOrgId = serverOrgId;
	}
	public String getTotalAsset() {
		return totalAsset;
	}
	public void setTotalAsset(String totalAsset) {
		this.totalAsset = totalAsset;
	}
	public String getTotalNetAsset() {
		return totalNetAsset;
	}
	public void setTotalNetAsset(String totalNetAsset) {
		this.totalNetAsset = totalNetAsset;
	}
	public String getOperatingIncome() {
		return operatingIncome;
	}
	public void setOperatingIncome(String operatingIncome) {
		this.operatingIncome = operatingIncome;
	}
	public String getEstablishment() {
		return establishment;
	}
	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}
	public String getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(String totalProfit) {
		this.totalProfit = totalProfit;
	}
	public String getsAbstract() {
		return sAbstract;
	}
	public void setsAbstract(String sAbstract) {
		this.sAbstract = sAbstract;
	}
	public String getsCompant() {
		return sCompant;
	}
	public void setsCompant(String sCompant) {
		this.sCompant = sCompant;
	}
	public String getIsServerSysInput() {
		return isServerSysInput;
	}
	public void setIsServerSysInput(String isServerSysInput) {
		this.isServerSysInput = isServerSysInput;
	}
	public String getCompanyTypeName() {
		return companyTypeName;
	}
	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	

}
