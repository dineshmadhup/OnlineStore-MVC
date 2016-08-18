function ValidateUsername(){
    var text = document.getElementById("username").value;
    if(text==""){
        document.getElementById("errorusername").innerHTML = "Please Enter Username";
        document.getElementById("errorusername").style.color = "red";
    }
    else if (text == "guest"){
        document.getElementById("errorusername").innerHTML = "Guest doens't need login";
        document.getElementById("errorusername").style.color = "blue";
    }
    else{
        document.getElementById("errorusername").innerHTML = "Valid";
        document.getElementById("errorusername").style.color = "green";
    }
}

function ValidatePassword(){
    var text = document.getElementById("pass").value;
    if(text==""){
        document.getElementById("errorpassword").innerHTML = "Please Enter Password";
        document.getElementById("errorpassword").style.color = "red";
    }
    else{
        document.getElementById("errorpassword").innerHTML = "Valid"
        document.getElementById("errorpassword").style.color = "green";
    }

}

