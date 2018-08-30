package cn.com.taiji.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * 机构管理总表
 *
 */
@Entity
@Table(name="dept_object")
public class DeptObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;//机构id
	
	@Column(name = "name")
	private String name;//机构名称
	@Column(name = "org_code")
	private String orgCode;
	
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, optional = false)
	@NotFound(action=NotFoundAction.IGNORE)  
	@JoinColumn(name="parent_id", insertable = true, updatable = true)
	private DeptObject parent = null;
	
	@OneToMany(mappedBy="parent")
	private List<DeptObject> children = new LinkedList<DeptObject>();
	
	 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonBackReference
	public DeptObject getParent() {
		return parent;
	}

	public void setParent(DeptObject parent) {
		this.parent = parent;
	}

	public List<DeptObject> getChildren() {
		return children;
	}

	public void setChildren(List<DeptObject> children) {
		this.children = children;
	}
	
	@PrePersist
	public void createAuditInfo(){
		if("".equals(this.getId())||this.getId()==null) {
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			this.setId(id);
		}
		
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	
	
	
}
