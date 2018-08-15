package cn.com.taiji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.Code;

/**
 * 数据字典dao
 * @author SunJingyan
 * @date 2014年8月27日
 *
 */
public interface CodeRepository  extends JpaRepository<Code, String>,JpaSpecificationExecutor<Code>{

	/**
	 * 根据代码类型查询出业务代码
	 * @param codeType
	 * @return
	 */
	@Query("select c.codeCode from Code  c where c.codeType=:codeType") 
	List<String> findCodeByType(@Param("codeType") String codeType);
	
	/**
	 * 标记为删除
	 * @param id
	 */
	@Modifying
	@Query("update Code c set c.flag=0 where c.id=:id ")
	void updateFlag(@Param("id") String id);
	
	/**
	 * 查询出未删除的所有数据字典记录集合
	 * @return
	 */
	@Query("select c from Code c where c.flag=1") 
	List<Code> findAllCodes();
	
	/**
	 * 根据codeCode查询出记录
	 * @param codeCode
	 * @return
	 */
	@Query("select c from Code c where c.codeCode = :codeCode and c.id!= :id and c.flag=1")
	Code findByCodeCode(@Param("codeCode") String codeCode, @Param("id") String id);
	
	/**
	 * 查询出子节点集合
	 * @param code
	 * @return
	 */
	@Query("select c from Code c where c.code = :parent and c.flag=1")
	List<Code> findAllChildCodes(@Param("parent") Code code);
	/**
	 * 
	 * @Description: 查询所有多级业务代码
	 * @return List<Code>  
	 * @throws
	 * @author y-tj
	 * @date 2017年5月24日
	 */
	@Query("select c from Code c where c.code = null and c.category = 1 and c.flag=1")
	List<Code> findRoots();
	
	
	//------------------20180115--------------------
	/**
	 * 根据代码类型查询
	 * @param codeType
	 * @return
	 */
	@Query("select c from Code  c where c.codeType=:codeType order by c.codeIndex ") 
	List<Code> findCodeByCodeType(@Param("codeType") String codeType);
	
	@Query("select c from Code  c where c.codeCode=:codeCode and c.codeType=:codeType") 
	Code findCodeByTypeAndCode(@Param("codeCode") String codeCode, @Param("codeType") String codeType);
	
	/**
	 * 根据codeCode查询出记录
	 * @param codeCode
	 * @return
	 */
	@Query("select c from Code c where c.codeCode =:codeCode and c.flag=1")
	Code findByCodeCode(@Param("codeCode") String codeCode);
 
}
