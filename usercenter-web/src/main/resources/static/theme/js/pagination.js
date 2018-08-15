//分页

/**
 * 对象（container div），页面(count)，页码(pageindex)，pageSize(每页条数)，总(total)
 */
	function setPage(container, count, pageindex, pageSize, total) {
	  var a = [];
	  if(count==0) {
		a[a.length] = "<span class=\"fypad\">共<span class=\"fontcor\"></span>0<span class=\"fontcor\"></span>页</span>";
		  container.innerHTML = a.join("");
	  }
	  else {
		//总页数少于10 全部显示,大于10 显示前3 后3 中间3 其余....
		  if (pageindex == 1) {
		    a[a.length] = "<span class=\"fypad\">共<span class=\"fontcor\"></span>"+total+"<span class=\"fontcor\"></span>条<span class=\"fontcor\"></span></span><span class=\"fypad\">每页<select id=\"pageSize\" onchange=\"pageSizeSelectOnChange()\" text-align=\"center\" style=\"width:60px;\"><option value =\"10\">10</option><option value =\"15\">15</option><option value=\"5\">5</option><option value=\"20\">20</option></select>条<span class=\"fontcor\"></span><span class=\"fontcor\"></span><span class=\"fypad\">共<span class=\"fontcor\"></span> "+count+"<span class=\"fontcor\"></span>页</span></span><a href=\"#\" class=\"prev unclick\">上一页</a>";
		  } else {
		    a[a.length] = "<span class=\"fypad\">共<span class=\"fontcor\"></span>"+total+"<span class=\"fontcor\"></span>条<span class=\"fontcor\"></span></span><span class=\"fypad\">每页<select id=\"pageSize\" onchange=\"pageSizeSelectOnChange()\" text-align=\"center\" style=\"width:60px;\"><option value =\"10\">10</option><option value =\"15\">15</option><option value=\"5\">5</option><option value=\"20\">20</option></select>条<span class=\"fontcor\"></span><span class=\"fontcor\"></span><span class=\"fypad\">共<span class=\"fontcor\"></span>"+count+"<span class=\"fontcor\"></span>页</span></span><a href=\"#\" class=\"prev\">上一页</a>";		  
		  } 
		//总页数小于10
		  if (count <= 10) {
		    for (var i = 1; i <= count; i++) {
		      setPageList();
		    }
		  }
		  //总页数大于10页
		  else {
		    if (pageindex <= 4) {
		      for (var i = 1; i <= 5; i++) {
		        setPageList();
		      }
		      a[a.length] = "...<a href=\"#\">" + count + "</a>";
		    } else if (pageindex >= count - 3) {
		      a[a.length] = "<a href=\"#\">1</a>...";
		      for (var i = count - 4; i <= count; i++) {
		        setPageList();
		      }
		    }
		    else { //当前页在中间部分
		      a[a.length] = "<a href=\"\">1</a>...";
		      for (var i = pageindex - 2; i <= pageindex + 2; i++) {
		        setPageList();
		      }
		      a[a.length] = "...<a href=\"#\">" + count + "</a>";
		    }
		  }
		  if (pageindex == count) {
		    a[a.length] = "<a href=\"#\" class=\"next unclick\">下一页</a>";
		  } else {
		    a[a.length] = "<a href=\"#\" class=\"next\">下一页</a>";
		  }
		  for(var i = 0; i < 10; i++) {
			  container.innerHTML = a.join("");
	  }
	  function setPageList() {
	    if (pageindex == i) {
	      a[a.length] = "<a href=\"#\" class=\"on unclick\">" + i + "</a>";
	    } else {
	      a[a.length] = "<a href=\"#\">" + i + "</a>";
	    }
	  }	
	  $("#pageSize").val(pageSize); 
	}
	  	  
	  //事件点击
	  var pageClick = function() {
	    var oAlink = container.getElementsByTagName("a");
	    var inx = pageindex; //初始的页码
	    if(oAlink.length==0){
	    	return;
	    }
	    else{
		    oAlink[0].onclick = function() { //点击上一页
		      if (inx == 1) {
		        return false;
		      }
		      inx--;
		      currentPage--;
		      display_result();
//		      display_result1();
//		      display_result2();
		      setPage(container, count, inx);
		      return false;
		    }
		    for (var i = 1; i < oAlink.length - 1; i++) { //点击页码
		      oAlink[i].onclick = function() {
		        inx = parseInt(this.innerHTML);
		        currentPage = inx;
		        display_result();
//		        display_result1();
//			    display_result2();
		        setPage(container, count, inx);
		        return false; 
		      }
		    }
		    oAlink[oAlink.length - 1].onclick = function() { //点击下一页
		      if (inx == count) {
		        return false;
		      }
		      inx++;
		      currentPage++;
		      display_result();
//		      display_result1();
//			  display_result2();
		      setPage(container, count, inx);
		      return false;
		    }
	    }
	  }() 

	}
	
	 //每页显示记录数改变事件
 	 function pageSizeSelectOnChange(){
 		resetCurrentPage();
 		display_result();
// 		display_result1();
//	    display_result2();
 	 }
 	 
	 //重置当前页
 	 function resetCurrentPage(){
  		currentPage=1;
 	 }
