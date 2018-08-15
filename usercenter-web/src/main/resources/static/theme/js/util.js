		var map = {};
			map.pageSize = 10;
			map.page = 1;
			map.total = 0;
			currentPage = map.page;
			map.pageSize_dialog = 10;
			Handlebars.registerHelper('if_eq', function(v1, v2, opts) {
				if (v1 == v2)
					return opts.fn(this);
				else
					return opts.inverse(this);
			});
			$.fn.serializeObject = function () {
            var obj = {};
            var count = 0;
            $.each(this.serializeArray(), function (i, o) {
                var n = o.name, v = o.value;
                count++;
                obj[n] = obj[n] === undefined ? v
                : $.isArray(obj[n]) ? obj[n].concat(v)
                : [obj[n], v];
            });
            return obj;
        };
    	
        //检查非法字符-登录名
       	function checkval(t) {
       	    var re = /^[\u4e00-\u9fa5a-z0-9]+$/gi;//只能输入汉字和英文数字字母
       	    if (re.test(t)) {
       	        return true;
       	    } else {
       	        return false;
       	    }
       	};  
        //检查非法字符-邮箱
       	function checkEmail(t) {
       	 var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
       	    if (re.test(t)) {
       	        return true;
       	    } else {
       	        return false;
       	    }
       	};
        
      
