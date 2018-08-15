package cn.com.taiji.web;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import cn.com.taiji.entity.AppUserRel;
import cn.com.taiji.entity.Application;
import cn.com.taiji.entity.User;
import cn.com.taiji.entity.UserDto;
import cn.com.taiji.service.AppUserRelService;
import cn.com.taiji.service.ApplicationService;
import cn.com.taiji.service.UserService;
import cn.com.taiji.util.Json;


@Controller
public class UserController {

	@Resource
	UserService userService;
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	AppUserRelService appUserRelService;

	@Autowired
	RestTemplate restTemplate;

	@Value(value = "${userpush.url}")
	private String url;
	
	@Value(value = "${user.redirect.url}")
	private String redirectUrlId;
	
	@Value(value = "${authorizePath}")
	private String authorizePath;// 授权调用接口地址
	
	@Value(value = "${synchronousPath}")
	private String synchronousPath;// 同步调用接口地址

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ctx", "http://" + request.getRemoteHost() + ":" + request.getLocalPort() + "/");
		return true;
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
	}

	
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = userService.getUserList();
		model.addAttribute("users", users);
		return "user/list";
	}
	/**
	 * 注册页面
	 * @Description: TODO
	 * @param @param model
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author lyp
	 * @date 2018年5月7日
	 */
	@RequestMapping("/toAdd")
	public String toAdd(@RequestParam (required=false) String clientId,@RequestParam (required=false) String weixinId,Model model) {
		model.addAttribute("clientId", clientId);
		model.addAttribute("weixinId", weixinId);
		model.addAttribute("redirectUrlId",redirectUrlId);
		return "user/userAdd";
	}
	

	/*
	 * @RequestMapping("/add") public String add(User user) {
	 * userService.save(user); return "redirect:/list"; }
	 */
	/**
	 * 注册保存方法
	 * @Description: TODO
	 * @param @param user
	 * @param @param model
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author lyp
	 * @date 2018年3月28日
	 */
	@RequestMapping("/userAdd")
	@ResponseBody
	public Json add(User user, Model model) {
		Json json=new Json();
		// 注册同步到server中
		Date date = new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);// 将时间格式转换成符合Timestamp要求的格式.
		Timestamp newdate = Timestamp.valueOf(nowTime);// 把时间转换
		user.setCreatedDate(newdate);
		user.setModifiedDate(newdate);
		user.setDelFlag(1);
		user.setFlag(1);
		user.setState("1");
		user.setUserType("1");//业务用户
		user.setPuname("4");//个人用户
		user.setOperateId(11);//新增操作
		user.setDocumentType("t01");//默认为身份证类型
		
		try {
			User u = userService.save(user);
			//同步用户
			ResponseEntity<String> s = restTemplate.postForEntity(url, u, String.class); 
			log.info("------第一步调用同步用户接口返回值--------" + s);
			//新增用户+授权调用接口
			String userId=u.getId();
			//得到isneedrole=0的
			List<Application> appList=applicationService.findByIsNeedRole("0"); 
			if(!appList.isEmpty()) {
				List<String> appIdList=new ArrayList<String>();
				for(Application app:appList) {
					AppUserRel	appUser = new AppUserRel();
					appUser.setUserId(userId);// 用户id
					String appId=app.getId();
					appUser.setAppId(appId);// 资源id
					appIdList.add(appId);
					appUserRelService.saveAppUserRel(appUser);
				}	
				
				String appIds = "";
				if (appIdList != null) {
					appIds = StringUtils.collectionToDelimitedString(appIdList, ",");
					
				}
				log.info("------本地保存用户资源成功资源ids------->" + appIds);
				/**
				 * ----- 调用用户授权 第三方应用接口 -------
				 */
				//{userid:xxx,name:aaa,appplications[{1},{2},{3}]}
				UserDto tempUser = this.userService.appUser(appIds, userId);
				String ss = this.userService.postForObject(authorizePath, restTemplate, tempUser);
				log.info("------第二步调用用户授权资源接口返回值--------" + ss);
				
				//调用第三方 用户同步
				 String cocoCodes = "id,loginName,userName,password,phoneNum";
				 String sss =
				 this.userService.synchronousForObject(synchronousPath,restTemplate, appIds,
				 cocoCodes, userId);
				 log.info("------第三步调用同步用户字段返回值------" + sss);
			}
			
			
			
			json.setSuccess(true);
			json.setMsg("注册成功!");
			
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("注册失败!");
		}
		return json;
