package cn.com.taiji.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.taiji.entity.Certification;
import cn.com.taiji.entity.CertificationDto;
import cn.com.taiji.entity.Code;
import cn.com.taiji.entity.CodeDto;
import cn.com.taiji.entity.DeptObject;
import cn.com.taiji.entity.DeptObjectUser;
import cn.com.taiji.entity.EnterpriseFromServerDto;
import cn.com.taiji.entity.EnterpriseInfo;
import cn.com.taiji.entity.EnterpriseInfoUser;
import cn.com.taiji.entity.HonorCertificate;
import cn.com.taiji.entity.HonorCertificateDto;
import cn.com.taiji.entity.ServerOrg;
import cn.com.taiji.repository.CertificationRepository;
import cn.com.taiji.repository.CodeRepository;
import cn.com.taiji.repository.DeptObjectRepository;
import cn.com.taiji.repository.DeptObjectUserRepository;
import cn.com.taiji.repository.EnterpriseInfoRepository;
import cn.com.taiji.repository.HonorCertificateRepository;
import cn.com.taiji.repository.ServerOrgRepository;
import cn.com.taiji.util.BeanToMapUtil;
import cn.com.taiji.util.DateUtil;
import cn.com.taiji.util.OrgCodeUtil;
import cn.com.taiji.util.PageUtil;

@Service
public class ServeOrgService {
	@Autowired
	private ServerOrgRepository serverOrgRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CodeRepository codeRepository;
	
	@Autowired
	private EnterpriseInfoRepository enterpriseInfoRepository;
	
	@Autowired
	private CertificationRepository certificationRepository;
	
	
	@Autowired
	private HonorCertificateRepository honorCertificateRepository;
	
	@Autowired
	private DeptObjectUserRepository deptObjectUserRepository;
	
	@Autowired
	private DeptObjectRepository deptObjectRepository;
	
	
	public List<DeptObjectUser> findByUserId(String userId){
		return deptObjectUserRepository.findByUserId(userId);
	}
	public ServerOrg getServerOrgByEnterpriseId(@Param("enterpriseId") String enterpriseId) {
		return serverOrgRepository.getServerOrgByEnterpriseId(enterpriseId);
	}

	/**
	 * 查询该节点下的 子节点
	 * 
	 * @param codeCode
	 * @return
	 */
	public List<CodeDto> getCodeByCode(String codeCode) {
		System.out.println("查询该节点下的子节点!!!========" + codeCode);
		List<CodeDto> dtoList = new ArrayList<CodeDto>();
		String codeType = "category";
		if (codeCode != null && codeCode.length() > 0) {
			Code c = this.codeRepository.findCodeByTypeAndCode(codeCode, codeType);
			List<Code> childList = c.getCodes();
			if (childList != null && childList.size() > 0) {
				for (Code code : childList) {
					dtoList.add(code2Dto(code));
				}
			}
		}
		return dtoList;

	}

	public CodeDto code2Dto(Code c) {
		CodeDto dto = new CodeDto();
		BeanUtils.copyProperties(c, dto);

		return dto;
	}

	public PageUtil<CertificationDto> findByPage(String sid, Pageable pageable) {

		StringBuilder dataSql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		dataSql.append("from Certification c where 1=1");
		countSql.append("select count(*) from certification c where 1=1");

		if (sid != null && !"".equals(sid)) {
			dataSql.append(" and c.sid=:sid");
			countSql.append(" and c.sid=:sid");
		}

		int pageNum = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();
		// Sort sort = pageable.getSort();
		// System.out.println(sort.spliterator());

		Query dataQuery = entityManager.createQuery(dataSql.toString(), Certification.class);
		dataQuery.setFirstResult(pageNum);
		dataQuery.setMaxResults(pageSize);
		Query countQuery = entityManager.createNativeQuery(countSql.toString());

		if (sid != null && !"".equals(sid)) {
			dataQuery.setParameter("sid", sid);
			countQuery.setParameter("sid", sid);
		}

		List<CertificationDto> list = dataQuery.getResultList();
//		BigInteger count = (BigInteger) countQuery.getSingleResult();
		BigDecimal count = (BigDecimal) countQuery.getSingleResult();
		
		PageUtil<CertificationDto> page = new PageUtil<CertificationDto>();
		page.setList(list);
		page.setTotalCount(count.intValue());
		return page;
	}

