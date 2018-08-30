package cn.com.taiji.entity;

import java.util.LinkedList;
import java.util.List;


public class DeptObjectDto {

	private String id;
	
	private String name;
	
	private String parentId;
	
	private String parentName;
	
	private DeptObject parent;
	private String orgCode;
	
	private List<DeptObjectDto> children = new LinkedList<DeptObjectDto>();

	
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public DeptObject getParent() {
		return parent;
	}

	public void setParent(DeptObject parent) {
		this.parent = parent;
	}

	public List<DeptObjectDto> getChildren() {
		return children;
	}

	public void setChildren(List<DeptObjectDto> children) {
		this.children = children;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	
	
}
