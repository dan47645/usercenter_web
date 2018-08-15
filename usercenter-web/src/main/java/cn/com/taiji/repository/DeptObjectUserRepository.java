package cn.com.taiji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.DeptObjectUser;
import cn.com.taiji.entity.DeptUserPK;

/**
 * 机构用户关系表dao
 * @author SunJingyan
 * @date 2014-04-21
 *
 */
public interface DeptObjectUserRepository extends JpaRepository<DeptObjectUser, DeptUserPK>,JpaSpecificationExecutor<DeptObjectUser>, PagingAndSortingRepository<DeptObjectUser, DeptUserPK>{

	/**
	 * 根据机构用户关系表ID查询
	 * @param id
	 * @return
	 */
	@Query("select k from DeptObjectUser k where k.id=:id")
	DeptObjectUser findByPk(@Param("id") DeptUserPK id);
	
	/**
	 * 根据机构ID查询用户ID字符串集合
	 * @param deptId
	 * @return
	 */
	@Query("select k.id.userId from DeptObjectUser k where k.id.deptId =:deptId")
	List<String> findUserIdsByDeptId(@Param("deptId") String deptId);
	
	/**
	 * 根据用户ID查询机构ID字符串集合
	 * @param userId
	 * @return
	 */
	@Query("select k.id.deptId from DeptObjectUser k where k.id.userId =:userId")
	List<String> findDeptIdsByUserId(@Param("userId") String userId);
	
	/**
	 * *根据用户ID查询
	 * @param userId
	 * @return
	 */
	@Query("select k from DeptObjectUser k where k.id.userId =:userId")
	List<DeptObjectUser> findByUserId(@Param("userId") String userId);
	
	/**
	 * 根据机构ID查询
	 * @param deptId
	 * @return
	 */
	@Query("select k from DeptObjectUser k where k.id.deptId =:deptId")
	List<DeptObjectUser> findByDeptId(@Param("deptId") String deptId);
	
	@Modifying
	@Query("delete DeptObjectUser k where k.id.userId =?1")
	void deleteByUserId(@Param("userId") String userId);
	
	/**
	 * 根据机构ID,用户ID查询
	 * @param userId
	 * @param deptId
	 * @return
	 */
	@Query("select k from DeptObjectUser k where k.id.userId =:userId and k.id.deptId =:deptId")
	List<DeptObjectUser> findByUserIdAndDeptId(@Param("userId") String userId, @Param("deptId") String deptId);
	
	
}
