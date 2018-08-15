package cn.com.taiji.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 服务机构表
 * @author hz
 *
 */
@Entity
@Table(name = "serve_org")
public class ServerOrg extends Audited implements Serializable{


	@Column(name="s_first_category")
	private String sFirstCategory;//服务类别（一级）
	
	@Column(name="s_second_category")
	private String sSecondCategory;//服务类别（二级）
	
	@Column(name="s_unit_nature")
	private String sUnitNature;//单位性质
	
	@Column(name="s_cognizance")
	private String sCognizance;//服务机构认定
	
	@Column(name="s_time_limit")
	private String sTimeLimit;//时限
	
	@Column(name="s_target")
	private String sTarget;//服务对象
	
	@Column(name="s_mode")
	private String sMode;//服务方式
	
	@Column(name="s_charge")
	private String sCharge;//收费模式
	
	@Column(name="s_other_charge")
	private String sOtherCharge;//其他收费模式描述
	
	@Column(name="s_range")
	private String sRange;//服务范围
	
	@Column(name="s_compant",length=500)
	private String sCompant;//服务内容
	
	@Column(name="s_flow")
	private String sFlow;//服务流程
	
	@Column(name="s_assess")
	private String sAssess;//服务评价
	
	@Column(name="s_project")
	private String sProject;//服务项目
	
	@Column(name="s_aptitude")
	private String sAptitude;//服务资质
	
	@Column(name="s_person_quality")
	private String sPersonQuality;//人员素质
	
	@Column(name="s_main_performance")
	private String sMainPerformance;//主要业绩（成功案例）
	
	@Column(name="s_equipment")
	private String sEquipment;//主要服务设备及条件
	
	@Column(name="s_abstract",length=500)
	private String sAbstract;//服务简介------机构简介
	
	@Column(name="s_qualification")
	private String sQualification;//专业资质情况
	
	@Column(name="s_honor")
	private String sHonor;//荣誉资质
	
	@Column(name = "credit_code")
	private String creditCode;// 社会统一信用代码
	
	@Column(name = "enterprise_name")
	private String enterpriseName;//企业名称--->服务机构名称
	
	@Column(name = "enterprise_id")
	private String enterpriseId;//企业ID
	
	@Column(name="s_state")
	private String sState;// 状态
	
	private String publishNum; //版本号
	
	@Column(name="dept_object_id")
	private String deptObjectId;//机构公共类Id
	
	@Column(name="audit_status")
	private String auditStatus;//审核状态
	
	@Column(name="audit_opinion")
	private String auditOpinion;//审核意见
	
	
	@Column(name="total_asset")
	private String totalAsset;//资产总额
	
	@Column(name="total_net_asset")
	private String TotalNetAsset;//净资产总额
	
	@Column(name="operating_income")
	private String operatingIncome;//营业收入
	
	@Column(name="total_profit")
	private String totalProfit;//利润总额
	
	private String establishment;//服务中小企业户数
	
	// 单位性质
	@Column(name="company_type")
	private String companyType;
	// 服务类别category（一级）
	@Column(name="first_category")
	private String firstCategory;
	// 服务类别（二级）
	@Column(name="second_category")
	private String secondCategory;
	// 联系人
	@Column(name="linkman")
	private String linkMan;
	// 手机号码
	@Column(name="cellphone")
	private String cellPhone;
	//服务机构节点和新建的机构关联ID
	@Column(name="server_org_tid")
	private String serverOrgTid;
	
	//---------------------2018-03-06-----------------
	/*
	@OneToMany(mappedBy="serverOrg")
	private List<Certification> certifications = new LinkedList<Certification>(); //资质证书
	
	@OneToMany(mappedBy="serverDept")
	private List<HonorCertificate> honorCertificates = new LinkedList<HonorCertificate>();//荣誉证书
    */
	
