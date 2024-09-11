/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.controller;

import fun.gud.wolg.entity.LogRecord;
import fun.gud.wolg.stub.InMemoryStorage;
import fun.gud.wolg.util.DateOperations;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddActivity extends HttpServlet{
    private String formMessage ;
    private String timestamp ;
    private InMemoryStorage storage ;
    private boolean  isPending ;
    private DateOperations dateOps;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        storage = (InMemoryStorage) getServletContext().getAttribute("inMemoryStorage");
        dateOps = (DateOperations) getServletContext().getAttribute("DateOperations");
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       isPending = Boolean.valueOf( (String) getServletContext().getAttribute("isPending"));
       formMessage = req.getParameter("message");
       
       timestamp = dateOps.getTimestamp();
       
       if (isPending)  {
           storage.getLast().setEndTime(timestamp);
           if (!formMessage.isEmpty()){
                storage.getLast().setActionDone(formMessage);
           }
           storage.getLast().setDeltaTime( dateOps.delta(storage.getLast().getStartTime(), timestamp));

       }else {
           storage.addRecord(timestamp, "Pending...", formMessage);
           
       }

        for (LogRecord lr : storage.getAllRecordsAsList() ) {
            System.out.println(lr.getStartTime());
            System.out.println(lr.getEndTime());
            
        }
       
        resp.sendRedirect("index.jsp");
    }
    
    
    
}
