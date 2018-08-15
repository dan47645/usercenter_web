package cn.com.taiji.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import cn.com.taiji.entity.User;
import cn.com.taiji.entity.UserDto;


public interface UserService {

    public List<User> getUserList();

    public User findUserById(String id);

    public User save(User user);

    public void edit(User user);

    public void delete(long id);
    int addUser(String userName,String password,String loginName,String telephone,String email);
    
	@Transactional(propagation = Propagation.SUPPORTS)
	public User findByLoginName(String loginName);
	/**
	 * 
	 */
	public UserDto appUser(String appIds, String userId) ;
	
	/**
	 * 调用注册、编辑用户信息接口
	 * 
	 * @param restTemplate
	 * @param user
	 * @return
	 */
	public String postForObject(String uploadPath, RestTemplate restTemplate, UserDto user) ;
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
			String userId) ;

}