	public PageUtil<HonorCertificateDto> findByPageAll(String sid, Pageable pageable) {

		StringBuilder dataSql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		dataSql.append("from HonorCertificate h where 1=1");
		countSql.append("select count(*) from honor_certificate h where 1=1");

		if (sid != null && !"".equals(sid)) {
			dataSql.append(" and h.sid=:sid");
			countSql.append(" and h.sid=:sid");
		}

		int pageNum = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();
		// Sort sort = pageable.getSort();
		// System.out.println(sort.spliterator());

		Query dataQuery = entityManager.createQuery(dataSql.toString(), HonorCertificate.class);
		dataQuery.setFirstResult(pageNum);
		dataQuery.setMaxResults(pageSize);
		Query countQuery = entityManager.createNativeQuery(countSql.toString());

		if (sid != null && !"".equals(sid)) {
			dataQuery.setParameter("sid", sid);
			countQuery.setParameter("sid", sid);
		}

		List<HonorCertificateDto> list = dataQuery.getResultList();
//		BigInteger count = (BigInteger) countQuery.getSingleResult();
		BigDecimal count = (BigDecimal) countQuery.getSingleResult();
		PageUtil<HonorCertificateDto> page = new PageUtil<HonorCertificateDto>();
		page.setList(list);
		page.setTotalCount(count.intValue());
		return page;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public ServerOrg findById(String id) {
		return this.serverOrgRepository.findOne(id);
	}

	// 保存实体
	@Transactional(propagation = Propagation.REQUIRED)
	public ServerOrg save(ServerOrg dept) {
		
		//保存公共表中的DeptObjectId
		DeptObject deptObject = new DeptObject();
//		DeptObject parent = this.deptObjectRepository.findOne("3");// 获取上级机构
//		deptObject.setName(dept.getEnterpriseName());
//		deptObject.setParent(parent);
//		deptObject.setOrgCode(OrgCodeUtil.getGuid());
		if (dept.getDeptObjectId() != null && dept.getDeptObjectId().trim().length() > 0) {
			//deptObject = this.deptObjectRepository.findOne(dto.getDeptObjectId());
			deptObject = this.deptObjectRepository.findOne(dept.getId());

		}
		
		if (dept.getServerOrgTid() != null && !"".equals(dept.getServerOrgTid())) {
			DeptObject parent = this.deptObjectRepository.findOne(dept.getServerOrgTid());// 获取上级机构
			deptObject.setId(dept.getId());
			deptObject.setName(dept.getEnterpriseName());
			deptObject.setParent(parent);
			deptObject.setOrgCode(OrgCodeUtil.getGuid());
		} else {
			DeptObject parent = this.deptObjectRepository.findOne("3");// 获取上级机构
			deptObject.setId(dept.getId());
			deptObject.setName(dept.getEnterpriseName());
			deptObject.setParent(parent);
			deptObject.setOrgCode(OrgCodeUtil.getGuid());
		}
		if(null == dept.getDeptObjectId() || "".equals(dept.getDeptObjectId())){
			DeptObject deptObj = this.deptObjectRepository.saveAndFlush(deptObject);
			dept.setDeptObjectId(deptObj.getId());
		}
		
		if (dept.getDeptObjectId() == null || dept.getDeptObjectId().trim().length() == 0) {
			dept.setDeptObjectId(dept.getId());// 获取公共表ID关联
			dept.setAuditStatus("0");
		}
		// 绑定树和列表
		if (dept.getServerOrgTid() == null || dept.getServerOrgTid().trim().length() == 0) {
			dept.setServerOrgTid("3");// 获取公共表ID关联--点击树的时候升级服务机构关系
		}
		
		
		
		
		return serverOrgRepository.save(dept);
	}

	/**
	 * 根据企业名称查询企业信息，并封装在MAP中
	 * 
	 * @param enterpriseName
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public Map mapEnterpriseByEName(String enterpriseName) {
		Map map = new HashMap();
		EnterpriseFromServerDto enterpriseFromServerDto = new EnterpriseFromServerDto();
		EnterpriseInfo entity = this.enterpriseInfoRepository.findByEnterpriseName(enterpriseName);

		if (entity != null) {
			BeanUtils.copyProperties(entity, enterpriseFromServerDto);
			enterpriseFromServerDto.setRegistTime(DateUtil.dateToString(enterpriseFromServerDto.getRegisterTime()));
		}
		List<ServerOrg> orgList = this.serverOrgRepository.findByEnterpriseName(enterpriseName);

		try {
			map = BeanToMapUtil.convertBeanToMap(enterpriseFromServerDto);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCertification(List<CertificationDto> list) {
		if (list != null && list.size() > 0) {
			for (CertificationDto dto : list) {
				Certification certification = new Certification();
				ServerOrg serverOrg = this.serverOrgRepository.findOne(dto.getSid());
				dto.setServerOrg(serverOrg);
				if(dto.getId() != null && dto.getId().length() > 0){
					certification = this.certificationRepository.findOne(dto.getId());
				}
				BeanUtils.copyProperties(dto, certification);
				this.certificationRepository.saveAndFlush(certification);
			}
		}
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void addHonorCertificate(List<HonorCertificateDto> list) {
		if (list != null && list.size() > 0) {
			for (HonorCertificateDto dto : list) {
				HonorCertificate honorCertificate = new HonorCertificate();
				ServerOrg serverOrg = this.serverOrgRepository.findOne(dto.getSid());
				dto.setServerOrg(serverOrg);
				if(dto.getId() != null && dto.getId().length() > 0){
					honorCertificate = this.honorCertificateRepository.findOne(dto.getId());
				}
				BeanUtils.copyProperties(dto, honorCertificate);
				this.honorCertificateRepository.saveAndFlush(honorCertificate);
			}
		}
	}
	public CertificationDto findByCertificationId(String id){
		CertificationDto dto = new CertificationDto();
		Certification entity = certificationRepository.findOne(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public HonorCertificateDto findByHonorId(String id){
		HonorCertificateDto dto = new HonorCertificateDto();
		HonorCertificate entity = honorCertificateRepository.findOne(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	public void removeCBath(String cid) {
		try {
			certificationRepository.delete(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeHBath(String hid) {
		try {
			honorCertificateRepository.delete(hid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DeptObjectUser saveDeptObjectUser(DeptObjectUser deptObjectUser) {
		DeptObjectUser deptUser = deptObjectUserRepository.save(deptObjectUser);
		return deptUser;
	}
	
}
