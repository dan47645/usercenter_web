package cn.com.taiji.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.taiji.entity.CertificationDto;
import cn.com.taiji.entity.CodeDto;
import cn.com.taiji.entity.DeptObjectUser;
import cn.com.taiji.entity.DeptUserPK;
import cn.com.taiji.entity.EnterpriseAndServerOrgInfoDto;
import cn.com.taiji.entity.EnterpriseInfo;
import cn.com.taiji.entity.EnterpriseInfoNewDto;
import cn.com.taiji.entity.EnterpriseInfoUser;
import cn.com.taiji.entity.HonorCertificateDto;
import cn.com.taiji.entity.ServerOrg;
import cn.com.taiji.entity.User;
import cn.com.taiji.service.CodeService;
import cn.com.taiji.service.EnterpriseInfoService;
import cn.com.taiji.service.ServeOrgService;
import cn.com.taiji.service.UserService;
import cn.com.taiji.util.AjaxResultJson;
import cn.com.taiji.util.DateUtil;
import cn.com.taiji.util.PageUtil;




/**
 * 服务机构
 * @author lyp
 *
 */
@Controller
public class ServeOrgController {
	
	private static final Logger log = LoggerFactory.getLogger(ServeOrgController.class);
	@Autowired
	private ServeOrgService serveOrgService;
	@Autowired
	private EnterpriseInfoService enterpriseInfoService;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private CodeService codeService;
	@Autowired
	private UserService userService;
	
