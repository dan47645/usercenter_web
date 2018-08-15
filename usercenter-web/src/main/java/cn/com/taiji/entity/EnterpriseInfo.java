package cn.com.taiji.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "enterprise_info")
public class EnterpriseInfo {
	// 设置主键
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	// 企业名称
		@Column(name = "enterprise_name")
		private String enterpriseName;
		// 社会统一信用代码
		@Column(name = "credit_Code")
		private String creditCode;
		// 注册日期
		@Column(name = "register_Time")
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date registerTime;
		// 法定代表人
		@Column(name = "legal_Person")
		private String legalPerson;
		// 注册资金（万元）
		@Column(name = "register_Capital")
		private String registerCapital;
		// 单位性质
		@Column(name = "company_Type")
		private String companyType;
		//单位性质名称
		@Column(name = "company_Type_Name")
		private String companyTypeName;
		// 服务类别category（一级）
		@Column(name = "first_Category")
		private String firstCategory;
		// 服务类别（二级）
		@Column(name = "second_Category")
		private String secondCategory;
		// 联系人
		@Column(name = "link_Man")
		private String linkMan;

		// 手机号码
		@Column(name = "cell_Phone")
		private String cellPhone;
		// 办公电话
		@Column(name = "link_Phone")
		private String linkPhone;
		// 电子邮箱
		@Column(name = "email")
		private String email;
		// 传真
		@Column(name = "fax")
		private String fax;
		// 通讯地址
		@Column(name = "postal_Address")
		private String postalAddress;
		// 企业网址
		@Column(name = "webSite")
		private String webSite;
		// 是否有在线服务系统
		@Column(name = "is_ServerSys")
		private String isServerSys;
		//
		@Column(name = "is_ServerSysInput")
		private String isServerSysInput;
		// 是否有固定经营场所
		@Column(name = "is_BusinessPlace")
		private String isBusinessPlace;
		// 服务场地总面积（平方米）
		@Column(name = "server_PlaceArea")
		private String serverPlaceArea;
		// 从业人员总数（人）
		@Column(name = "employees")
		private String employees;
		// 营业执照
		@Column(name = "business_Licence")
		private String businessLicence;
		// 办公场所的产权证明或租用合同：
		@Column(name = "contract_Attachment")
		private String contractAttachment;
		// 其他附件
		@Column(name = "other_Attachment")
		private String otherAttachment;

		@Column(name="del_flag")
		private Integer delFlag=1;
		@Column(name="flag")
		private Integer flag;
		// 企业规模
		@Column(name = "scale")
		private String scale;
		// 注册地
		@Column(name = "register_address")
		private String registerAddress;
		// 实际经营地
		@Column(name = "business_address")
		private String businessAddress;

