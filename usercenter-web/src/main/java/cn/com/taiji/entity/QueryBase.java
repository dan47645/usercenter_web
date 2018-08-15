package cn.com.taiji.entity;
/**
 * 
* @ClassName: QueryBase 
* @Description: TODO(查询基础类) 
* @author lyp
* @date 2018年1月25日 上午9:49:36 
* @version V1.0
 */
public class QueryBase {

	    /** 要排序的字段名 */
	    protected String sort;
	    /** 排序方式: desc \ asc */
	    protected String order = "";
	    /** 获取一页行数 */
	    protected int limit;
	    /** 获取的页码 */
	    protected int pageNumber;
	    /** 起始记录 */
	    protected int offset;

	    public String getSort() {
	        return sort;
	    }

	    public void setSort(String sort) {
	        this.sort = sort;
	    }

	    public String getOrder() {
	        return order;
	    }

	    public void setOrder(String order) {
	        this.order = order;
	    }

	    public int getLimit() {
	        return limit;
	    }

	    public void setLimit(int limit) {
	        this.limit = limit;
	    }

	    public int getPageNumber() {
	        return pageNumber;
	    }

	    public void setPageNumber(int pageNumber) {
	        this.pageNumber = pageNumber;
	    }

	    public int getOffset() {
	        return (this.pageNumber-1)*limit;
	    }

	    public void setOffset(int offset) {
	        this.offset = offset;
	    }

}
