<%-- 
    Document   : EditOrder
    Created on : Nov 26, 2014, 2:54:48 PM
    Author     : Dinesh
--%>

<%@page import="business.product"%>
<%@page import="business.order"%>
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
        <title>Edit Order</title>
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
            try{                
                String user = (String) session.getAttribute("user");
                cart shopping_cart = (cart) session.getAttribute("cart");
                if (shopping_cart == null ||
                        user == null || 
                        user.equalsIgnoreCase("guest")){
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", "index.jsp"); 
                }         
                int id = Integer.parseInt(request.getParameter("orderID"));
                
                order od = shopping_cart.getOrder(id);
                
                if(od != null ){
                    product p = od.getP();
        %>
       
            
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <form  action="EditOrder" method="POST">
                        <td><img src="<%=p.getLink()%>" alt="No image"/></td>
                        <td width="160px"><%=p.getName()%></td>
                        <td >$<%=p.getPrice()%></td>
                        <td>
                            <input type="text" name="quantity" value="<%=od.getQuantity()%>" />
                        </td>
                        <td>
                            <input type="hidden" name="orderID" value="<%=p.getId()%>" />
                            <input type="submit" value="Update" />   
                 
                        </td>
                         </form>
                <td>
                     <form  action="RemoveOrder" method="POST">
                            <input type="hidden" name="orderID" value="<%=p.getId()%>" />
                            <input type="submit" value="Remove" />   
                        </form>   
                </td>
                        
                    </tr>
                </tbody>
            </table>
                
        <form  action="cart.jsp" >            
            <input type="submit" value="Back" />   
        </form> 
        <%
                } else{
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", "cart.jsp"); 
                }   
            }
            catch (Exception e){
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "cart.jsp"); 
            }
        %>
        <hr>
        <div id="footer">Copyright &copy; 2014 Dinesh<br />
        Last Updated on 11/25/14
        </div>
    </body>
</html>
