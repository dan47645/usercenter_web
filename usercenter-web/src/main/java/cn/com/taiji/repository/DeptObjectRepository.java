package cn.com.taiji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.DeptObject;

public interface DeptObjectRepository extends JpaRepository<DeptObject, String>, JpaSpecificationExecutor<DeptObject> {

	/**
	 * 查询机构树
	 * @return
	 */
	@Query("select d from DeptObject d left join fetch d.children")
	List<DeptObject> findDeptTree();
	
	/**
	 * 查询根节点下-所有人员
	 * @return
	 */
	@Query("select d from DeptObject d where d.parent='0' ")
	List<DeptObject> findAllUsersRootsByParentId();
	
	/**
	 * 查询根节点下-所有人员
	 * @return
	 */
	@Query("select d from DeptObject d where d.parent='0' ")
	List<DeptObject> findAllUsersRootsByParentIdNotPerson();

	/**
	 * 查询树根
	 * @return
	 */
	@Query("select d from DeptObject d where d.parent is null ")
	List<DeptObject> findRoots();
	/**
	 * 查询树根下下一节
	 * @return
	 */
	@Query("select d from DeptObject d where d.parent=1 ")
	List<DeptObject> findRootsByParentId();
	
	/**
	 * 查询树节点
	 * @return
	 */
	@Query("select d from DeptObject d where d.parent.id=:parentId ")
	List<DeptObject> findRootChildrens(@Param("parentId") String parentId);
	
	/**
	 * 查询某一根节点
	 * @param id
	 * @return
	 */
	@Query("select d from DeptObject d where d.id=:id ")
	List<DeptObject> findRootObjects(@Param("id") String id);
	
	
}
