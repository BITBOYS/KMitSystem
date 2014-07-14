package com.kmitsystem.servlets.user;

import com.kmitsystem.services.user.input.SignInInput;
import com.kmitsystem.services.user.UserServiceProvider;
import com.kmitsystem.services.user.result.SignInResult;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malte
 */
public class SignInServlet extends HttpServlet {

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
        RequestDispatcher rd;
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        User user = request.getSession().getAttribute("user");
        
        // check if the user filled the form
        if(email != null && password != null) {
        
            UserServiceProvider provider = new UserServiceProvider();
            SignInInput input = new SignInInput(email, password);

            SignInResult result = provider.signInUser(input);
        
            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
                // redirect to the page www.kmitsystem.de/login
                rd = request.getRequestDispatcher("/WEB-INF/login/index.jsp");
                rd.include(request, response);
            } else {
                // write the user into the session
                request.getSession().setAttribute("user", result.getUser());
                // redirect to the page www.kmitsystem.de/user/dashboard
                response.sendRedirect(request.getContextPath() + "/user/profile?user=" + result.getUser().getUsername());
            }
            
        } else {
            rd = request.getRequestDispatcher("/WEB-INF/login/index.jsp");
            rd.include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
