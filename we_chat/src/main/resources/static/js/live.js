		//设置昵称
		var st = document.getElementById("subscribeTitle")
		var un = document.getElementById("unameAlert")
		var subscribe = document.getElementById("subscribe")
		
		subscribe.addEventListener("touchstart",function(event){
			
			if(st.style.display != "none"){
				st.style.display = "none";
				un.style.display ="block";
			}
			event.stopPropagation();//停止冒泡
		},false)


		document.body.addEventListener("touchstart",function(event){
			var name =document.getElementById("uname")
			if(un.style.display != "none"){
				console.log(name.value)
				if(name.value.trim() !=""){
					subscribe.innerHTML = name.value.trim()
				}
				un.style.display = "none";
				st.style.display ="block";
				
			}
		},false)

		//文字颜色
		var colorList = ['#000000','#FF0000','#00FF00','#0000FF','#FFFF00',	'#00FFFF','#FF00FF','#C0C0C0','#FFFFFF']
		var colorIndex =0;


		var image = document.getElementById("recive");
		image.addEventListener("error",function(event){
			event.target.src="../images/404.PNG"
		},false)

		//视频socket
		var recive_socket = new WebSocket("ws://120.78.190.69:80/djl/onlineServer");
		
		recive_socket.onmessage = function(info) {
			image.src = info.data;
		}

		//文字webSocket
		var msg_socket = new WebSocket("ws://120.78.190.69:80/djl/chatroom");
		msg_socket.onopen =function(){
			console.log("live1")
			msg_socket.send("live1");
		}
		msg_socket.onclose =function(){
			console.log("live2")
			msg_socket.send("live2");
		}
		msg_socket.onmessage = function(data) {
			console.log(data.data)
			var info = eval("("+data.data+")")
			if(info.name == "msg"){
				if(colorIndex >= colorList.length){
					colorIndex=0
				}else{
					colorIndex ++
				}
				var msg = document.getElementById("dm");
				msg.style.color = colorList[colorIndex];
				msg.innerHTML += "&nbsp;" +info.info;
				msg.scrollTop =msg.scrollHeight -msg.clientHeight ;
				tanmu(info.info)
			}
		}
		//弹幕
		function tanmu(data){
			//判断之前有多少个弹幕
			var tanmutxt = document.getElementsByClassName("tanmutxt")
			var count = 0;
			if(tanmutxt.length > 0){
				count = tanmutxt.length
			}

			var div = document.createElement("div")
			div.setAttribute("class","tanmutxt")

			if(count > 10){
				count = count % 10
			}
			div.style.cssText = "top:" + (15+count*2 +"%;") +"color:" +  colorList[colorIndex]
			div.innerHTML=data
			document.body.appendChild(div)
			setTimeout(function(){
				document.body.removeChild(div)
			},3000)
		}


		//发送信息
		function sendMsg() {
			//判断是否设置了昵称
			var name =document.getElementById("uname")
			if(name.value.trim() == ""){
				un.style.display = "block";
				st.style.display ="none";
				name.focus();
				return;
			}
			if(document.getElementById("msg").value.trim() == ""){
				return;
			}
			var msg = name.value.trim()+"：" + document.getElementById("msg").value + "<br>";
			msg_socket.send(msg);
		}