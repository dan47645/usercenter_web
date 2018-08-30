package cn.com.taiji.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.taiji.entity.CodeDto;
import cn.com.taiji.entity.EnterpriseAndServerOrgInfoDto;
import cn.com.taiji.entity.EnterpriseInfo;
import cn.com.taiji.entity.EnterpriseInfoNewDto;
import cn.com.taiji.entity.EnterpriseInfoUser;
import cn.com.taiji.entity.EnterpriseInfoUserPK;
import cn.com.taiji.entity.User;
import cn.com.taiji.service.CodeService;
import cn.com.taiji.service.EnterpriseInfoService;
import cn.com.taiji.service.ServeOrgService;
import cn.com.taiji.service.UserService;
import cn.com.taiji.util.AjaxResultJson;
import cn.com.taiji.util.DateUtil;
/**
 * 
 * @ClassName: EnterpriseInfoController
 * @Description: TODO(企业信息Controller)
 * @author lyp
 * @date 2018年1月22日 下午3:19:54
 * @version V1.0
 */
@Controller
public class EnterpriseInfoController {

	private static final Logger logger = LoggerFactory.getLogger(EnterpriseInfoController.class);

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private EnterpriseInfoService enterpriseInfoService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private ServeOrgService serveOrgService;
	@Autowired
	private UserService userService;
	
	
	
	@Value(value = "${sysImgPath}")
	private String sysImgPath;

	/**
	 * 完善企业信息
	 * 
	 * @Description: TODO
	 * @param model
	 * @param id
	 * @author lyp
	 * @date 2018年2月26日
	 */
	@RequestMapping(value = "/enp/enterprise-info-edit",method= {RequestMethod.GET})
	public String EnterpriseInfoEdit(Model model, @RequestParam("id") String id) {
		System.out.println("=====" + id);
		//通过userid去企业和用户关系表中查询企业信息
		//
		EnterpriseAndServerOrgInfoDto enterpriseAndServerOrgInfoDto = new EnterpriseAndServerOrgInfoDto();
		EnterpriseInfo eInfo=new EnterpriseInfo();
		List<EnterpriseInfoUser> euList=enterpriseInfoService.findByUserId(id);
		if(euList!=null&&!euList.isEmpty()) {
			//eInfo=new EnterpriseInfo();
			EnterpriseInfoUser enterpriseInfoUser=euList.get(0);
			eInfo = (EnterpriseInfo) enterpriseInfoService.findEnterpriseInfoById(enterpriseInfoUser.getId().getEnerpriseInfoId());
		}else {
			eInfo=new EnterpriseInfo();
		}
		enterpriseAndServerOrgInfoDto.setEnterpriseId(eInfo.getId());
		enterpriseAndServerOrgInfoDto.setEnterpriseName(eInfo.getEnterpriseName());
		// 社会统一信用代码
		enterpriseAndServerOrgInfoDto.setCreditCode(eInfo.getCreditCode());
		// 注册日期
		enterpriseAndServerOrgInfoDto.setRegisterTime(DateUtil.dateToString(eInfo.getRegisterTime()));
		// 法定代表人
		enterpriseAndServerOrgInfoDto.setLegalPerson(eInfo.getLegalPerson());
		// 注册资金（万元）
		enterpriseAndServerOrgInfoDto.setRegisterCapital(eInfo.getRegisterCapital());
		// 单位性质
		enterpriseAndServerOrgInfoDto.setCompanyType(eInfo.getCompanyType());
		// 服务类别category（一级）
		enterpriseAndServerOrgInfoDto.setFirstCategory(eInfo.getFirstCategory());
		// 服务类别（二级）
		enterpriseAndServerOrgInfoDto.setSecondCategory(eInfo.getSecondCategory());
		// 联系人
		enterpriseAndServerOrgInfoDto.setLinkMan(eInfo.getLinkMan());
		// 手机号码
		enterpriseAndServerOrgInfoDto.setCellPhone(eInfo.getCellPhone());
		// 办公电话
		enterpriseAndServerOrgInfoDto.setLinkPhone(eInfo.getLinkPhone());
		// 电子邮箱
		enterpriseAndServerOrgInfoDto.setEmail(eInfo.getEmail());
		// 传真
		enterpriseAndServerOrgInfoDto.setFax(eInfo.getFax());
		// 通讯地址
		enterpriseAndServerOrgInfoDto.setPostalAddress(eInfo.getPostalAddress());
		// 企业网址
		enterpriseAndServerOrgInfoDto.setWebSite(eInfo.getWebSite());
		// 是否有在线服务系统
		enterpriseAndServerOrgInfoDto.setIsServerSys(eInfo.getIsServerSys());
		//
		enterpriseAndServerOrgInfoDto.setIsServerSysInput(eInfo.getIsServerSysInput());
		// 是否有固定经营场所
		enterpriseAndServerOrgInfoDto.setIsBusinessPlace(eInfo.getIsBusinessPlace());
		// 服务场地总面积（平方米）
		enterpriseAndServerOrgInfoDto.setServerPlaceArea(eInfo.getServerPlaceArea());
		// 从业人员总数（人）
		enterpriseAndServerOrgInfoDto.setEmployees(eInfo.getEmployees());
		// 营业执照
		enterpriseAndServerOrgInfoDto.setBusinessLicence(eInfo.getBusinessLicence());
		// 办公场所的产权证明或租用合同：
		enterpriseAndServerOrgInfoDto.setContractAttachment(eInfo.getContractAttachment());
		// 其他附件
		enterpriseAndServerOrgInfoDto.setOtherAttachment(eInfo.getOtherAttachment());
		//版本号
		String publishNum = enterpriseAndServerOrgInfoDto.getPublishNum();
		if (!"".equals(publishNum) && publishNum != null) {
			enterpriseAndServerOrgInfoDto.setPublishNum(publishNum);
		} else {
			enterpriseAndServerOrgInfoDto.setPublishNum("V110" + cn.com.taiji.util.OrgCodeUtil.createID());
		}
		
		providerData(model);
		//企业基本信息
		model.addAttribute("enterpriseAndServerDto", enterpriseAndServerOrgInfoDto);
		//用户id
		model.addAttribute("userId", id);
		return "user/enterprise-info-add";
	}