	/**
	 * 升级机构
	 * 
	 * @Description: TODO
	 * @param model
	 * @param id
	 * @return String
	 * @throws @author
	 *             lyp
	 * @date 2018年1月31日
	 */
	@RequestMapping(value = "/enp/enterprise-info-sjjg", method = { RequestMethod.GET })
	public String EnterpriseInfoSjjg(Model model, @RequestParam("id") String id) {
		//企业id
		String enterpriseId=null;
		EnterpriseAndServerOrgInfoDto enterpriseAndServerDto = new EnterpriseAndServerOrgInfoDto();
		EnterpriseInfo enterInfo =new EnterpriseInfo();
		ServerOrg tempServer=null;
		//根据userid 到机构用户查询
		List<EnterpriseInfoUser> euList=enterpriseInfoService.findByUserId(id);
		if(euList!=null&&!euList.isEmpty()) {
			//eInfo=new EnterpriseInfo();
			EnterpriseInfoUser enterpriseInfoUser=euList.get(0);
			enterInfo = (EnterpriseInfo) enterpriseInfoService.findEnterpriseInfoById(enterpriseInfoUser.getId().getEnerpriseInfoId());
			enterpriseId=enterInfo.getId();
			// 根据企业id去查对应的机构信息
			tempServer = serveOrgService.getServerOrgByEnterpriseId(enterpriseId);
		}else {
			enterInfo=new EnterpriseInfo();
		}
//		EnterpriseInfo enterInfo = enterpriseInfoService.findEnterpriseInfoById(id);
		enterpriseAndServerDto.setEnterpriseId(enterInfo.getId());
		enterpriseAndServerDto.setEnterpriseName(enterInfo.getEnterpriseName());
		// 社会统一信用代码
		enterpriseAndServerDto.setCreditCode(enterInfo.getCreditCode());
		// 注册日期
		enterpriseAndServerDto.setRegisterTime(DateUtil.dateToString(enterInfo.getRegisterTime()));
		// 法定代表人
		enterpriseAndServerDto.setLegalPerson(enterInfo.getLegalPerson());
		// 注册资金（万元）
		enterpriseAndServerDto.setRegisterCapital(enterInfo.getRegisterCapital());
		// 单位性质
		enterpriseAndServerDto.setCompanyType(enterInfo.getCompanyType());
		// 服务类别category（一级）
		enterpriseAndServerDto.setFirstCategory(enterInfo.getFirstCategory());
		// 服务类别（二级）
		enterpriseAndServerDto.setSecondCategory(enterInfo.getSecondCategory());
		// 联系人
		enterpriseAndServerDto.setLinkMan(enterInfo.getLinkMan());
		// 手机号码
		enterpriseAndServerDto.setCellPhone(enterInfo.getCellPhone());
		// 办公电话
		enterpriseAndServerDto.setLinkPhone(enterInfo.getLinkPhone());
		// 电子邮箱
		enterpriseAndServerDto.setEmail(enterInfo.getEmail());
		// 传真
		enterpriseAndServerDto.setFax(enterInfo.getFax());
		// 通讯地址
		enterpriseAndServerDto.setPostalAddress(enterInfo.getPostalAddress());
		// 企业网址
		enterpriseAndServerDto.setWebSite(enterInfo.getWebSite());
		// 是否有在线服务系统
		enterpriseAndServerDto.setIsServerSys(enterInfo.getIsServerSys());
		//
		enterpriseAndServerDto.setIsServerSysInput(enterInfo.getIsServerSysInput());
		// 是否有固定经营场所
		enterpriseAndServerDto.setIsBusinessPlace(enterInfo.getIsBusinessPlace());
		// 服务场地总面积（平方米）
		enterpriseAndServerDto.setServerPlaceArea(enterInfo.getServerPlaceArea());
		// 从业人员总数（人）
		enterpriseAndServerDto.setEmployees(enterInfo.getEmployees());
		// 营业执照
		enterpriseAndServerDto.setBusinessLicence(enterInfo.getBusinessLicence());
		// 办公场所的产权证明或租用合同：
		enterpriseAndServerDto.setContractAttachment(enterInfo.getContractAttachment());
		// 其他附件
		enterpriseAndServerDto.setOtherAttachment(enterInfo.getOtherAttachment());
		
		// 是否是当前(0,历史,1,当前)
		enterpriseAndServerDto.setIsCurrent(enterInfo.getIsCurrent());
		// 版本号
		enterpriseAndServerDto.setPublishNum(enterInfo.getPublishNum());
		
		if (tempServer != null) {
			enterpriseAndServerDto.setServerOrgId(tempServer.getId().toString());
			enterpriseAndServerDto.setTotalAsset(tempServer.getTotalAsset());
			enterpriseAndServerDto.setTotalNetAsset(tempServer.getTotalNetAsset());
			enterpriseAndServerDto.setOperatingIncome(tempServer.getOperatingIncome());
			enterpriseAndServerDto.setTotalProfit(tempServer.getTotalProfit());
			enterpriseAndServerDto.setEstablishment(tempServer.getEstablishment());
			enterpriseAndServerDto.setsAbstract(tempServer.getsAbstract());
			enterpriseAndServerDto.setsCompant(tempServer.getsCompant());
		} else {
			String serverOrgId = UUID.randomUUID().toString().replaceAll("-", "");
			enterpriseAndServerDto.setServerOrgId(serverOrgId);
		}

		model.addAttribute("enterpriseAndServerDto", enterpriseAndServerDto);
		model.addAttribute("userId",id);
		providerData(model);
		return "user/enterprise-info-sjjg";
	}
	
	/**
	 * 服务类别二级级联
	 * @param model
	 * @param codeCode
	 * @return
	 */
	@RequestMapping(value = "/sys/s-org-fcategory-check", method = { RequestMethod.POST })
	@ResponseBody
	public List sdeptCheckFcategory(Model model, @RequestParam(value = "codeCode", required = false) String codeCode ) {
		List<CodeDto> list = new ArrayList<CodeDto>();
		if(codeCode!=null&&!"".equals(codeCode)) {
			System.out.println("1111");
			list = this.serveOrgService.getCodeByCode(codeCode);
			System.out.println("2222");
		}
		
		return list;
	}
	
