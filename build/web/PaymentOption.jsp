<%-- 
    Document   : PaymentOption
    Created on : Nov 26, 2014, 3:51:04 PM
    Author     : Dinesh
--%>

<%@page import="business.cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Option</title>
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
        <h2>
            How would you like to pay for your order
        </h2>
        <p>
            Al transaction are secure and encrypted. To learn more, please view our privacy policy  
        </p>
        <form action="CardInfor.jsp" method="POST">
            <table >                
                <tbody>
                    <tr>
                        <td><input type="radio" name="payment" value="online" checked="checked" /></td>
                        <td><img src="img/payment.jpg" alt="online payment" width="300" /></td>                
                    </tr>
                    <tr>
                        <td><input type="radio" name="payment" value="bank"  /></td>
                        <td>Bank Deposit</td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="payment" value="mo"  /></td>
                        <td>Money Order</td>
                    </tr>
                    <tr>
                        <td> </td>
                        <td> 
                            <input type="submit" value="Complete my purchase " />
                            or <a href="cart.jsp">cancel, return to store</a>
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
