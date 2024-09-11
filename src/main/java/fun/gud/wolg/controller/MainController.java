/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.controller;

import fun.gud.wolg.configuration.Config;
import fun.gud.wolg.stub.InMemoryStorage;
import fun.gud.wolg.util.DateOperations;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init(); 
        this.getServletConfig().getServletContext().setAttribute("inMemoryStorage", new InMemoryStorage());
        this.getServletConfig().getServletContext().setAttribute("configuration", new Config());
        this.getServletConfig().getServletContext().setAttribute("DateOperations", new DateOperations());
    }
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    
    
    
}