	@RequestMapping(value = "/sys/getCertificationList", method = RequestMethod.POST)
	@ResponseBody
	public String getCertificationList(CertificationDto dto) {
		int pageNumber = dto.getPageNumber(); // 当前
		int offset = dto.getOffset();// 起
		int limit = dto.getLimit();// 行数
		
		Pageable pageable = new PageRequest(dto.getOffset(), dto.getLimit(), null);
		Map<String, Object> result = new HashMap<String, Object>();
		
		PageUtil<CertificationDto> pageList = this.serveOrgService.findByPage(dto.getSid(), pageable);
		
		result.put("data", pageList.getList());
		result.put("total", pageList.getTotalCount());
		return JSON.toJSONString(result);
		
	}
	
	
	@RequestMapping(value = "/sys/getHonorCertificateList", method = RequestMethod.POST)
	@ResponseBody
	public String getHonorCertificateList(HonorCertificateDto dto) {
		int pageNumber = dto.getPageNumber(); // 当前
		int offset = dto.getOffset();// 起
		int limit = dto.getLimit();// 行数
		
		Pageable pageable = new PageRequest(dto.getOffset(), dto.getLimit(), null);
		Map<String, Object> result = new HashMap<String, Object>();
		
		PageUtil<HonorCertificateDto> pageList = this.serveOrgService.findByPageAll(dto.getSid(), pageable);
		
		result.put("data", pageList.getList());
		result.put("total", pageList.getTotalCount());
		return JSON.toJSONString(result);
		
	}
	
