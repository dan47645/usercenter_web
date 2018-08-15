package cn.com.taiji.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: PageUtil 
* @Description: TODO(分页工具) 
* @author lyp
* @date 2018年1月25日 下午4:54:49 
* @version V1.0 
* @param <T>
 */
public class PageUtil<T> implements Serializable{
	/**
	 * Description:
	 * @author bobo
	 */
	private static final long serialVersionUID = 1L;
	private List<T> list = new ArrayList<T>();
	private int totalCount;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
