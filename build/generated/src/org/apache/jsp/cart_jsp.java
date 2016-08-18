package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import business.order;
import business.product;
import business.cart;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import servlet.DatabaseConnection;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Shopping cart</title>\n");
      out.write("    <link href=\"mycss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"banner\" >\n");
      out.write("            <a href=\"product.jsp\"><img src=\"img/gobble.jpg\" alt=\"gobble banner\" width=\"800\" /></a>\n");
      out.write("        </div>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"product.jsp\">Products</a></li>\n");
      out.write("                <li><a href=\"cart.jsp\">Shopping Carts</a></li>\n");
      out.write("                 <li><a href=\"contactus.html\">Contact Us</a></li>\n");
      out.write("                <li><a href=\"aboutus.html\">About Us</a></li>  \n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <h1>Your shopping cart</h1>\n");
      out.write("        ");

            String user = (String)session.getAttribute("user");
            cart shopping_cart = (cart) session.getAttribute("cart");
            
            if(shopping_cart == null ||
                    user == null || 
                    user.equalsIgnoreCase("guest")){
        
      out.write("\n");
      out.write("                <h1>you have to login first</h1>\n");
      out.write("        ");
      
            }
            else {
                for(order od : shopping_cart.getOrders()){
                    product p = od.getP();                
        
      out.write("\n");
      out.write("        \n");
      out.write("        <table >\n");
      out.write("            <thead>\n");
      out.write("                <th></th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th></th>\n");
      out.write("                <th></th>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
            
                
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><img src=\"");
      out.print(p.getLink());
      out.write("\" alt=\"No image\"/></td>\n");
      out.write("                    <td width=\"160px\">");
      out.print(p.getName());
      out.write("</td>\n");
      out.write("                    <td >$");
      out.print(p.getPrice());
      out.write("</td>\n");
      out.write("                    <td align='center'>");
      out.print(od.getQuantity());
      out.write("</td>                    \n");
      out.write("                    <td><form  action=\"RemoveOrder\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"orderID\" value=\"");
      out.print(p.getId());
      out.write("\" />\n");
      out.write("                            <input type=\"submit\" value=\"Remove\" />   \n");
      out.write("                        </form>   \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form  action=\"EditOrder.jsp\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"orderID\" value=\"");
      out.print(p.getId());
      out.write("\" />\n");
      out.write("                            <input type=\"submit\" value=\"Edit\" />   \n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>           \n");
      out.write("           \n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("            ");

            }          
            
      out.write("\n");
      out.write("                <form  action=\"PaymentOption.jsp\" method=\"POST\">\n");
      out.write("                    <input type=\"submit\" value=\"Checkout\" />   \n");
      out.write("                </form>\n");
      out.write("            ");

                }
            
            
      out.write("\n");
      out.write("            <hr>\n");
      out.write("        <div id=\"footer\">Copyright &copy; 2014 Dinesh<br />\n");
      out.write("        Last Updated on 11/25/14\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
