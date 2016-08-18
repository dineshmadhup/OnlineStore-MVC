<%-- 
    Document   : Checkout
    Created on : Nov 26, 2014, 3:40:09 PM
    Author     : Dinesh
--%>

<%@page import="business.cart"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="data.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
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
            String user = (String) session.getAttribute("user");
            String address = request.getParameter("address");
            cart shopping_cart = (cart) session.getAttribute("cart");
                if (shopping_cart == null ||
                        user == null ||
                        user.equalsIgnoreCase("guest")){
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "index.jsp"); 
            }
            String name = request.getParameter("name");
            String number = request.getParameter("number");
             
            
            double cost = shopping_cart.getCost();
            
            if(name == null || name.isEmpty()){
        %>
                <h3>
                You have to enter the name on the card
                </h3>
        <%
            }else if (number == null || number.isEmpty()){
         %>
                <h3>
                You have to enter the number of the card
                </h3>
         <%
            }else if (address == null || address.isEmpty()){
         %>
                <h3>
                You have to enter the address where you like to received
                </h3>      
                
        <%       
            } else if(cost > 0){
        %>
            <h3>
                Your order has been successfully placed.  <br>
                The bill is $<%= cost%> <br>
                We will ship your order to the address below: <br>
                <%=address%>    <br>            
                Thank you
            </h3>
        <%
            shopping_cart.clear();
            }else{
        %>
            <h3>
                You haven't got any product in your shopping cart
            </h3>                                  
        <%    
            }
        %>
        
        <hr>
        <div id="footer">Copyright &copy; 2014 Dinesh<br />
        Last Updated on 11/25/14
        </div>
    </body>
</html>
