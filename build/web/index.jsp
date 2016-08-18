<%-- 
    Document   : index
    Created on : Nov 25, 2014, 1:09:34 AM
    Author     : Dinesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Register &amp; Login &amp; Logout Page</title>
        <script src="myjavascript.js" type="text/javascript"></script>
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
    </head>    
    <body>
        <div class="banner" >
            <a href="product.jsp"><img src="img/gobble.jpg" alt="gobble banner" width="800" /></a>
        </div>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="product.jsp">Products</a></li>
                <li><a href="cart.jsp">Shopping Carts</a></li>
                 <li><a href="contactus.html">Contact Us</a></li>
                <li><a href="aboutus.html">About Us</a></li>  
            </ul>
        </nav>
        
        <% 
           // session.setAttribute("user", "guest");
            String u = (String)session.getAttribute("user");
            if(u == null || u.equalsIgnoreCase("guest")){
        %>        
        <h1>Login</h1>        
        
        <form action="ValidateLogin" method="POST" name="AdminLogin">
                <table>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" id="username" name="username"  onblur="ValidateUsername();"></td>
                        <td><label id="errorusername"></label></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" id="pass" name="pass" onblur="ValidatePassword();"></td>
                        <td><label id="errorpassword"></label></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="Register">
                        <input type="submit" name="submit" value="Login">
                        </td>
                        <td></td>
                    </tr>
                     <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
            </table>
    
        </form>
        <%
            }
            else{
        %>
        <h1>Logout</h1>        
        <form action="ValidateLogin" method="POST" name="AdminLogin">
            <input type="submit" name="submit" value="Logout">
        </form>
        <%
            }
        %>
        <hr>
        <div id="footer">Copyright &copy; 2014 Dinesh<br />
        Last Updated on 11/25/14
        </div>
    </body>
</html>
