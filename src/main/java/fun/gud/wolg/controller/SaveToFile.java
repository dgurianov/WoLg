/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.controller;

import fun.gud.wolg.entity.LogRecord;
import fun.gud.wolg.stub.InMemoryStorage;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveToFile extends HttpServlet{

    private InMemoryStorage storage ;
    private String outputFile ;
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        storage = (InMemoryStorage) req.getServletContext().getAttribute("inMemoryStorage");
        if (storage.getAllRecordsAsList().isEmpty()){
            resp.sendRedirect("index.jsp");
        }else {
            outputFile = req.getParameter("outputFile").replaceAll("^\"|\"$", "");
            FileWriter fw = new FileWriter(outputFile);
            fw.write("Num|Time start 	 |Time end 	 |Time delta 	|Task description\n");
            for (LogRecord lr : storage.getAllRecordsAsList()){
                if (lr.getId() < 10 ){
                    fw.write("0"+lr.toString()+"\n");
                }else {
                    fw.write(lr.toString()+"\n");
                }
            }
            fw.close();
            storage.cleanAll();
            storage.setIdCounter(0);
            resp.sendRedirect("index.jsp");
        }
    }
    
}
