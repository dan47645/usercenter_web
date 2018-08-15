package cn.com.taiji.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;



/**
 * The persistent class for the code database table.
 * 
 */
@Entity
@Table(name="code")
@NamedQuery(name="Code.findAll", query="SELECT c FROM Code c")
public class Code  extends Audited  implements Serializable {

	private static final long serialVersionUID = -98516053380975909L;


	@Column(name="code_code")
	private String codeCode;

	@Column(name="code_index")
	private Integer codeIndex;
	
	private Integer category;

	@Column(name="code_name")
	private String codeName;

	@Column(name="code_type")
	private String codeType;

	@Column(name="code_type_name")
	private String codeTypeName;


	private String remark;


	//bi-directional many-to-one association to Code
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Code code;

	//bi-directional many-to-one association to Code
	@OrderBy("codeIndex asc")
	@Where(clause="flag = 1")
	@OneToMany(mappedBy="code" , cascade = { CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<Code> codes;

	public Code() {
	}



	public String getCodeCode() {
		return this.codeCode;
	}

	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}

	public Integer getCodeIndex() {
		return this.codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

	public String getCodeName() {
		return this.codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeType() {
		return this.codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeTypeName() {
		return this.codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Code getCode() {
		return this.code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public List<Code> getCodes() {
		return this.codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

	public Code addCode(Code code) {
		getCodes().add(code);
		code.setCode(this);

		return code;
	}

	public Code removeCode(Code code) {
		getCodes().remove(code);
		code.setCode(null);

		return code;
	}
	
	

}