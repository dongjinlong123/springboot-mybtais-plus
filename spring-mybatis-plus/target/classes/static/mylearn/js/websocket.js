var socket = new WebSocket("ws://localhost:8080/djl/testWebSocket");
socket.onopen = function () {
    console.log("连接服务器端成功");
    //socket.send("发送信息");
}
//onmessage 接受数据
socket.onmessage = function(evt) {
    var received_msg = evt.data;
    console.log("接收的数据:" + received_msg);

    $("#scroll_begin").text(received_msg);
    $("#scroll_end").text(received_msg);
}
// onclose 关闭连接
socket.onclose = function() {
    // 关闭 websocket
    console.log("连接已关闭...");
};
// onerror 产生异常
socket.onerror = function(evt) {
    var error_msg = evt.data;
    console.log("接收的数据:" + error_msg);

};