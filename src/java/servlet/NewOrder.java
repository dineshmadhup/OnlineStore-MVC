package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import business.cart;
import business.product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.eclipse.jdt.internal.compiler.lookup.TypeIds;

/**
 *
 * @author Dinesh
 */
public class NewOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();  
        PrintWriter out = response.getWriter();
        
        
        try {
            /* TODO output your page here. You may use following sample code. */
            
            String user = (String) session.getAttribute("user");  
            int id = Integer.parseInt(request.getParameter("product_id"));
            double price = Double.parseDouble(request.getParameter("price"));
            String name = request.getParameter("name");
            String link = request.getParameter("link");
            
            cart shopping_cart = (cart) session.getAttribute("cart");
            
            
            boolean invalid = false;
            
            if (shopping_cart == null ||
                    user == null || 
                    user.equalsIgnoreCase("guest")) {
                invalid = true;
            }else{
                shopping_cart.add(new product(id, name, link, price));
                session.setAttribute("cart", shopping_cart);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewOrder</title>");            
            out.println("<link href=\"mycss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"    </head>    \n" +
"    <body>\n" +
"        <div class=\"banner\" >\n" +
"            <a href=\"product.jsp\"><img src=\"img/gobble.jpg\" alt=\"gobble banner\" width=\"800\" /></a>\n" +
"        </div>\n" +
"        <nav>\n" +
"            <ul>\n" +
"                <li><a href=\"index.jsp\">Home</a></li>\n" +
"                <li><a href=\"product.jsp\">Products</a></li>\n" +
"                <li><a href=\"cart.jsp\">Shopping Carts</a></li>\n" +
"                 <li><a href=\"contactus.html\">Contact Us</a></li>\n" +
"                <li><a href=\"aboutus.html\">About Us</a></li>  \n" +
"            </ul>\n" +
"        </nav>");            
                        
            if (invalid) {
                out.println(" <h1>You haven't got any permission to order product  </h1> ");                
            } else  {
                out.println(" <h1>Your order has been added</h1> ");
            }          
            out.println("<hr>\n" +
"        <div id=\"footer\">Copyright &copy; 2014 Dinesh<br />\n" +
"        Last Updated on 11/25/14\n" +
"        </div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e){
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
