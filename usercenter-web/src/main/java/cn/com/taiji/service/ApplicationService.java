package cn.com.taiji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import cn.com.taiji.entity.Application;
import cn.com.taiji.repository.ApplicationRepository;





@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	
	public List<Application> findByIsNeedRole(@Param("isNeedRole") String isNeedRole){
		return applicationRepository.findByIsNeedRole(isNeedRole);
	}
	
	
}