		// 邮政编码
		@Column(name = "zipcode")
		private String zipCode;
		// 网址
		@Column(name = "enterurl")
		private String enterUrl;
		// 总占地面积
		@Column(name = "total_area")
		private Double totalArea;
		// 厂房面积
		@Column(name = "plant_area")
		private Double plantArea;
		// 组织机构代码
		@Column(name = "org_code")
		private String orgCode;
		// 开业（成立）时间
		@Column(name = "opening_time")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date openingTime;
		// 企业登记注册类型
		@Column(name = "register_type")
		private String registerType;
		// 国民经济分类代码
		@Column(name = "economic_code")
		private String economicCode;
		// 所属行业
		@Column(name = "industry")
		private String industry;
		// 行业代码
		@Column(name = "industry_code")
		private String industryCode;
		// 控股情况
		@Column(name = "stake")
		private String stake;
		// 经营许可证号
		@Column(name = "license_num")
		private String licenseNum;
		// 职工人数
		@Column(name = "workers")
		private String workers;
		// 是否上市企业
		@Column(name = "is_listed")
		private String isListed;
		// 股票代码
		@Column(name = "stock_code")
		private String stockCode;
		// 是否资质等级的建筑企业
		@Column(name = "is_qualification")
		private String isQualification;
		// 是否属于高新技术产业
		@Column(name = "is_hightechnology")
		private String isHightechnology;
		// 是否出口企业
		@Column(name = "is_export_unit")
		private String isExportUnit;
		// 出口产品分类
		@Column(name = "export_product_classify")
		private String exportProductClassify;
		// 是否返乡农民工创业企业
		@Column(name = "is_entrepreneurship")
		private String isEntrepreneurship;
		// 是否食品类农产品加工企业
		@Column(name = "is_agrotechny")
		private String isAgrotechny;
		// 是否农产品加工景气调查监测样本企业
		@Column(name = "is_survey")
		private String isSurvey;
		// 是否休闲农业经营主体
		@Column(name = "is_agritourism")
		private String isAgritourism;
		// 休闲农业类型
		@Column(name = "agritourism_type")
		private String agritourismType;
		// 是否乡镇/城区企业
		@Column(name = "is_township")
		private String isTownship;
		// 是否开发区企业
		@Column(name = "is_developmentzone")
		private String isDevelopmentzone;
		// 是否工信部企业
		@Column(name = "is_miit")
		private String isMiit;
		// 工信部帐号
		@Column(name = "miit_account")
		private String miitAccount;
		// 税务登记证号
		@Column(name = "certificate_num")
		private String certificateNum;
		// 纳税人状态
		@Column(name = "taxpayer_state")
		private String taxpayerState;
		// 纳税人状态名称
		@Column(name = "taxpayer_state_name")
		private String taxpayerStateName;
		// 发证机构
		@Column(name = "issuing_agency")
		private String issuingAgency;
		// 经营范围
		@Column(name = "business_scope")
		private String businessScope;
		// 企业状态
		@Column(name = "state")
		private String state;
		// 版本号
		@Column(name = "pulish_num")
		private String publishNum;
	public EnterpriseInfo() {
		super();
	}

