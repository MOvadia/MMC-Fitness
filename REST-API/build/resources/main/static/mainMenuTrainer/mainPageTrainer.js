var USER_NAME = buildUrlWithContextPath("LoggedInUserServlet")
window.onload = function ()
{

};



function urlMapping(userId, workoutId)
{
    $.ajax({
        type : "GET",
        url : "/MMC-Fitness/workout/" + userId.toString() + "/" + workoutId.toString()
    });
}
