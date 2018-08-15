package cn.com.taiji.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import cn.com.taiji.entity.Application;
import cn.com.taiji.entity.User;
import cn.com.taiji.entity.UserDto;
import cn.com.taiji.repository.ApplicationRepository;
import cn.com.taiji.repository.UserRepository;
import cn.com.taiji.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
    	User u=userRepository.saveAndFlush(user);
    	return u;
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

  

	@Override
	public int addUser(String userName, String password, String loginName, String telephone, String email) {
		return userRepository.addUser(userName, password, loginName, telephone, email);
	}
	
	public User findByLoginName(String loginName) {
		User user = this.userRepository.findByLoginName(loginName);
		return user;
	}
	/**
	 * 
	 */
	public UserDto appUser(String appIds, String userId) {
		List<Application> applications = new ArrayList<Application>();
		String[] aryApp;
		aryApp = appIds.split(",");
		for (int i = 0; i < aryApp.length; i++) {
			if (appIds != null && !"".equals(appIds)) {
				Application application = this.applicationRepository.findOne(aryApp[i]);
				applications.add(application);
			}
		}

		User user = this.userRepository.findOne(userId);
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(user, userDto);
		if (applications != null && applications.size() > 0) {
			userDto.setApplicationsList(applications);
		}

		return userDto;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * 调用注册、编辑用户信息接口
	 * 
	 * @param restTemplate
	 * @param user
	 * @return
	 */
	public String postForObject(String uploadPath, RestTemplate restTemplate, UserDto user) {
		String s = null;

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());

		String jsonObj = JSONObject.toJSONString(user);

		HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj, headers);

		s = restTemplate.postForObject(uploadPath, formEntity, String.class);

		return s;

	}
	/**
	 * 调用同步用户接口(restTemplate 多个参数)
	 * 
	 * @param uploadPath
	 * @param restTemplate
	 * @param appIds
	 * @param codeCodes
	 * @param userId
	 * @return
	 */
	public String synchronousForObject(String uploadPath, RestTemplate restTemplate, String appIds, String codeCodes,
			String userId) {

		String s = null;

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		// headers.setContentType(type);
		// headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		headers.add("Content-Type", "application/x-www-form-urlencoded");

		map.add("sysCodes", appIds);
		map.add("userIds", userId);
		map.add("properties", codeCodes);

		// String jsonObj = JSONObject.toJSONString(map);

		// HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj, headers);
		HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<>(map, headers);

		s = restTemplate.postForObject(uploadPath, formEntity, String.class);

		return s;

	}
}


