/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.entity;

/**
 *
 * @author Danylo
 */
public class LogRecord {

    
    
    private int id ;
    private String startTime ;
    private String endTime ;
    private String deltaTime ;
    private String actionDone ; 

    public LogRecord() {
    }

    public LogRecord(int id, String startTime, String endTime, String actionDone) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.actionDone = actionDone;
        this.deltaTime = "0";
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActionDone() {
        return actionDone;
    }

    public void setActionDone(String actionDone) {
        this.actionDone = actionDone;
    }
    
    @Override
    public String toString() {
        return getId()+"|"+getStartTime()+"|"+getEndTime()+"|"+getDeltaTime()+"|"+getActionDone();
    }

    public String getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(String deltaTime) {
        this.deltaTime = deltaTime;
    }
    
}
