package cn.com.taiji.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.entity.AppUserRel;
import cn.com.taiji.entity.AppUserRelDto;
import cn.com.taiji.repository.AppUserRelRepository;

@Service
public class AppUserRelService {
	
		@Autowired
		private AppUserRelRepository investOrgRepository;
	
	
	    @Transactional(propagation = Propagation.REQUIRED)
		public void saveAppUserRel(AppUserRel appUserRel) {
			 this.investOrgRepository.save(appUserRel);
		}
	 
	    @Transactional(propagation = Propagation.REQUIRED)
		 public void deleteAppUserRel(AppUserRelDto appUserRelDto){
		 AppUserRel appUserRel = new AppUserRel();
		 BeanUtils.copyProperties(appUserRelDto, appUserRel);
		 this.investOrgRepository.delete(appUserRel);
		 }
	 
		 @Transactional(propagation = Propagation.REQUIRED)
		 public AppUserRel getDetailBy(String appId,String userId){
			 return this.investOrgRepository.getDetailBy(appId,userId);
		 }

		public List<AppUserRel> getByUserId(String userId) {
			// TODO Auto-generated method stub
			 return this.investOrgRepository.getByUserId(userId);
		}
		// 根据资源Id查询
		List<AppUserRel> getAppUsersByAppId(String appId){
			return this.investOrgRepository.getAppUsersByAppId(appId);
		}
		public void deleteByUserId (String userId){
			this.investOrgRepository.deleteByUserId(userId);
		}
		public void deleteByUserIdAndAppId (String userId,String appId){
			this.investOrgRepository.deleteByUserIdAndAppId(userId,appId);
		}
}
