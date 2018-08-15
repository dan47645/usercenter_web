package cn.com.taiji.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.AppUserRel;

public interface AppUserRelRepository extends JpaRepository<AppUserRel, String>,JpaSpecificationExecutor<AppUserRel>{
	
	/*@Modifying
	@Query("delete from AppUserRel a where a.appId=:appId and a.userId=:userId")
	void deleteAppUserRel(@Param("appId") String id,@Param("userId") String userId);*/
	
	/**
	 * 
	 * @Description: 根据y应用id和企业id查询详细信息
	 * @param appId
	 * @param userId
	 * @return AppUserRel  
	 * @throws
	 * @author 陈克成
	 * @date 2017年5月18日
	 */
	@Query("SELECT a FROM AppUserRel a WHERE a.appId = :appId and a.userId =:userId")
	AppUserRel getDetailBy(@Param("appId") String appId, @Param("userId") String userId);
	
	/**
	 * 
	 * @Description: 查询该用户已经关联的资源id
	 * @return AppUserRel  
	 * @throws
	 * @author 陈克成
	 * @date 2017年6月8日
	 */
	@Query("SELECT a.appId FROM AppUserRel a WHERE a.userId =:userId")
	List<String> getAppIdsByUserId(@Param("userId") String userId);
	/**
	 * xiewenda 根据用户id获得用户关联的所有资源
	 * @param userId
	 * @return
	 */
	@Query("SELECT a FROM AppUserRel a WHERE a.userId =:userId")
	List<AppUserRel> getByUserId(@Param("userId") String userId);
	
	
	@Modifying@Transactional
	@Query("delete AppUserRel k where k.userId =?1")
	void deleteByUserId(@Param("userId") String userId);
	
	@Modifying@Transactional
	@Query("delete AppUserRel k where k.userId =:userId and k.appId =:appId")
	void deleteByUserIdAndAppId(@Param("userId") String userId,@Param("appId") String appId);
	
	//---------------------2018-02-02---------------------
		//根据资源Id查询用户Id
		@Query("SELECT a.userId FROM AppUserRel a WHERE a.appId=:appId")
		List<String> getUserIdsByAppId(@Param("appId") String appId);
		
	// 根据资源Id查询
	@Query("SELECT a FROM AppUserRel a WHERE a.appId=:appId")
	List<AppUserRel> getAppUsersByAppId(@Param("appId") String appId);
		
		
		@Query("SELECT a FROM AppUserRel a WHERE a.appId = :appId and a.userId =:userId")
		List<AppUserRel> findAppUserByAppIdAndUserId(@Param("appId") String appId, @Param("userId") String userId);
	
}
