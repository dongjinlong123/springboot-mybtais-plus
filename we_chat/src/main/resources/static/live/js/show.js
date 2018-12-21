
		
		var back = document.getElementById("output");
		var backContext = document.getElementById("output").getContext("2d");
		var video = document.getElementById("vi");
		var socket;
		var interval;
		var url = "https://dongjinlong123.xyz/djl/getShowCount.do"
		var xhr = new XMLHttpRequest()
		xhr.open("POST",url,true)
		xhr.onreadystatechange = function(){
		if(xhr.readyState ==4 && xhr.status == 200){
				console.log(xhr.responseText)
				if(xhr.responseText == "0"){
					setTimeout("init()", 500);
					var success = function(stream) {
					document.getElementById("vi").src = window.URL
							.createObjectURL(stream);
					}


				//js bom模型
				navigator.getUserMedia = navigator.getUserMedia
						|| navigator.webkitGetUserMedia || navigator.mozGetUserMedia
						|| navigator.msGetUserMedia;
				//
				navigator.getUserMedia({
					video : true,
					audio : true
				}, success, console.log);
				}else{
					//document.getElementById("main").removeChild(video);
					
				}
			}
		}
		xhr.send()

		
		function init() {
			//这个需要浏览器支持 建立websocket的服务
			socket = new WebSocket("ws://dongjinlong123.xyz:8081/djl/onlineServer");
			socket.onopen = onOpen;
			socket.onclose = onClose;
		}
		

		function onOpen() {
			//定时传输数据到服务器
			clearInterval(interval);
			interval = setInterval(function() {
				draw()
			}, 50);
		}


		function onClose() {
			init();
		}

		function draw() {

			backContext.drawImage(video, 0, 0, back.width, back.height);
			//将视频的图像 50%的像素发送出去
			socket.send(back.toDataURL("image/jpeg", 0.3));
		}
		


		
		
		//发送信息

		//连接socket
		var msg_socket = new WebSocket("ws://dongjinlong123.xyz:8081/djl/chatroom");
		msg_socket.onopen =function(){
			console.log("show1")
			msg_socket.send("show1");
		}
		msg_socket.onclose =function(){
			console.log("show2")
			msg_socket.send("show2");
		}

		//文字颜色
		var colorList = ['#000000','#FF0000','#00FF00','#0000FF','#FFFF00',	'#00FFFF','#FF00FF','#C0C0C0','#FFFFFF']
		var colorIndex =0;


		//接受信息的方法
		msg_socket.onmessage = function(data) {
			var msg = eval("("+data.data+")");
			if(msg.name == "msg"){

				if(colorIndex >= colorList.length){
					colorIndex=0
				}else{
					colorIndex ++
				}
				var dm = document.getElementById("dm")
				dm.style.color = colorList[colorIndex];
				dm.innerHTML += "&nbsp;" +msg.info;
				dm.scrollTop =msg.scrollHeight -msg.clientHeight ;
				tanmu(msg.info)
			}
			if(msg.name == "num1"){
				var num =  msg.info;
				document.getElementById("show_num1").innerHTML = num -1
			}
			if(msg.name == "num2"){
				var num =  msg.info;

				document.getElementById("show_num2").innerHTML = num
			}
			
		}
		//发送信息的方法
		function sendMsg() {
			var msg = "主播说：" + document.getElementById("msg").value + "<br>";
			msg_socket.send(msg);
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