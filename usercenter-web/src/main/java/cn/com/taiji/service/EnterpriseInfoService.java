package cn.com.taiji.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.entity.EnterpriseInfo;
import cn.com.taiji.entity.EnterpriseInfoNewDto;
import cn.com.taiji.entity.EnterpriseInfoUser;
import cn.com.taiji.repository.EnterpriseInfoRepository;
import cn.com.taiji.repository.EnterpriseInfoUserRepository;

/**
 * 
 * @ClassName: EnterpriseInfoService
 * @Description: TODO(企业信息service)
 * @author lyp
 * @date 2018年1月22日 下午3:30:48
 * @version V1.0
 */
@Service
public class EnterpriseInfoService {
	public static final String CACHE_KEY = "'demoInfo'";
	/**
	 * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
	 */
	public static final String DEMO_CACHE_NAME = "demo";

	@Autowired
	private EnterpriseInfoRepository enterpriseInfoRepository;

	@Autowired
	private EnterpriseInfoUserRepository enterpriseInfoUserRepository;

	public List<EnterpriseInfoUser> findByUserId(String userId) {
		return enterpriseInfoUserRepository.findByUserId(userId);
	}

	/**
	 * 
	 * @Description: TODO
	 * @param id
	 * @return Object
	 * @author lyp
	 * @date 2018年1月26日
	 */
	public EnterpriseInfo findEnterpriseInfoById(String id) {
		return enterpriseInfoRepository.findOne(id);
	}

	/**
	 * 
	 * @Description: 保存单个企业信息对象
	 * @param enpDto
	 * @return EnterpriseInfo
	 * @author lyp
	 * @date 2018年1月24日
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseInfo saveEnpInfo(EnterpriseInfoNewDto enpDto) {
		EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
		BeanUtils.copyProperties(enpDto, enterpriseInfo);
		return saveWith(enterpriseInfo);
	}

	private EnterpriseInfo saveWith(EnterpriseInfo enterpriseInfo) {

		EnterpriseInfo enp = this.enterpriseInfoRepository.save(enterpriseInfo);
		return enp;

	}

	public EnterpriseInfo findEnterpriseInfoByName(String enterpriseName) {
		return enterpriseInfoRepository.findByEnterpriseName(enterpriseName);
	}

	public EnterpriseInfoUser saveEnterpriseInfoUser(EnterpriseInfoUser enterpriseInfoUser) {
		EnterpriseInfoUser euser = enterpriseInfoUserRepository.save(enterpriseInfoUser);
		return euser;
	}

}