	/**
	 * 
	 * @Description: 企业信息保存
	 * @param model
	 * @param models
	 * @return AjaxResultJson
	 * @author lyp
	 * @throws ParseException
	 * @date 2018年1月25日
	 */
	@RequestMapping(value = "/enp/enterprise-info-save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResultJson enterpriseInfoAdd(Model model, @RequestParam("models") String models,@RequestParam("userId") String userId) throws ParseException {
		EnterpriseAndServerOrgInfoDto enterpriseAndServerOrgInfoDto = new EnterpriseAndServerOrgInfoDto();
		EnterpriseInfoNewDto enterpriseInfoDto = new EnterpriseInfoNewDto();
		AjaxResultJson result = new AjaxResultJson();
		result.setSuccess(true);
		if (models != null && models.length() > 0) {
			try {
				enterpriseAndServerOrgInfoDto = objectMapper.readValue(models, EnterpriseAndServerOrgInfoDto.class);
				enterpriseInfoDto.setId(enterpriseAndServerOrgInfoDto.getEnterpriseId());
				enterpriseInfoDto.setEnterpriseName(enterpriseAndServerOrgInfoDto.getEnterpriseName());
				// 社会统一信用代码
				enterpriseInfoDto.setCreditCode(enterpriseAndServerOrgInfoDto.getCreditCode());
				// 注册日期
				enterpriseInfoDto
						.setRegisterTime(DateUtil.stringToDate(enterpriseAndServerOrgInfoDto.getRegisterTime()));
				// 法定代表人
				enterpriseInfoDto.setLegalPerson(enterpriseAndServerOrgInfoDto.getLegalPerson());
				// 注册资金（万元）
				enterpriseInfoDto.setRegisterCapital(enterpriseAndServerOrgInfoDto.getRegisterCapital());
				// 单位性质
				enterpriseInfoDto.setCompanyType(enterpriseAndServerOrgInfoDto.getCompanyType());
				enterpriseInfoDto.setCompanyTypeName(enterpriseAndServerOrgInfoDto.getCompanyTypeName());
				// 服务类别category（一级）
				enterpriseInfoDto.setFirstCategory(enterpriseAndServerOrgInfoDto.getFirstCategory());
				// 服务类别（二级）
				enterpriseInfoDto.setSecondCategory(enterpriseAndServerOrgInfoDto.getSecondCategory());
				// 联系人
				enterpriseInfoDto.setLinkMan(enterpriseAndServerOrgInfoDto.getLinkMan());
				// 手机号码
				enterpriseInfoDto.setCellPhone(enterpriseAndServerOrgInfoDto.getCellPhone());
				// 办公电话
				enterpriseInfoDto.setLinkPhone(enterpriseAndServerOrgInfoDto.getLinkPhone());
				// 电子邮箱
				enterpriseInfoDto.setEmail(enterpriseAndServerOrgInfoDto.getEmail());
				// 传真
				enterpriseInfoDto.setFax(enterpriseAndServerOrgInfoDto.getFax());
				// 通讯地址
				enterpriseInfoDto.setPostalAddress(enterpriseAndServerOrgInfoDto.getPostalAddress());
				// 企业网址
				enterpriseInfoDto.setWebSite(enterpriseAndServerOrgInfoDto.getWebSite());
				// 是否有在线服务系统
				enterpriseInfoDto.setIsServerSys(enterpriseAndServerOrgInfoDto.getIsServerSys());
				//
				enterpriseInfoDto.setIsServerSysInput(enterpriseAndServerOrgInfoDto.getIsServerSysInput());
				// 是否有固定经营场所
				enterpriseInfoDto.setIsBusinessPlace(enterpriseAndServerOrgInfoDto.getIsBusinessPlace());
				// 服务场地总面积（平方米）
				enterpriseInfoDto.setServerPlaceArea(enterpriseAndServerOrgInfoDto.getServerPlaceArea());
				// 从业人员总数（人）
				enterpriseInfoDto.setEmployees(enterpriseAndServerOrgInfoDto.getEmployees());
				// 营业执照
				enterpriseInfoDto.setBusinessLicence(enterpriseAndServerOrgInfoDto.getBusinessLicence());
				// 办公场所的产权证明或租用合同：
				enterpriseInfoDto.setContractAttachment(enterpriseAndServerOrgInfoDto.getContractAttachment());
				// 其他附件
				enterpriseInfoDto.setOtherAttachment(enterpriseAndServerOrgInfoDto.getOtherAttachment());
				enterpriseInfoDto.setDelFlag(1);
				enterpriseInfoDto.setFlag(1);
				
				String state = enterpriseAndServerOrgInfoDto.getState();
				if (!"".equals(state) && state != null) {
					// 1.企业2.机构
					enterpriseInfoDto.setState(state);
				} else {
					enterpriseInfoDto.setState("1");
				}

				// 版本号默认V110+企业各汉字首字母+字间镞+随机数
				/*
				 * enterpriseInfoDto.setPublishNum( "V110" +
				 * PinYinUtils.capitalizeLetter(enterpriseAndServerOrgInfoDto.getEnterpriseName(
				 * )) + OrgCodeUtil.createID());
				 */
				String publishNum = enterpriseAndServerOrgInfoDto.getPublishNum();
				if (!"".equals(publishNum) && publishNum != null) {
					enterpriseInfoDto.setPublishNum(publishNum);
				} else {
					enterpriseInfoDto.setPublishNum("V110" + cn.com.taiji.util.OrgCodeUtil.createID());
				}
				// 设为当前
				enterpriseInfoDto.setIsCurrent("1");
				
				
			} catch (JsonParseException e) {
				logger.error("JsonParseException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg("JsonParseException解析错误");
				return result;
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("IOException{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg("IOException解析错误");
				return result;
			}
		}
		if (!model.containsAttribute("error")) {
			try {
				//保存企业信息
				EnterpriseInfo ent=enterpriseInfoService.saveEnpInfo(enterpriseInfoDto);
				//保存企业和用户中间表信息
				EnterpriseInfoUser eUser=new EnterpriseInfoUser();
				EnterpriseInfoUserPK userPK=new EnterpriseInfoUserPK();
				userPK.setUserId(userId);
				userPK.setEnerpriseInfoId(ent.getId());
				eUser.setId(userPK);
				enterpriseInfoService.saveEnterpriseInfoUser(eUser);
				//更新用户表信息-个人用户-转化为-企业用户
				User user=userService.findUserById(userId);
				user.setPuname("1");//企业用户
				
				userService.save(user);
				
				result.setMsg("保存成功");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Exception{}:", e.getMessage());
				model.addAttribute("error", e.getMessage());
				result.setSuccess(false);
				result.setMsg(e.getMessage());
				return result;
			}

		}
		return result;
	}

	
	

	/**
	 * 
	 * @Description:核查企业名称是否重复
	 * @param request
	 * @param response
	 * @param enterpriseName
	 * @param enterpriseId
	 * @throws IOException
	 * @return JSONObject
	 * @author lyp
	 * @date 2018年3月16日
	 */
	@RequestMapping(value = "/enp/checknewenterprise", method = { RequestMethod.POST })
	@ResponseBody
	public JSONObject checkNewEnterprise(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("enterpriseName") String enterpriseName, @RequestParam("enterpriseId") String enterpriseId)
			throws IOException {
		JSONObject jsobjcet = new JSONObject();
		EnterpriseInfo info = enterpriseInfoService.findEnterpriseInfoByName(enterpriseName);
		Boolean ret = false;// 默认为验证不通过
		if (enterpriseId != null) {// 修改
			if (info != null) {
				if (!enterpriseId.equals(info.getId())) {// 不同条
					ret = false;// 不通过
				} else {// 同一条数据
					ret = true; // 通过
				}
			} else {
				ret = true;
			}

		} else {// 新增
			if (!enterpriseName.equals(info.getEnterpriseName())) {
				ret = true;// 通过
			} else {
				ret = false;// 不通过
			}

		}

		try {
			// 这是输出为JSON串的一种方式，结果应为JSON串，属性名一定是valid，值为true或false

			jsobjcet.put("valid", ret);

			// response.getWriter().write(jsobjcet.toString());
			// System.out.println(jsobjcet.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsobjcet;
	}
	
	@RequestMapping(value = "/apk_upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadApkFile(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");

		Map<String, Object> json = new HashMap<String, Object>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		/** 页面控件的文件流* */
		MultipartFile multipartFile = null;
		Map map = multipartRequest.getFileMap();
		for (Iterator i = map.keySet().iterator(); i.hasNext();) {
			Object obj = i.next();
			multipartFile = (MultipartFile) map.get(obj);

		}
		// 获取文件名
		String fileName = multipartFile.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		// 文件上传后的路径
		// String filePath = "E://test//";
		String filePath = sysImgPath;
		// 解决中文问题，liunx下中文路径，图片显示问题
		fileName = UUID.randomUUID() + suffixName;
		File dest = new File(filePath + fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		json.put("message", "图片上传成功");
		json.put("status", true);
		json.put("filePath", fileName);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/enp/uploadFile", method = RequestMethod.POST)
	public String uploadFile(MultipartFile file) throws Exception {

		AjaxResultJson json = new AjaxResultJson();
		System.out.println("开始");
		String path = sysImgPath;
		// String fileName = file.getOriginalFilename();
		// 获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		// 文件上传后的路径
		// String filePath = "E://test//";

		// 解决中文问题，liunx下中文路径，图片显示问题
		fileName = UUID.randomUUID() + suffixName;
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// model.addAttribute("fileUrl", request.getContextPath() + "/upload/" +
		// fileName);
		json.setSuccess(true);
		json.setMsg(fileName);

		return fileName;
	}
	//文件下载相关代码
	@ResponseBody
	@RequestMapping(value = "/sys/download", method = RequestMethod.GET)
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
		
	    String fileName = request.getParameter("fileName").toString();// 设置文件名，根据业务需要替换成要下载的文件名
	    if (fileName != null) {
	        //设置文件路径
	        String realPath = sysImgPath;
	        File file = new File(realPath , fileName);
	        if (file.exists()) {
	            response.setContentType("application/force-download");// 设置强制下载不打开
	            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
	            byte[] buffer = new byte[1024];
	            FileInputStream fis = null;
	            BufferedInputStream bis = null;
	            try {
	                fis = new FileInputStream(file);
	                bis = new BufferedInputStream(fis);
	                OutputStream os = response.getOutputStream();
	                int i = bis.read(buffer);
	                while (i != -1) {
	                    os.write(buffer, 0, i);
	                    i = bis.read(buffer);
	                }
	                System.out.println("success");
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                if (bis != null) {
	                    try {
	                        bis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (fis != null) {
	                    try {
	                        fis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	    return null;
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