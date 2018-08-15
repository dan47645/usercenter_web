package cn.com.taiji.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dept_object_user")
public class DeptObjectUser {

	@EmbeddedId
	private DeptUserPK id;
	
	public DeptObjectUser() {
		// TODO Auto-generated constructor stub
	}

	public DeptUserPK getId() {
		return id;
	}

	public void setId(DeptUserPK id) {
		this.id = id;
	}
	
	
	
}