	public String getsFirstCategory() {
		return sFirstCategory;
	}
	public void setsFirstCategory(String sFirstCategory) {
		this.sFirstCategory = sFirstCategory;
	}
	public String getsSecondCategory() {
		return sSecondCategory;
	}
	public void setsSecondCategory(String sSecondCategory) {
		this.sSecondCategory = sSecondCategory;
	}
	public String getsUnitNature() {
		return sUnitNature;
	}
	public void setsUnitNature(String sUnitNature) {
		this.sUnitNature = sUnitNature;
	}
	public String getsCognizance() {
		return sCognizance;
	}
	public void setsCognizance(String sCognizance) {
		this.sCognizance = sCognizance;
	}
	public String getsTimeLimit() {
		return sTimeLimit;
	}
	public void setsTimeLimit(String sTimeLimit) {
		this.sTimeLimit = sTimeLimit;
	}
	public String getsTarget() {
		return sTarget;
	}
	public void setsTarget(String sTarget) {
		this.sTarget = sTarget;
	}
	public String getsMode() {
		return sMode;
	}
	public void setsMode(String sMode) {
		this.sMode = sMode;
	}
	public String getsCharge() {
		return sCharge;
	}
	public void setsCharge(String sCharge) {
		this.sCharge = sCharge;
	}
	public String getsOtherCharge() {
		return sOtherCharge;
	}
	public void setsOtherCharge(String sOtherCharge) {
		this.sOtherCharge = sOtherCharge;
	}
	public String getsRange() {
		return sRange;
	}
	public void setsRange(String sRange) {
		this.sRange = sRange;
	}
	public String getsCompant() {
		return sCompant;
	}
	public void setsCompant(String sCompant) {
		this.sCompant = sCompant;
	}
	public String getsFlow() {
		return sFlow;
	}
	public void setsFlow(String sFlow) {
		this.sFlow = sFlow;
	}
	public String getsAssess() {
		return sAssess;
	}
	public void setsAssess(String sAssess) {
		this.sAssess = sAssess;
	}
	public String getsProject() {
		return sProject;
	}
	public void setsProject(String sProject) {
		this.sProject = sProject;
	}
	public String getsAptitude() {
		return sAptitude;
	}
	public void setsAptitude(String sAptitude) {
		this.sAptitude = sAptitude;
	}
	public String getsPersonQuality() {
		return sPersonQuality;
	}
	public void setsPersonQuality(String sPersonQuality) {
		this.sPersonQuality = sPersonQuality;
	}
	public String getsMainPerformance() {
		return sMainPerformance;
	}
	public void setsMainPerformance(String sMainPerformance) {
		this.sMainPerformance = sMainPerformance;
	}
	public String getsEquipment() {
		return sEquipment;
	}
	public void setsEquipment(String sEquipment) {
		this.sEquipment = sEquipment;
	}
	public String getsAbstract() {
		return sAbstract;
	}
	public void setsAbstract(String sAbstract) {
		this.sAbstract = sAbstract;
	}
	public String getsQualification() {
		return sQualification;
	}
	public void setsQualification(String sQualification) {
		this.sQualification = sQualification;
	}
	public String getsHonor() {
		return sHonor;
	}
	public void setsHonor(String sHonor) {
		this.sHonor = sHonor;
	}
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
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
	public String getsState() {
		return sState;
	}
	public void setsState(String sState) {
		this.sState = sState;
	}
	public String getDeptObjectId() {
		return deptObjectId;
	}
	public void setDeptObjectId(String deptObjectId) {
		this.deptObjectId = deptObjectId;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getAuditOpinion() {
		return auditOpinion;
	}
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
	
	
	public String getPublishNum() {
		return publishNum;
	}
	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}


	public String getTotalAsset() {
		return totalAsset;
	}
	public void setTotalAsset(String totalAsset) {
		this.totalAsset = totalAsset;
	}
	public String getTotalNetAsset() {
		return TotalNetAsset;
	}
	public void setTotalNetAsset(String totalNetAsset) {
		TotalNetAsset = totalNetAsset;
	}
	public String getOperatingIncome() {
		return operatingIncome;
	}
	public void setOperatingIncome(String operatingIncome) {
		this.operatingIncome = operatingIncome;
	}
	public String getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(String totalProfit) {
		this.totalProfit = totalProfit;
	}
	public String getEstablishment() {
		return establishment;
	}
	public void setEstablishment(String establishment) {
		this.establishment = establishment;
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
	
	
	
	
}
