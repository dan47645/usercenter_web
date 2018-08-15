package cn.com.taiji.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.taiji.entity.Code;
import cn.com.taiji.entity.CodeDto;
import cn.com.taiji.repository.CodeRepository;

/**
 * 数据字典Service
 * 
 * @author SunJingyan
 * @date 2014年6月11日
 */
@Service
public class CodeService {

	@Autowired
	private CodeRepository codeRepository;

	@Autowired
	private ObjectMapper objectMapper;

	
	
	/**
	 * 根据代码类型查询代码
	 * @param codeType
	 * @return
	 * 20180130
	 */
	public List<CodeDto> getListAllCodes(String codeType){
		List<Code> list = this.codeRepository.findCodeByCodeType(codeType);
		List<CodeDto> dtos = new ArrayList<CodeDto>();
		if (list != null && list.size() > 0) {
			for (Code app : list) {
				dtos.add(codeDto(app));
			}
		}
		return dtos;
	}
	
	public CodeDto codeDto(Code c){
		CodeDto dto = new CodeDto();
		BeanUtils.copyProperties(c, dto);
		
		return dto;
	}
	
	/**
	 * 获取代码名称
	 * @param codeCode
	 * @param codeType
	 * @return
	 */
	public String getCodeName(String codeCode, String codeType){
		Code c = this.codeRepository.findCodeByTypeAndCode(codeCode, codeType);
		String name = null;
		if(c != null)
			name = c.getCodeName();
		
		return name;
		
	}
	
	public String getCodeByCodecode(String codeCode){
		String name = null;
		Code c = this.codeRepository.findByCodeCode(codeCode);
		if(c != null)
			name = c.getCodeName();
		return name;
	}
	
	/**
	 * 根据codeIds 获取 codeCode集合
	 * @param codeIds
	 * @return
	 */
	public String getCodeCodes(String codeIds){
		String[] aryCode;
		String codeCodes = null;
		StringBuilder sb = new StringBuilder();
		if(codeIds != null && !"".equals(codeIds)){
			aryCode = codeIds.split(",");
			for (int i = 0; i < aryCode.length; i++) {
				if(aryCode[i] != null && !"".equals(aryCode[i])){
					String codeId = aryCode[i];
					Code c = this.codeRepository.findOne(codeId);
					String codeCode = c.getCodeCode();
					sb.append(",").append(codeCode);
				}
			}
		}
		if (sb.length() > 0 && sb.indexOf(",") == 0) {
		    sb.replace(0, 1, "");
	    }
	    if(sb.toString() != null && !"".equals(sb.toString()))
	    	codeCodes = sb.toString();
	    return codeCodes;
	}
	
	
	/**
	 * 下拉数据字典
	 * @param model
	 */
	public void providerData(Model model) {
		
		List<CodeDto> identifications = this.getListAllCodes("identification");//用户标识

		List<CodeDto> documentTypes = this.getListAllCodes("documentType");//证件类型

		List<CodeDto> politicalStatuss = this.getListAllCodes("politicalStatus");//政治面貌

		List<CodeDto> nations = this.getListAllCodes("nation");//民族
		
		List<CodeDto> ranks = this.getListAllCodes("rank");//职级
		
		List<CodeDto> duties = this.getListAllCodes("duties");//职务
		
		List<CodeDto> unitNatures = this.getListAllCodes("unitNature");//单位性质
		
		List<CodeDto> categorys = this.getListAllCodes("category");//服务类别

		model.addAttribute("identifications", identifications);
		model.addAttribute("documentTypes", documentTypes);
		model.addAttribute("politicalStatuss", politicalStatuss);
		model.addAttribute("nations", nations);
		model.addAttribute("ranks", ranks);
		model.addAttribute("duties", duties);
		
		model.addAttribute("unitNatures", unitNatures);
		model.addAttribute("categorys", categorys);
		
	}
	
	

}
