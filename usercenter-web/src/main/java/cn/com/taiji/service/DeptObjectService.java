package cn.com.taiji.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.entity.DeptObject;
import cn.com.taiji.entity.DeptObjectDto;
import cn.com.taiji.repository.DeptObjectRepository;

@Service
public class DeptObjectService {

	@Autowired
	private DeptObjectRepository deptObjectRepository;
	

	/**
	 * 保存服务机构树节点
	 * 
	 * @Description: TODO
	 * @param
	 * @return void
	 * @author lyp
	 * @date 2018年4月26日
	 */
	public void saveDeptObjet(DeptObject d) {
		deptObjectRepository.saveAndFlush(d);
	}

	/**
	 * 修改服务机构树节点
	 * 
	 * @Description: TODO
	 * @param
	 * @return void
	 * @author lyp
	 * @date 2018年4月26日
	 */
	public void editDeptObjet(DeptObject d) {
		deptObjectRepository.saveAndFlush(d);
	}

	/**
	 * 删除服务机构节点
	 * 
	 * @Description: TODO
	 * @param
	 * @return void
	 * @author lyp
	 * @date 2018年4月26日
	 */
	public void delDeptObject(String id) {
		deptObjectRepository.delete(id);

	}
	public DeptObject getDeptObject(String pid) {
		DeptObject d=deptObjectRepository.findOne(pid);
		return d;
	}
	/**
	 * 查询树根
	 * 
	 * @return
	 */
	// TODO
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<DeptObjectDto> findByParentId(String parentId, String salt) {
		List<DeptObject> orgs = this.deptObjectRepository.findAllUsersRootsByParentId();
		return dept2Dto(orgs, salt);
	}
	
	/**
	 * 查询树根除了个人
	 * 
	 * @return
	 */
	// TODO
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<DeptObjectDto> findByParentIdNotPerson(String parentId, String salt) {
		List<DeptObject> orgs = this.deptObjectRepository.findAllUsersRootsByParentIdNotPerson();
		return dept2DtoNotPerson(orgs, salt);
	}
	
	/**
	 * 查询根节点下一级目录
	 * @Description: TODO
	 * @param @param parentId
	 * @param @param salt
	 * @param @return   
	 * @return List<DeptObjectDto>  
	 * @throws
	 * @author lyp
	 * @date 2018年4月25日
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<DeptObjectDto> findByFirstDeptId(String parentId, String salt) {
		List<DeptObject> orgs = this.deptObjectRepository.findRootsByParentId();
		return dept2Dto(orgs, salt);
	}
	
	
	/**
	 * 
	 * @Description: user集合对象转换为DTO集合
	 * @param userList
	 */
	public List<DeptObjectDto> dept2Dto(List<DeptObject> list, String salt) {
		List<DeptObjectDto> dtos = new ArrayList<DeptObjectDto>();
		if (list != null && list.size() > 0) {
			for (DeptObject m : list) {
				dtos.add(dept2Dto(m, salt));
			}
		}
		return dtos;
	}
	/**
	 * 
	 * @Description: user集合对象转换为DTO集合
	 * @param userList
	 */
	public List<DeptObjectDto> dept2DtoNotPerson(List<DeptObject> list, String salt) {
		List<DeptObjectDto> dtos = new ArrayList<DeptObjectDto>();
		if (list != null && list.size() > 0) {
			for (DeptObject m : list) {
				dtos.add(dept2DtoNotPerson(m, salt));
			}
		}
		return dtos;
	}
	
	/**
	 * 
	 * @Description: user对象转换为DTO对象
	 * @param user
	 * @param salt
	 */
	public DeptObjectDto dept2Dto(DeptObject dept, String salt) {
		DeptObjectDto dto = new DeptObjectDto();
		BeanUtils.copyProperties(dept, dto);
		if (dept.getParent() != null && dept.getParent().getId() != null) {
			dto.setParentId(dept.getParent().getId());
			dto.setParentName(dept.getParent().getName());
		}
		if (dept.getChildren() != null && !dept.getChildren().isEmpty()) {
			dto.setChildren(objList2DtoList(dept.getChildren()));
		}
		
		return dto;
	}
	/**
	 * 
	 * @Description: user对象转换为DTO对象
	 * @param user
	 * @param salt
	 */
	public DeptObjectDto dept2DtoNotPerson(DeptObject dept, String salt) {
		DeptObjectDto dto = new DeptObjectDto();
		BeanUtils.copyProperties(dept, dto);
		if (dept.getParent() != null && dept.getParent().getId() != null) {
			dto.setParentId(dept.getParent().getId());
			dto.setParentName(dept.getParent().getName());
		}
		if (dept.getChildren() != null && !dept.getChildren().isEmpty()) {
			dto.setChildren(objList2DtoListNotPerson(dept.getChildren()));
		}
		
		return dto;
	}
	
	/**
	 * 
	 * @Description: 集合对象转换为DTO集合
	 * @param depts
	 */
	public List<DeptObjectDto> objList2DtoList(List<DeptObject> depts) {
		List<DeptObjectDto> dtos = new ArrayList<DeptObjectDto>();
		for (DeptObject dept : depts) {
			dtos.add(obj2Dto(dept));
		}
		return dtos;
	}
	/**
	 * 
	 * @Description: 集合对象转换为DTO集合
	 * @param depts
	 */
	public List<DeptObjectDto> objList2DtoListNotPerson(List<DeptObject> depts) {
		List<DeptObjectDto> dtos = new ArrayList<DeptObjectDto>();
		for (DeptObject dept : depts) {
			if(!"5".equals(dept.getId())) {
				dtos.add(obj2Dto(dept));
			}
			
		}
		return dtos;
	}
	
	/**
	 * 
	 * @Description: 对象转换为DTO
	 * @param d
	 * @return DeptObjectDto
	 */
	public DeptObjectDto obj2Dto(DeptObject d) {
		DeptObjectDto dto = new DeptObjectDto();
		BeanUtils.copyProperties(d, dto);
		if (d.getParent() != null && d.getParent().getId() != null) {
			dto.setParentId(d.getParent().getId());
			dto.setParentName(d.getParent().getName());
		}
		if (d.getChildren() != null && !d.getChildren().isEmpty()) {
			dto.setChildren(objList2DtoList(d.getChildren()));
		}
		return dto;
	}
	
	
	//---------------2018-01-19------------------------
	/**
	 * 查询管理机构Tree
	 * @param parentId
	 * @param salt
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<DeptObjectDto> findByMOrgParentId(String parentId, String salt) {
		List<DeptObject> orgs = this.deptObjectRepository.findRootChildrens(parentId);
		return dept2Dto(orgs, salt);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public DeptObjectDto getByMOrgId(String id, String salt) {
		DeptObject orgs = this.deptObjectRepository.getOne(id);
		return dept2Dto(orgs, salt);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public DeptObject getByOrgId(String id, String salt){
		DeptObject orgs = deptObjectRepository.getOne(id);
		return orgs;
	}
	
	
}