	/**
	 * 
	 * @Description: 升级机构信息保存
	 * @param model
	 * @param models
	 * @return AjaxResultJson
	 * @author lyp
	 * @date 2018年1月25日
	 */
	@RequestMapping(value = "/enp/enterprise-sjjg-save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResultJson enterpriseSjjgAdd(Model model, @RequestParam("models") String models,@RequestParam("userId") String userId) {
		EnterpriseAndServerOrgInfoDto enterpriseServerDto = null;
		AjaxResultJson result = new AjaxResultJson();
		result.setSuccess(true);
		if (models != null && models.length() > 0) {
			try {
				enterpriseServerDto = new EnterpriseAndServerOrgInfoDto();
				enterpriseServerDto = objectMapper.readValue(models, EnterpriseAndServerOrgInfoDto.class);
			} catch (JsonParseException e) {
				log.error("JsonParseException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg("JsonParseException解析错误");
				return result;
			} catch (IOException e) {
				e.printStackTrace();
				log.error("IOException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg("IOException解析错误");
				return result;
			}
		}
		if (!model.containsAttribute("error")) {
			try {
				//保存修改的企业信息
				EnterpriseInfoNewDto enterpriseInfoDto = new EnterpriseInfoNewDto();
				enterpriseInfoDto.setId(enterpriseServerDto.getEnterpriseId());
				enterpriseInfoDto.setEnterpriseName(enterpriseServerDto.getEnterpriseName());
				// 社会统一信用代码
				enterpriseInfoDto.setCreditCode(enterpriseServerDto.getCreditCode());
				// 注册日期
				enterpriseInfoDto.setRegisterTime(DateUtil.stringToDate(enterpriseServerDto.getRegisterTime()));
				// 法定代表人
				enterpriseInfoDto.setLegalPerson(enterpriseServerDto.getLegalPerson());
				// 注册资金（万元）
				enterpriseInfoDto.setRegisterCapital(enterpriseServerDto.getRegisterCapital());
				// 单位性质
				enterpriseInfoDto.setCompanyType(enterpriseServerDto.getCompanyType());
				// 服务类别category（一级）
				enterpriseInfoDto.setFirstCategory(enterpriseServerDto.getFirstCategory());
				// 服务类别（二级）
				enterpriseInfoDto.setSecondCategory(enterpriseServerDto.getSecondCategory());
				// 联系人
				enterpriseInfoDto.setLinkMan(enterpriseServerDto.getLinkMan());
				// 手机号码
				enterpriseInfoDto.setCellPhone(enterpriseServerDto.getCellPhone());
				// 办公电话
				enterpriseInfoDto.setLinkPhone(enterpriseServerDto.getLinkPhone());
				// 电子邮箱
				enterpriseInfoDto.setEmail(enterpriseServerDto.getEmail());
				// 传真
				enterpriseInfoDto.setFax(enterpriseServerDto.getFax());
				// 通讯地址
				enterpriseInfoDto.setPostalAddress(enterpriseServerDto.getPostalAddress());
				// 企业网址
				enterpriseInfoDto.setWebSite(enterpriseServerDto.getWebSite());
				// 是否有在线服务系统
				enterpriseInfoDto.setIsServerSys(enterpriseServerDto.getIsServerSys());
				//
				enterpriseInfoDto.setIsServerSysInput(enterpriseServerDto.getIsServerSysInput());
				// 是否有固定经营场所
				enterpriseInfoDto.setIsBusinessPlace(enterpriseServerDto.getIsBusinessPlace());
				// 服务场地总面积（平方米）
				enterpriseInfoDto.setServerPlaceArea(enterpriseServerDto.getServerPlaceArea());
				// 从业人员总数（人）
				enterpriseInfoDto.setEmployees(enterpriseServerDto.getEmployees());
				// 营业执照
				enterpriseInfoDto.setBusinessLicence(enterpriseServerDto.getBusinessLicence());
				// 办公场所的产权证明或租用合同：
				enterpriseInfoDto.setContractAttachment(enterpriseServerDto.getContractAttachment());
				// 其他附件
				enterpriseInfoDto.setOtherAttachment(enterpriseServerDto.getOtherAttachment());
				// 是否是当前(0,历史,1,当前)
				enterpriseInfoDto.setIsCurrent(enterpriseServerDto.getIsCurrent());
				// 版本号
				enterpriseInfoDto.setPublishNum(enterpriseServerDto.getPublishNum());
				//保存企业信息
				EnterpriseInfo eInfo= enterpriseInfoService.saveEnpInfo(enterpriseInfoDto);
				//保存机构
				 String serverOrgId=enterpriseServerDto.getServerOrgId();
				 ServerOrg so= new ServerOrg();
				 so=serveOrgService.findById(serverOrgId);
				 if(so==null) {
					 //根据
					 so=new ServerOrg();
				 }
				 	so.setEnterpriseId(eInfo.getId());
				 	so.setEnterpriseName(enterpriseServerDto.getEnterpriseName());
					so.setId(enterpriseServerDto.getServerOrgId());
					so.setTotalAsset(enterpriseServerDto.getTotalAsset());
					so.setTotalNetAsset(enterpriseServerDto.getTotalNetAsset());
					so.setOperatingIncome(enterpriseServerDto.getOperatingIncome());
					so.setTotalProfit(enterpriseServerDto.getTotalProfit());
					so.setEstablishment(enterpriseServerDto.getEstablishment());
					so.setsAbstract(enterpriseServerDto.getsAbstract());
					so.setsCompant(enterpriseServerDto.getsCompant());
					so.setPublishNum(enterpriseServerDto.getPublishNum());
					so.setAuditStatus("0");
				//保存服务机构	
				 ServerOrg sos=serveOrgService.save(so);
				 //保存服务机构和用户中间信息
				 DeptObjectUser deptObjectUser=new DeptObjectUser();
				 DeptUserPK deptObjectUserPK=new DeptUserPK();
				 deptObjectUserPK.setUserId(userId);
				 deptObjectUserPK.setDeptId(sos.getId());
				 deptObjectUser.setId(deptObjectUserPK);
				 serveOrgService.saveDeptObjectUser(deptObjectUser);
				 //更新用户表信息-企业用户-转化为服务机构用户
				 User user=userService.findUserById(userId);
				 user.setPuname("3");//服务机构用户
				 userService.save(user);
				 result.setMsg("保存成功");
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Exception{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg(e.getMessage());
				return result;
			}

		}
		return result;
	}
	/**
	 * 根据企业名称带入企业信息
	 * @param model
	 * @param enterpriseName
	 * @return
	 */
	@RequestMapping(value = "/sys/s-org-enterprise-check", method = { RequestMethod.POST })
	@ResponseBody
	public Map sdeptCheckEnterprise(Model model, @RequestParam(value = "enterpriseName", required = false) String enterpriseName ) {
		Map map = new HashMap();
		try {
			enterpriseName = URLDecoder.decode(enterpriseName,"UTF-8");
			map = this.serveOrgService.mapEnterpriseByEName(enterpriseName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/sys/certification-add" )
	public String certificationAdd(Model model, String sid){
		CertificationDto dto = new CertificationDto();
		model.addAttribute("dto",dto);
		model.addAttribute("sid",sid);
		return "user/certification-add";
	}
	
	@RequestMapping(value = "/sys/certification-save", method = { RequestMethod.POST })
	@ResponseBody
	public AjaxResultJson addCertification(Model model, @RequestParam(value = "models", required = false) String models) {
		AjaxResultJson result = new AjaxResultJson();
		List<CertificationDto> list = new ArrayList<>();
		if (models != null && models.length() > 0) {
			try {
				list = objectMapper.readValue(models, new TypeReference<List<CertificationDto>>() {
				});
			} catch (JsonParseException e) {
				log.error("JsonParseException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
			} catch (IOException e) {
				log.error("IOException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
			}

		}
		if (!model.containsAttribute("error")) {
			try {
				
				this.serveOrgService.addCertification(list);
				
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("Exception{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg(e.getMessage());
			}
			
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/sys/honor-certificate-add", method=RequestMethod.GET)
	public String honorAdd(Model model, String sid){
		HonorCertificateDto dto = new HonorCertificateDto();
		model.addAttribute("dto",dto);
		model.addAttribute("sid",sid);
		return "user/honor-certificate-add";
	}
	
	
	@RequestMapping(value = "/sys/honor-certificate-save", method = { RequestMethod.POST })
	@ResponseBody
	public AjaxResultJson honorCertificateSave(Model model, @RequestParam(value = "models", required = false) String models) {
		AjaxResultJson result = new AjaxResultJson();
		List<HonorCertificateDto> list = new ArrayList<>();
		if (models != null && models.length() > 0) {
			try {
				list = objectMapper.readValue(models, new TypeReference<List<HonorCertificateDto>>() {
				});
			} catch (JsonParseException e) {
				log.error("JsonParseException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
			} catch (IOException e) {
				log.error("IOException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
			}

		}
		if (!model.containsAttribute("error")) {
			try {
				
				this.serveOrgService.addHonorCertificate(list);
				
				result.setSuccess(true);
			} catch (Exception e) {
				log.error("Exception{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg(e.getMessage());
			}
			
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/sys/certification-edit", method=RequestMethod.GET)
	public String certificationEdit(Model model, String id){
		CertificationDto dto = this.serveOrgService.findByCertificationId(id);
		model.addAttribute("dto",dto);
		model.addAttribute("sid",dto.getSid());
		return "user/certification-add";
	}
	
	@RequestMapping(value="/sys/honor-certificate-edit", method=RequestMethod.GET)
	public String honorEdit(Model model, String id){
		HonorCertificateDto dto = this.serveOrgService.findByHonorId(id);
		model.addAttribute("dto",dto);
		model.addAttribute("sid",dto.getSid());
		return "user/honor-certificate-add";
	}
	
	
	@RequestMapping(value = "/sys/certification-delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResultJson removeCBath(String cid) throws Exception {
		AjaxResultJson jsonResult = new AjaxResultJson();

		try {
			serveOrgService.removeCBath(cid);
			jsonResult.setSuccess(true);
			jsonResult.setMsg("删除数据成功!");
		} catch (Exception e) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("删除数据失败!");
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	
	@RequestMapping(value = "/sys/honor-certificate-delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResultJson removeHBath(String hid) throws Exception {
		AjaxResultJson jsonResult = new AjaxResultJson();

		try {
			serveOrgService.removeHBath(hid);
			jsonResult.setSuccess(true);
			jsonResult.setMsg("删除数据成功!");
		} catch (Exception e) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("删除数据失败!");
			e.printStackTrace();
		}
		return jsonResult;
	}
	/**
	 * 下拉选项
	 */
	// TODO 此处模拟数据，以后是否要换成数据库查询数据？
	private void providerData(Model model) {

		List<CodeDto> unitNatures = this.codeService.getListAllCodes("unitNature");// 单位性质

		List<CodeDto> cognizances = this.codeService.getListAllCodes("cognizance");// 服务机构认定

		List<CodeDto> targets = this.codeService.getListAllCodes("target");// 服务对象

		List<CodeDto> modes = this.codeService.getListAllCodes("mode");// 服务方式

		List<CodeDto> categorys = this.codeService.getListAllCodes("category");// 服务类别

		model.addAttribute("unitNatures", unitNatures);
		model.addAttribute("cognizances", cognizances);
		model.addAttribute("targets", targets);
		model.addAttribute("modes", modes);
		model.addAttribute("categorys", categorys);

	}
	
}
