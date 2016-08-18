package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import business.cart;
import data.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dinesh
 */
public class ValidateLogin extends HttpServlet {

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
            HttpSession session = request.getSession();  
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String logging = request.getParameter("submit");
            
            ResultSet rs = null;
            boolean login = false;
            boolean logout = false;
            boolean register = false;
            if (logging != null && logging.equalsIgnoreCase("Login")) {
                login = true;
            }
            if (logging != null && logging.equalsIgnoreCase("Logout")) {
                logout = true;
            }
            if (logging != null && logging.equalsIgnoreCase("Register")) {
                register = true;
            }
            String sql;
            String username = request.getParameter("username");
            String password = request.getParameter("pass");             
            PreparedStatement ps;
            Connection conn;
            DatabaseConnection dc = new DatabaseConnection();
            conn = dc.connect();
            
            if (login) {// login
                sql = "select * from project where username=? and password=?";
                ps = conn.prepareStatement(sql);
                if (username == null || password == null) {
                   

                } else {
                    ps.setString(1, username);
                    ps.setString(2, password);
                    rs = dc.query(ps);
                }
            }
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidateLogin</title>");
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
            if (logout) {
                out.println(" <h2>You have logged out, you are guest user now </h2> ");
                session.setAttribute("user", "guest");
                session.setAttribute("cart", null);
            }
            else if (rs == null || username == null || password == null
                    ||username.isEmpty() || password.isEmpty()) {
                out.println(" <h2>You are loggging in as guest</h2> ");
                session.setAttribute("user", "guest");
                session.setAttribute("cart", null);
            } else if (rs.next()){
                out.println(" <h2>Login sucessfully</h2> ");
                session.setAttribute("user", username);
                session.setAttribute("cart", new cart());
            }else if (register){
                sql = "insert into project (username,password) values (?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                int row = 0;
                row = dc.update(ps);
                if (row > 0) {  
                    out.println(" <h2>Register &amp; Login sucessfully</h2> ");
                    session.setAttribute("user", username);
                    session.setAttribute("cart", new cart());
                } else {
                    out.println(" <h2> Register failed</h2> ");
                     out.println(" <h2>You are loggging in as guest</h2> ");
                    session.setAttribute("user", "guest");
                    session.setAttribute("cart", null);
                }
            }
            out.println("<hr>\n" +
"        <div id=\"footer\">Copyright &copy; 2014 Dinesh<br />\n" +
"        Last Updated on 11/25/14\n" +
"        </div>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(ValidateLogin.class.getName()).log(Level.SEVERE, null, ex);
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
