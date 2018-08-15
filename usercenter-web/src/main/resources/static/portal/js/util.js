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
      //删除提示
        function warnFunction(){
          return confirm("你确定要删除选中吗？");
        }
        
     /**   <a href="javascript:inotifyTest()">请点击我测试一下！</a>
        <script type="text/javascript">
        var iN = new iNotify({
            effect: 'flash',
            interval: 500,
            message:"有消息拉！2",
            audio:{
                file: ['msg.mp4','msg.mp3','msg.wav']
            },
            notification:{
                title:"通知！",
                body:'您来了一条新消息'
            }
        });

        function inotifyTest(){
            iN.setFavicon(10).setTitle('新标题').notify({
                title:"新通知",
                body:"打雷啦，下雨啦..."
            })
        }
        </script>**/