//		model.addAttribute("success", "注册成功!!!!!");
//		return "user/success";
		// return "redirect:/list";
	}
	
	

	/**
	 * 跳转到修改用户页面
	 * 
	 * @Description: TODO
	 * @param model
	 * @param id
	 * @return String
	 * @author lyp
	 * @date 2018年3月1日
	 */
	@RequestMapping("/toEdit")
	public String toEdit(Model model, String id) {
		User user = userService.findUserById(id);
		if (user != null) {
			model.addAttribute("user", user);
		} else {
			user = new User();
			model.addAttribute("user", user);
		}

		return "user/userEdit";
	}

	@RequestMapping("/toPwd")
	public String toPwd(Model model, String id) throws Exception {

		// User user = userService.findUserById(id);
		model.addAttribute("userId", id);
		return "user/modifypwd";
	}

	@RequestMapping(value = "/checkOldPwd", method = RequestMethod.POST)
	@ResponseBody
	public Json checkOldPwd(String id, String oldPass) throws Exception {

		Json json = new Json();
		User user = userService.findUserById(id);
		if (oldPass.equals(user.getPassword())) {
			json.setMsg("原始密码输入正确!");
			json.setSuccess(true);
		} else {
			json.setMsg("原始密码输入错误，请重新输入");
			json.setSuccess(false);
		}
		return json;
	}

	@RequestMapping(value = "/doPwd", method = RequestMethod.POST)
	@ResponseBody
	public Json doPwd(Model model, String id, String newpass) throws Exception {
		Json json = new Json();
		User user = userService.findUserById(id);
		user.setPassword(newpass);
		user.setOperateId(12);//修改操作
		//调用同步接口
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, user, String.class);

		String v = responseEntity.getBody();
		System.out.println("---------------返回同步结果start--------------------");
		System.out.println(v);
		System.out.println("---------------返回同步结果end--------------------");
		userService.save(user);
		json.setSuccess(true);
		json.setMsg("修改成功!!!");
		return json;
	}

	/**
	 * 修改页面保存方法
	 * @Description: TODO
	 * @param @param model
	 * @param @param user
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author lyp
	 * @date 2018年3月28日
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Model model, User user) {
		Json json=new Json();
		if (user != null) {
			model.addAttribute("user", user);
		} else {
			user = new User();
		}
		Date date = new Date();
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);// 将时间格式转换成符合Timestamp要求的格式.
		Timestamp newdate = Timestamp.valueOf(nowTime);// 把时间转换
		user.setDelFlag(1);
		user.setFlag(1);
		user.setState("1");
		user.setModifiedDate(newdate);
		user.setUserType("1");
		user.setPuname("4");
		user.setOperateId(12);//修改操作
		user.setDocumentType("t01");
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, user, String.class);

			String v = responseEntity.getBody();
			System.out.println("---------------返回同步结果start------------------");
			System.out.println(v);
			System.out.println("---------------返回同步结果end--------------------");
			userService.edit(user);
			json.setSuccess(true);
			json.setMsg("修改成功!");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("修改失败!");
			e.printStackTrace();
		}
		
		return json;
//		model.addAttribute("success", "修改成功!!!!!");
//		return "user/success";
		// return "redirect:/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		userService.delete(id);
		return "redirect:/list";
	}
	/**校验用户名是否可用
	 * @author lyp
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "/sys/newUserCheck", method = { RequestMethod.POST })
	@ResponseBody
	public JSONObject checkUniqueLoginName(@RequestParam("loginName") String loginName) {
		
		JSONObject jsobjcet = new JSONObject();
		Boolean ret = false;// 默认为验证不通过
		try {
			loginName = URLDecoder.decode(loginName,"UTF-8");
			loginName=loginName.trim();
			User user=userService.findByLoginName(loginName);
			if(user!=null){
				ret=false;
			}else {
				ret=true;
			}
			jsobjcet.put("valid", ret);
			
		} catch (Exception e) {
			
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return jsobjcet;
	}
}
