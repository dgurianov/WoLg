/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.stub;

import fun.gud.wolg.entity.LogRecord;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class InMemoryStorage {
    private final LinkedList<LogRecord> container ;
    private int idCounter;
    private boolean isTaskRunning;

    public InMemoryStorage() {
        container = new LinkedList();
        idCounter = 0;
        isTaskRunning = false;
    }
    
    public LinkedList<LogRecord> getAllRecordsAsList(){
        return container;
    }
    
    public LogRecord getLast(){
        try {
            return (LogRecord) container.getLast();
        }catch (NoSuchElementException e){
            return null;
        }
    }
    
    public boolean addRecord(String ts_start , String ts_end, String text) {
        return container.add(new LogRecord(++idCounter, ts_start, ts_end, text));
        
    }
    
    public boolean completeRecord(String ts_end) {
        ((LogRecord) container.getLast()).setEndTime(ts_end);
        return true;
    }
    
    public void cleanAll(){
        container.clear();
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }
    
    
    
}
