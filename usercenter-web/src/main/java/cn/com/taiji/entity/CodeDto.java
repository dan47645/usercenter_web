package cn.com.taiji.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;


/**
 * 数据字典dto
 * @author SunJingyan
 * @date 2014年8月27日
 *
 */
public class CodeDto implements Serializable{
	
	private static final long serialVersionUID = 7275727535778417507L;
	
	private String id;

	@NotEmpty(message="业务代码不能为空")
	private String codeCode;

	private Integer codeIndex;
	
	private Integer category;

	@NotEmpty(message="代码名称不能为空")
	private String codeName;

	@NotEmpty(message="代码类型不能为空")
	private String codeType;

	private String codeTypeName;


	private String remark;

	private Integer flag;


	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	//	private Code code;
	/*子节点结合*/
	private List<Code> codes;
	
	private String token = "";
	
	/*父节点ID*/
	private String parentId;
	/*父节点*/
	private Code parent;

	public Code getParent() {
		return parent;
	}

	public void setParent(Code parent) {
		this.parent = parent;
	}

	/*父节点代码中文名称*/
	private String parentCodeName;

	
	public String getParentCodeName() {
		return parentCodeName;
	}

	public void setParentCodeName(String parentCodeName) {
		this.parentCodeName = parentCodeName;
	}

	public String getCodeCode() {
		return codeCode;
	}

	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeTypeName() {
		return codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}



	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	private List<CodeDto> children = new LinkedList<CodeDto>();


	public List<CodeDto> getChildren() {
		return children;
	}

	public void setChildren(List<CodeDto> children) {
		this.children = children;
	}

	public List<Code> getCodes() {
		return codes;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

	public String getToken() {
		return token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	


	
	
	

}
