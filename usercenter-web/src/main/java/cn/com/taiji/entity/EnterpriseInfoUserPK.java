package cn.com.taiji.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
* @ClassName: EnterpriseInfoUserPK 
* @Description: TODO(企业分配用户联合主键) 
* @author lyp
* @date 2018年1月30日 上午11:13:58 
* @version V1.0
 */
@Embeddable
public class EnterpriseInfoUserPK implements Serializable {
	
	private static final long serialVersionUID = 3249113099141192520L;
	@Column(name="enterpriseinfo_id", insertable=false, updatable=false)
	private String enerpriseInfoId;

	@Column(name="user_id", insertable=false, updatable=false)
	private String userId;

	public EnterpriseInfoUserPK() {
	}
	
	public String getEnerpriseInfoId() {
		return enerpriseInfoId;
	}

	public void setEnerpriseInfoId(String enerpriseInfoId) {
		this.enerpriseInfoId = enerpriseInfoId;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EnterpriseInfoUserPK)) {
			return false;
		}
		EnterpriseInfoUserPK castOther = (EnterpriseInfoUserPK)other;
		return 
			this.enerpriseInfoId.equals(castOther.enerpriseInfoId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.enerpriseInfoId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}