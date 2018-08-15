package cn.com.taiji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.com.taiji.entity.User;

public interface UserRepository extends JpaRepository<User, String>,JpaSpecificationExecutor<User>,PagingAndSortingRepository<User,String>{
	

    User findById(String id);

    Long deleteById(Long id);
    @Modifying
    @Query(value = "insert into user(user_name,password,login_name,telphone,email) values(?1,?2,?3,?4,?5)",nativeQuery = true)
    int addUser(String userName,String password,String loginName,String telephone,String email);
    /**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	@Query("select u from User u where u.loginName =:loginName and u.flag=1")
	User findByLoginName(@Param("loginName") String loginName);
	
}