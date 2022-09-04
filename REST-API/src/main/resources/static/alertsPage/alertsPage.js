var chatVersion = 0;
var refreshRate = 2000; //milli seconds
var USER_LIST_URL = buildUrlWithContextPath("userslist");
var CHAT_LIST_URL = buildUrlWithContextPath("userId={userId}&chat={chat}");

//entries = the added chat strings represented as a single string
function appendToChatArea(entries) {
//    $("#chatarea").children(".success").removeClass("success");

    // add the relevant entries
    $.each(entries || [], appendChatEntry);

    // handle the scroller to auto scroll to the end of the chat area
    var scroller = $("#chatarea");
    var height = scroller[0].scrollHeight - $(scroller).height();
    $(scroller).stop().animate({ scrollTop: height }, "slow");
}

function appendChatEntry(index, entry){
    var entryElement = createChatEntry(entry);
    $("#chatarea").append(entryElement).append("<br>");
}

function createChatEntry (entry){
    entry.chatString = entry.chatString.replace (":)", "<img class='smiley-image' src='../../common/images/smiley.png'/>");
    return $("<span class=\"success\">").append(entry.username + "> " + entry.chatString);
}


//call the server and get the chat version
//we also send it the current chat version so in case there was a change
//in the chat content, we will get the new string as well
function ajaxChatContent() {
    $.ajax({
        url: CHAT_LIST_URL,
        data: "chatversion=" + chatVersion,
        dataType: 'json',
        success: function(data) {
            /*
             data will arrive in the next form:
             {
                "entries": [
                    {
                        "chatString":"Hi",
                        "username":"bbb",
                        "time":1485548397514
                    },
                    {
                        "chatString":"Hello",
                        "username":"bbb",
                        "time":1485548397514
                    }
                ],
                "version":1
             }
             */
            console.log("Server chat version: " + data.version + ", Current chat version: " + chatVersion);
            if (data.version !== chatVersion) {
                chatVersion = data.version;
                appendToChatArea(data.entries);
            }
            triggerAjaxChatContent();
        },
        error: function(error) {
            triggerAjaxChatContent();
        }
    });
}

//add a method to the button in order to make that form use AJAX
//and not actually submit the form
$(function() { // onload...do
    //add a function to the submit event
    $("#chatform").submit(function() {
        $.ajax({
            data: $(this).serialize(),
            url: this.action,
            timeout: 2000,
            error: function() {
                console.error("Failed to submit");
            },
            success: function(r) {
                //do not add the user string to the chat area
                //since it's going to be retrieved from the server
                //$("#result h1").text(r);
            }
        });

        $("#userstring").val("");
        // by default - we'll always return false so it doesn't redirect the user.
        return false;
    });
});

function triggerAjaxChatContent() {
    setTimeout(ajaxChatContent, refreshRate);
}

function startChatClicked(from,to) {
    /*var name = getUserName();
    var tableId = val;
    var rows = document.getElementsByTagName("tbody")[0].rows;
    var creator = rows[tableId - 1].getElementsByTagName("td")[2].innerText;
    //sessionStorage.setItem("user", name);
    sessionStorage.setItem("xmlIndex", tableId);
*/
    document.getElementById("send-msg").style.display = "block";
    document.getElementById("content").style.display = "block";

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
                btn.setAttribute('class', 'btn btn-primary');
                btn.setAttribute('value', 'send');
                //btn.setAttribute('onclick', 'openChat(1,user.userId)');
                //var openChat = $(document.createElement('td')).append(btn);
                btn.setAttribute('onclick', 'sendClicked('+from+','+to+')');

                var sendTD = $(document.createElement('td')).append(btn);


                // btn.appendTo(form);
                sendTD.appendTo(form);
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


function refreshUsersList(users) {
    var usersTable = $('#usersTable tbody');
    usersTable.empty();
    var userList = users;
    var id =1;
    userList.forEach(function (user) {

        var name = user.fullName;
        var type = user.type;

        var tr = $(document.createElement('tr'));

        var tdName = $(document.createElement('td')).text(name);
        var tdType = $(document.createElement('td')).text(type);

        tdName.appendTo(tr);
        tdType.appendTo(tr);

        var form = document.createElement('form');
        form.setAttribute('th:action', '@{/alert/userId=1&chat=1}');
        form.setAttribute('th:method', 'post');
        form.setAttribute('th:object', '${usersChatForm}');
        form.setAttribute('class', 'usersForm');
        var formBtn = $(document.createElement('td')).append(form);

        var btn = document.createElement('input');
        btn.setAttribute('type', 'button');
        btn.setAttribute('id', 'submitButton');
        btn.setAttribute('class', 'btn btn-primary');
        btn.setAttribute('value', 'chat');
        //btn.setAttribute('onclick', 'openChat(1,user.userId)');
        //var openChat = $(document.createElement('td')).append(btn);
        btn.setAttribute('onclick', 'startChatClicked(1,'+user.userId+')');

        var chat = $(document.createElement('td')).append(btn);


        // btn.appendTo(form);
        chat.appendTo(formBtn);

        formBtn.appendTo(tr);
        tr.appendTo(usersTable);

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
          //  window.location = '/alert/userslist';
           // var users = document.getElementById('usersList');
            refreshUsersList(users);
        }});
}

//activate the timer calls after the page is loaded
$(function() {

    //The users list is refreshed automatically every second
    setInterval(ajaxUsersList, refreshRate);
});