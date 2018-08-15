package cn.com.taiji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.EnterpriseInfo;

/**
 * 
 * @ClassName: EnterpriseInfoRepository
 * @Description: TODO(企业信息dao)
 * @author lyp
 * @date 2018年1月24日 下午2:18:17
 * @version V1.0
 */
public interface EnterpriseInfoRepository extends JpaRepository<EnterpriseInfo, String>,
		JpaSpecificationExecutor<EnterpriseInfo>, PagingAndSortingRepository<EnterpriseInfo, String> {

	List<EnterpriseInfo> findAll();

	/*
	 * /** 根据org_id 修改所有绑定的机构的用户状态bindstate为null
	 * 
	 * @param orgId
	 
	@Modifying
	@Query("update User u set u.bindState= null,u.reason =:reason where u.orgnization.id= :orgId")
	void moddifyAllBindUserforUnbind(@Param("orgId") String orgId, @Param("reason") String reason);

	@Modifying
	@Query("update User u set u.bindState= null,u.reason =:reason where u.investOrg.id= :investId")
	void moddifyAllBindUserforUnbindOfInvest(@Param("investId") String investId, @Param("reason") String reason);

	*//**
	 * 查询出userId集合
	 * 
	 * @param groupId
	 * @return
	 *//*
	@Query("select k.id.userId from EnterpriseInfoUser k where k.id.enerpriseInfoId =:groupId")
	List<String> findUserIdsByGroupId(@Param("groupId") String groupId);

	*//**
	 * 根据版本号查询企业信息
	 * 
	 * @param publishNum
	 * @return
	 *//*
	EnterpriseInfo findByPublishNum(String publishNum);*/

//	@Query("select e from EnterpriseInfo e where e.enterpriseName =:enterpriseName and e.flag=1")
//	EnterpriseInfo findByEnterpriseName(@Param("enterpriseName") String enterpriseName);

	/*@Query("select e from EnterpriseInfo e where e.enterpriseName =:enterpriseName and e.flag=1")
	List<EnterpriseInfo> findByEntName(@Param("enterpriseName") String enterpriseName);
	
	
*/
	@Query("select e from EnterpriseInfo e where e.enterpriseName =:enterpriseName and e.flag=1")
	EnterpriseInfo findByEnterpriseName(@Param("enterpriseName")String enterpriseName);
}
