var USER_NAME = buildUrlWithContextPath("LoggedInUserServlet")
window.onload = function ()
{
    showUserName();
};

function showUserName() {
    //document.getElementById("userName").innerText = "Hello " + getUserName();
}

function getUserName() {
    var result;
    $.ajax
    ({
        async: false,
        url: USER_NAME,
        data: {
            action: "status"
        },
        type: 'GET',
        success: function (json) {
            result = json;
        }
    });
    return result;
}