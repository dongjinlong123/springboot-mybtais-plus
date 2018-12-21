
function submitForm(){
	if(!checkUsername()){
		document.getElementById("username").focus();
		return;
	}	
	if(!checkMail()){
		document.getElementById("usermail").focus();
		return;
	}
	if(!checkTheme()){
		document.getElementById("usertheme").focus();
		return;
	}
	if(!checkCon()){
		document.getElementById("usercon").focus();
		return;
	}
	var username = document.getElementById("username").value
	var usermail = document.getElementById("usermail").value
	var usertheme = document.getElementById("usertheme").value
	var usercon = document.getElementById("usercon").value
	var data = {"name":username,"qq":usermail,"topic":usertheme,"value":usercon}
	var url = "../inserDemo"
	$.ajax({
        type: "post",
        url: url,
 
        data: data,
        success: function (data)
        {
        	document.getElementById("alterBox").style.setProperty("display","block");
        }
      
     });

	
}
function getMapBD(){
	window.location.href="map.html"
}


