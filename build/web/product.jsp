<%-- 
    Document   : product
    Created on : Nov 25, 2014, 2:28:06 AM
    Author     : Dinesh
--%>

<%@page import="data.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
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
        <h1>Product</h1>
        
        <%
            DatabaseConnection dc = new DatabaseConnection();
            Connection conn = dc.connect();
            String sql = "select id, name, link, price from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = null;
            rs = dc.query(ps);                       
        %>
        <table border="1" >
            
            <thead>
                <tr>
                    <th>Index</th>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    while(rs.next()){
                    
                %>
                <tr>
                    <td><%=rs.getString("id")%></td>
                    <td ><img src="<%=rs.getString("link")%>" alt="No image"/>
                    </td>
                    <td width="160px"><%=rs.getString("name")%></td>
                    <td >$<%=rs.getString("price")%></td>
                    <td ><form  action="NewOrder" method="POST">
                            <input type="hidden" name="price" value="<%=rs.getString("price")%>" />
                            <input type="hidden" name="name" value="<%=rs.getString("name")%>" />
                            <input type="hidden" name="link" value="<%=rs.getString("link")%>" />
                            <input type="hidden" name="product_id" value="<%=rs.getString("id")%>" />
                            <input type="submit" value="Add to Cart" />   
                        </form>                          
                    </td>
                </tr>  
                <%
                    }
                %>
            </tbody>
        </table> 
            <hr>
        <div id="footer">Copyright &copy; 2014 Dinesh<br />
        Last Updated on 11/25/14
        </div>
    </body>
</html>
