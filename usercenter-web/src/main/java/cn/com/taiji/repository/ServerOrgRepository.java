package cn.com.taiji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.ServerOrg;

public interface ServerOrgRepository extends JpaRepository<ServerOrg, String>, JpaSpecificationExecutor<ServerOrg> {

	//ServerOrg findByPublishNum(String version);
	
	/**
	 * 标记为删除
	 * @param id
	 */
	@Modifying
	@Query("update ServerOrg d set d.flag=0 where d.id=:id")
	void updateFlag(@Param("id") String id);
	
	@Query("select d from ServerOrg d where d.deptObjectId=:deptId")
	ServerOrg findByDeptObjectId(@Param("deptId")String deptId);
	
	@Query("select d from ServerOrg d where d.flag=1 ")
	List<ServerOrg> findByServerOrg();
	
	@Query("select s from ServerOrg s where s.enterpriseId=:enterpriseId")
	ServerOrg getServerOrgByEnterpriseId(@Param("enterpriseId")String enterpriseId);
	
	@Query("select s from ServerOrg s where s.flag=1 and s.enterpriseName=:enterpriseName")
	List<ServerOrg> findByEnterpriseName(@Param("enterpriseName")String enterpriseName);

}
