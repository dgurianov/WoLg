/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.stub;

import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author Danylo
 */
public class TestInMemoryStorage {
    
    
    @Test
    public void storageAcceptsNewValue(){
        String value1 = null;
        String value2 = null;
        String value3 = null;
        int id  = 1;
        
        InMemoryStorage im = new InMemoryStorage();
        Assert.assertTrue(im.addRecord(value1, value2, value3));
        
        
        
    }
}
