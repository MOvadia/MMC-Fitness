var refreshRate = 2000; //milli seconds
var from_glob;
var to_glob;
var USER_LIST_URL = buildUrlWithContextPath("userslist");
var CHAT_STRING_URL = buildUrlWithContextPath("chatString");


function startChatClicked(from,to) {
    document.getElementById("send-msg").style.display = "block";
    document.getElementById("send-msg").style.display = "table";

    document.getElementById("content").style.display = "block";
    var X = document.getElementsByClassName("btn btn-primary send");
    for (let x of X) {
        x.parentNode.removeChild(x);
    }
    from_glob = from;
    to_glob=to;
    $.ajax
    (
        {
            url:"/alert/chat" ,
            data: {
                userId: from,
                chatId: to
            },
            type: 'GET',
            success: function(chat) {

                var chatTable = $('#chat-table tbody');
                var chatTablehead = $('#chat-table thead');
                var form =$('#send-msg');

                var btn = document.createElement('input');
                btn.setAttribute('type', 'button');
                btn.setAttribute('id', 'sendButton'+to);
                btn.setAttribute('class', 'btn btn-primary send');
                btn.setAttribute('value', 'send');
                btn.setAttribute('onclick', 'sendClicked('+from+','+to+')');

               // var x = document.createElement("INPUT");
              //  x.setAttribute("type", "text");

                var sendTD = $(document.createElement('td')).attr('id', 'sendTd').append(btn);

               // var inputElem = document.getElementById('userstring');
                //var TD_send = document.getElementById('userstring');

               // sendTD.appendChild(inputElem);

                sendTD.appendTo(form);
                document.getElementById("sendTd").style.marginLeft = "340px";
                chatTablehead.empty();
                chatTable.empty();
                var chatList = chat;
                var trType = $(document.createElement('tr'));
                var thType = $(document.createElement('th')).text(chat[0].title);
                thType.appendTo(trType);
                trType.appendTo(chatTablehead);

                chatList.forEach(function (chat) {

                    var tr = $(document.createElement('tr'));

                    var tdName = $(document.createElement('td')).text(chat.content);
                    tdName.appendTo(tr);

                    tr.appendTo(chatTable);

                });
            }
        }
    );

    setInterval(ajaxChatString, refreshRate);

}

function sendClicked(from,to) {
    var msg = document.getElementById("userstring").value;

    $.ajax
    (
        {
            url:"/alert/send" ,
            data: {
                userId: from,
                chatId: to,
                chatString: msg
            },
            type: 'GET',
            success: function(chat) {
                var chatTable = $('#chat-table tbody');
                var chatTablehead = $('#chat-table thead');
                const msgInput = document.getElementById('userstring');
                msgInput.value = '';
                chatTable.empty();
                chatTablehead.empty();
                var chatList = chat;
                var trType = $(document.createElement('tr'));
                var thType = $(document.createElement('th')).text(chat[0].title);
                thType.appendTo(trType);
                trType.appendTo(chatTablehead);

                chatList.forEach(function (chat) {

                    var tr = $(document.createElement('tr'));

                    var tdName = $(document.createElement('td')).text(chat.content);

                    tdName.appendTo(tr);
                    tr.appendTo(chatTable);

                });
            }
        }
    );
}


function refreshUsersList(users,myId) {
    var usersTable = $('#usersTable tbody');
    usersTable.empty();
    var userList = users;
    userList.forEach(function (user) {
        if(user.userId != myId) {
            var name = user.fullName;
            var type = user.type;

            var tr = $(document.createElement('tr'));

            var tdName = $(document.createElement('td')).text(name);
            var tdType = $(document.createElement('td')).text(type);

            tdName.appendTo(tr);
            tdType.appendTo(tr);

            var form = document.createElement('form');
            form.setAttribute('th:method', 'post');
            form.setAttribute('class', 'usersForm');
            var formBtn = $(document.createElement('td')).append(form);

            var btn = document.createElement('input');
            btn.setAttribute('type', 'button');
            btn.setAttribute('id', 'submitButton');
            btn.setAttribute('class', 'btn btn-primary');
            btn.setAttribute('value', 'chat');
            btn.setAttribute('onclick', 'startChatClicked(' + myId + ',' + user.userId + ')');

            var chat = $(document.createElement('td')).append(btn);

            chat.appendTo(formBtn);

            formBtn.appendTo(tr);
            tr.appendTo(usersTable);
        }

    });
}

function ajaxUsersList() {
    $.ajax({
        type: 'POST',
        url: USER_LIST_URL,
        contentType: 'text/plain',
        crossDomain: false,
        async:true,
        success: function(users) {
            var url = window.location.href;
            const lastSegment = url.split("/").pop();
            const myId = url.split("=").pop();
            refreshUsersList(users,myId);
        }});
}

function ajaxChatString() {
    $.ajax({
        type: 'GET',
        url: CHAT_STRING_URL,
        contentType: 'text/plain',
        data: {
            userId: from_glob,
            chatId: to_glob,
        },
        crossDomain: false,
        async:true,
        success: function(strings) {
            var chatTable = $('#chat-table tbody');
            chatTable.empty();
            var chatList = strings;

            chatList.forEach(function (chat) {

                var tr = $(document.createElement('tr'));

                var tdName = $(document.createElement('td')).text(chat.content);

                tdName.appendTo(tr);

                tr.appendTo(chatTable);

            });
        }
    });
}

//activate the timer calls after the page is loaded
$(function() {
    //The users list is refreshed automatically every second
    setInterval(ajaxUsersList, refreshRate);
});