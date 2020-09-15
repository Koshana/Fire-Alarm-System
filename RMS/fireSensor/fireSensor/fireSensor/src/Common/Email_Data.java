/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

/**
 *
 * @author Pasindu
 */
public class Email_Data {
    
        String email=null;
        String password=null;
        
        public Email_Data getdata(){
            Email_Data ed=new Email_Data();
            ed.email="firealarmsystemds@gmail.com";
            ed.password="sliitds12345";
            
            return ed;
        }
}
