<%-- 
    Document   : CardInfor
    Created on : Nov 26, 2014, 4:14:49 PM
    Author     : Dinesh
--%>

<%@page import="business.cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Card Information</title>
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
            cart shopping_cart = (cart) session.getAttribute("cart");
                if (shopping_cart == null ||
                        user == null ||
                        user.equalsIgnoreCase("guest")){
                response.setStatus(response.SC_MOVED_TEMPORARILY);
               response.setHeader("Location", "index.jsp"); 
            }
        %>
        <p>
            Enter your card and shipping address information: 
        </p>
        <form action="Checkout.jsp" method="POST">
            <table border="0">
                <tbody>                    
                    <tr>
                        <th>Name on card</th>
                        <th>Card number</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><input type="text" name="name" value="" /></td>
                        <td><input type="text" name="number" value="" size="20" /></td>
                        <td><input type="submit" value="Pay" /></td>
                    </tr>
                    <tr>
                        <th>
                            Shipping address
                        </th>
                        <th></th>
                        <th></th>                        
                    </tr>
                    <tr>
                        <td colspan="3" >
                            <input type="text" name="address" value=""  size="60" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        <hr>
        <div id="footer">Copyright &copy; 2014 Dinesh<br />
        Last Updated on 11/25/14
        </div>
    </body>
</html>
