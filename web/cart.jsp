<%-- 
    Document   : cart
    Created on : Nov 26, 2014, 1:52:00 PM
    Author     : Dinesh
--%>

<%@page import="business.order"%>
<%@page import="business.product"%>
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
        <title>Shopping cart</title>
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
        <h1>Your shopping cart</h1>
        <%
            String user = (String)session.getAttribute("user");
            cart shopping_cart = (cart) session.getAttribute("cart");
            
            if(shopping_cart == null ||
                    user == null || 
                    user.equalsIgnoreCase("guest")){
        %>
                <h1>you have to login first</h1>
        <%      
            }
            else {
                for(order od : shopping_cart.getOrders()){
                    product p = od.getP();                
        %>
        
        <table >
            <thead>
                <th></th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th></th>
                <th></th>
            </thead>
            <tbody>
            <%            
                
            %>
                <tr>
                    <td><img src="<%=p.getLink()%>" alt="No image"/></td>
                    <td width="160px"><%=p.getName()%></td>
                    <td >$<%=p.getPrice()%></td>
                    <td align='center'><%=od.getQuantity()%></td>                    
                    <td><form  action="RemoveOrder" method="POST">
                            <input type="hidden" name="orderID" value="<%=p.getId()%>" />
                            <input type="submit" value="Remove" />   
                        </form>   
                    </td>
                    <td>
                        <form  action="EditOrder.jsp" method="POST">
                            <input type="hidden" name="orderID" value="<%=p.getId()%>" />
                            <input type="submit" value="Edit" />   
                        </form>
                    </td>
                </tr>           
           
            </tbody>
        </table>
            <%
            }          
            %>
                <form  action="PaymentOption.jsp" method="POST">
                    <input type="submit" value="Checkout" />   
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