	public EnterpriseInfo(String enterpriseName, String creditCode, String registerCapital, String legalPerson,
			String scale, String registerAddress, String businessAddress, String linkMan, String linkPhone,
			String cellPhone, String fax, String zipCode, String email, String enterUrl, Double totalArea,
			Double plantArea, String orgCode, Date openingTime, String registerType, String economicCode,
			String industry, String industryCode, String stake, String licenseNum, String workers, String isListed,
			String stockCode, String isQualification, String isHightechnology, String isExportUnit,
			String exportProductClassify, String isEntrepreneurship, String isAgrotechny, String isSurvey,
			String isAgritourism, String agritourismType, String isTownship, String isDevelopmentzone, String isMiit,
			String miitAccount, String certificateNum, String taxpayerState, String taxpayerStateName,
			String issuingAgency, String businessScope, String state, String publishNum) {
		super();
		this.enterpriseName = enterpriseName;
		this.creditCode = creditCode;
		this.registerCapital = registerCapital;
		this.legalPerson = legalPerson;
		this.scale = scale;
		this.registerAddress = registerAddress;
		this.businessAddress = businessAddress;
		this.linkMan = linkMan;
		this.linkPhone = linkPhone;
		this.cellPhone = cellPhone;
		this.fax = fax;
		this.zipCode = zipCode;
		this.email = email;
		this.enterUrl = enterUrl;
		this.totalArea = totalArea;
		this.plantArea = plantArea;
		this.orgCode = orgCode;
		this.openingTime = openingTime;
		this.registerType = registerType;
		this.economicCode = economicCode;
		this.industry = industry;
		this.industryCode = industryCode;
		this.stake = stake;
		this.licenseNum = licenseNum;
		this.workers = workers;
		this.isListed = isListed;
		this.stockCode = stockCode;
		this.isQualification = isQualification;
		this.isHightechnology = isHightechnology;
		this.isExportUnit = isExportUnit;
		this.exportProductClassify = exportProductClassify;
		this.isEntrepreneurship = isEntrepreneurship;
		this.isAgrotechny = isAgrotechny;
		this.isSurvey = isSurvey;
		this.isAgritourism = isAgritourism;
		this.agritourismType = agritourismType;
		this.isTownship = isTownship;
		this.isDevelopmentzone = isDevelopmentzone;
		this.isMiit = isMiit;
		this.miitAccount = miitAccount;
		this.certificateNum = certificateNum;
		this.taxpayerState = taxpayerState;
		this.taxpayerStateName = taxpayerStateName;
		this.issuingAgency = issuingAgency;
		this.businessScope = businessScope;
		this.state = state;
		this.publishNum = publishNum;
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

	public String getRegisterCapital() {
		return registerCapital;
	}

	public void setRegisterCapital(String registerCapital) {
		this.registerCapital = registerCapital;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnterUrl() {
		return enterUrl;
	}

	public void setEnterUrl(String enterUrl) {
		this.enterUrl = enterUrl;
	}

	public Double getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(Double totalArea) {
		this.totalArea = totalArea;
	}

	public Double getPlantArea() {
		return plantArea;
	}

	public void setPlantArea(Double plantArea) {
		this.plantArea = plantArea;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Date getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getEconomicCode() {
		return economicCode;
	}

	public void setEconomicCode(String economicCode) {
		this.economicCode = economicCode;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getStake() {
		return stake;
	}

	public void setStake(String stake) {
		this.stake = stake;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getWorkers() {
		return workers;
	}

	public void setWorkers(String workers) {
		this.workers = workers;
	}

	public String getIsListed() {
		return isListed;
	}

	public void setIsListed(String isListed) {
		this.isListed = isListed;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getIsQualification() {
		return isQualification;
	}

	public void setIsQualification(String isQualification) {
		this.isQualification = isQualification;
	}

	public String getIsHightechnology() {
		return isHightechnology;
	}

	public void setIsHightechnology(String isHightechnology) {
		this.isHightechnology = isHightechnology;
	}

	public String getIsExportUnit() {
		return isExportUnit;
	}

	public void setIsExportUnit(String isExportUnit) {
		this.isExportUnit = isExportUnit;
	}

	public String getExportProductClassify() {
		return exportProductClassify;
	}

	public void setExportProductClassify(String exportProductClassify) {
		this.exportProductClassify = exportProductClassify;
	}

	public String getIsEntrepreneurship() {
		return isEntrepreneurship;
	}

	public void setIsEntrepreneurship(String isEntrepreneurship) {
		this.isEntrepreneurship = isEntrepreneurship;
	}

	public String getIsAgrotechny() {
		return isAgrotechny;
	}

	public void setIsAgrotechny(String isAgrotechny) {
		this.isAgrotechny = isAgrotechny;
	}

	public String getIsSurvey() {
		return isSurvey;
	}

	public void setIsSurvey(String isSurvey) {
		this.isSurvey = isSurvey;
	}

	public String getIsAgritourism() {
		return isAgritourism;
	}

	public void setIsAgritourism(String isAgritourism) {
		this.isAgritourism = isAgritourism;
	}

	public String getAgritourismType() {
		return agritourismType;
	}

	public void setAgritourismType(String agritourismType) {
		this.agritourismType = agritourismType;
	}

	public String getIsTownship() {
		return isTownship;
	}

	public void setIsTownship(String isTownship) {
		this.isTownship = isTownship;
	}

	public String getIsDevelopmentzone() {
		return isDevelopmentzone;
	}

	public void setIsDevelopmentzone(String isDevelopmentzone) {
		this.isDevelopmentzone = isDevelopmentzone;
	}

	public String getIsMiit() {
		return isMiit;
	}

	public void setIsMiit(String isMiit) {
		this.isMiit = isMiit;
	}

	public String getMiitAccount() {
		return miitAccount;
	}

	public void setMiitAccount(String miitAccount) {
		this.miitAccount = miitAccount;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getTaxpayerState() {
		return taxpayerState;
	}

	public void setTaxpayerState(String taxpayerState) {
		this.taxpayerState = taxpayerState;
	}

	public String getTaxpayerStateName() {
		return taxpayerStateName;
	}

	public void setTaxpayerStateName(String taxpayerStateName) {
		this.taxpayerStateName = taxpayerStateName;
	}

	public String getIssuingAgency() {
		return issuingAgency;
	}

	public void setIssuingAgency(String issuingAgency) {
		this.issuingAgency = issuingAgency;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPublishNum() {
		return publishNum;
	}

	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
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
