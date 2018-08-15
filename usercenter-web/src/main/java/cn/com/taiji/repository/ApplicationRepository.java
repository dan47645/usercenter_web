package cn.com.taiji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, String>,JpaSpecificationExecutor<Application>{
	
	/**
	 * 
	 * @param isNeedRole
	 * @return
	 */
	@Query("select a from Application a where a.isNeedRole =:isNeedRole")
	List<Application> findByIsNeedRole(@Param("isNeedRole") String isNeedRole);
	/**
	 * 
	 * @Description: 根据应用名查询应用
	 * @param name
	 * @return User  
	 * @throws
	 * @author 陈克成
	 * @date 2017年6月8日
	 */
	@Query("select a from Application a where a.name =:name")
	Application findByAppName(@Param("name") String name);
	
	//-------------20180114---------------------
	@Query("select a.name from Application a where a.id =:id")
	String findByAppId(@Param("id") String id);
	
	/**
	 * 根据id查找用户同步接口url
	 * @param id
	 * @return
	 */
	@Query("select synUserUrl from Application where id = ?1")
	String findUserUrlByAppId(String id);
	
	/**
	 * 根据id查找企业同步接口url
	 * @param id
	 * @return
	 */
	@Query("select synEnterpriseUrl from Application where id = ?1")
	String findEnterpriseUrlByAppId(String id);
	
	/**
	 * 根据id查找服务机构同步接口url
	 * @param id
	 * @return
	 */
	@Query("select synOrgUrl from Application where id = ?1")
	String findOrgUrlByAppId(String id);
	
	
	//-------------2018-02-24------------------
	@Query(value="select a.name,a.code,u.login_name from application a ,user_info u where a.name like %:name%", nativeQuery = true)
	List<Object[]> queryApplication(@Param("name") String qname);
	
	
}
