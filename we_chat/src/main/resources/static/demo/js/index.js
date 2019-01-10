$(function(){


    //进度条效果
	  var value = 0;
    var time =50;
    var val =100;
    function increment() {
          if(val == 0 ){
            return
          }
          value += 1;
          var right = (-0.63 * parseFloat(value) + 54)   
         

          $("#protext").css("right",right+"%")
          $("#protext_txt").text(value+"%") 
          if (value>90 && value<=100) {
            $("#scollimg").css("padding-left",1.5 + "rem")
          } 
          if (value>=0 && value<=100) {
	      	  $("#colorbar1").css("width",value + "%")
    	 	 	}
          if(val == value){
          	return;
          }
     	 st = setTimeout(increment,time);      
    }

     increment();

    //上拉加载数据下拉刷新数据

    var  mescroll = new MeScroll("mescroll", { 
        up: {
            callback: upCallback, //上拉回调
            //以下参数可删除,不配置
            isBounce: false, //此处禁止ios回弹,解析(务必认真阅读,特别是最后一点): http://www.mescroll.com/qa.html#q10
            //page:{size:8}, //可配置每页8条数据,默认10
            toTop:{ //配置回到顶部按钮
              src : "img/mescroll-totop.png", //默认滚动到1000px显示,可配置offset修改
              //html: null, //html标签内容,默认null; 如果同时设置了src,则优先取src
              //offset : 1000
            },empty:{ //配置列表无任何数据的提示
              warpId:"dataList",
              icon : "img/mescroll-empty.png" , 
//                tip : "亲,暂无相关数据哦~" , 
//                btntext : "去逛逛 >" , 
//                btnClick : function() {
//                  alert("点击了去逛逛按钮");
//                } 
            },
            clearEmptyId: "dataList",
            pageSize:9
         }

    })
    page = 0;

    function upCallback(page){
     page +=9;
      console.log("upCallback" , page)
      getListDataFromNet(page.num, page.size,function(data){
         console.log("page.num="+page.num+", page.size="+page.size+", curPageData.length="+data.length);
        
          mescroll.endByPage(page, 90);
          setListData(data);

      },function(){
        //联网失败的回调,隐藏下拉刷新和上拉加载的状态;
        console.log("error")
        mescroll.endErr();
      })

    }
     
      function getListDataFromNet(pageNum,pageSize,successCallback,errorCallback) {
        //延时一秒,模拟联网
          setTimeout(function () {
            $.ajax({
              type: 'GET',
              url: './data.json',
//                    url: '../res/pdlist1.json?num='+pageNum+"&size="+pageSize,
              dataType: 'json',
              success: function(data){
                console.log(data)
                //模拟分页数据
                var listData=data.list;

                successCallback(listData);
              },
              error: errorCallback
          });
          },1000)
      }

      function setListData(data){
        for(var i in data){
          var obj  = data[i];
          console.log(obj)
          var img = "https://iobs.pingan.com.cn/download/mvip-core-dmz-prd/"+obj.img;
          var oldPoint = obj.oldPoint / 10000.0;
          var point = obj.point / 10000.0;
          var text ="<img src="+img+">"
          +"<div class='icon_text txt'>"+ obj.name +"</div>"
          +"<div class='old_point_text txt'>原积分:<del>"+oldPoint+"万</del></div>"
          +"<div class='point_text txt'>兑换积分:<span class='color_t'>"+point+"万</span></div>"
          var liDom=document.createElement("li");
          liDom.innerHTML=text;
          document.getElementById("dataList").appendChild(liDom);
        }

      }
})

