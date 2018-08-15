package cn.com.taiji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.EnterpriseInfoUser;

/**
 * 
* @ClassName: EnterpriseInfoUserRepository 
* @Description: TODO(企业分配用户)
* @author lyp
* @date 2018年1月30日 上午11:35:10 
* @version V1.0
 */
public interface EnterpriseInfoUserRepository extends JpaRepository<EnterpriseInfoUser, String>,JpaSpecificationExecutor<EnterpriseInfoUser>{

	@Query("select k from EnterpriseInfoUser k where k.id.enerpriseInfoId =:enerpriseInfoId and k.id.userId =:userId")
	List<EnterpriseInfoUser> findUserGroupByGroupIdAndUserId(@Param("enerpriseInfoId") String enerpriseInfoId,@Param("userId") String userId);
	
	@Query("select k from EnterpriseInfoUser k where k.id.userId =:userId")
	List<EnterpriseInfoUser> findByUserId(@Param("userId") String userId);
	
	@Query("select k from EnterpriseInfoUser k where k.id.enerpriseInfoId =:enerpriseInfoId")
	List<EnterpriseInfoUser> findByGroupId(@Param("enerpriseInfoId") String enerpriseInfoId);
	
	@Modifying
	@Query("delete EnterpriseInfoUser k where k.id.userId =?1")
	void deleteByUserId(@Param("userId") String userId);
	
	
}
