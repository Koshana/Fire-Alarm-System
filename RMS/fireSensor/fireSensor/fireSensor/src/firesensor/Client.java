/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firesensor;

import Models.Floor;
import Models.User;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @author MYI
 */
public class Client {

    private static RMIInterface look_up;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        Client client = new Client();
        client.connectRemote();

    }

    private void connectRemote() throws RemoteException, NotBoundException {

        Registry reg = LocateRegistry.getRegistry("localhost", 9999);
        look_up =(RMIInterface) reg.lookup("hi_server");
        
        List<User> userList = look_up.allUser();
        
        for (User userListIterration : userList) {
            System.out.println("email : "+userListIterration.getEmail());
            System.out.println("username : "+userListIterration.getUsername());
            System.out.println("------------------------------------------------");
        }
        
        List<Floor> floorList = look_up.allFloor();
        
        for (Floor floor : floorList) {
            System.out.println(floor.id);
            System.out.println(floor.no);
            System.out.println(floor.user);
        }
       
    }

}
