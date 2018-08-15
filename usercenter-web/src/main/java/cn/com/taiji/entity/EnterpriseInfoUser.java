package cn.com.taiji.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @ClassName: EnterpriseInfoUser
 * @Description: TODO(企业分配用户实体类)
 * @author lyp
 * @date 2018年1月30日 上午11:14:25
 * @version V1.0
 */
@Entity
@Table(name = "enterpriseinfo_user")
@NamedQuery(name = "EnterpriseInfoUser.findAll", query = "SELECT u FROM EnterpriseInfoUser u")
public class EnterpriseInfoUser implements Serializable {

	private static final long serialVersionUID = -1382925073246209455L;

	@EmbeddedId
	private EnterpriseInfoUserPK id;

	public EnterpriseInfoUser() {
	}

	public EnterpriseInfoUserPK getId() {
		return id;
	}

	public void setId(EnterpriseInfoUserPK id) {
		this.id = id;
	}

}