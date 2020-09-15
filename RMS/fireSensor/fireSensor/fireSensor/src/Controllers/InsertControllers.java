/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Common.httpJson;
import Models.Floor;
import Models.Room;
import Models.RoomHasSensors;
import Models.Sensor;
import firesensor.RMIInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InsertControllers {

    private static RMIInterface look_up;

    public InsertControllers() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 9999);
        look_up = (RMIInterface) reg.lookup("hi_server");
    }

    public int insertFloor(Floor floor) {

        String resp = new httpJson().jsonRequest("http://127.0.0.1:8000/api/newfloor?uid=" + floor.getUser() + "&no=" + floor.getNo());
        System.out.println(resp);
        System.out.println("----------------------------------------------------");
        if (resp != null) {
            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject responseObj = (JSONObject) jsonParser.parse(resp);
                System.out.println(responseObj.get("code"));
                if (Integer.parseInt(responseObj.get("code").toString()) == 1) {
                    JSONObject newsensor = (JSONObject) responseObj.get("floor");
                    return Integer.parseInt(newsensor.get("id").toString());
                } else {
                    System.out.println("Something wrong");
                }

            } catch (Exception e) {
                System.out.println("Server Exception: " + e);
            }
        }

        return 0;

    }

    public int insertRoom(Room room) {
//        System.out.println("https://code.techmogeen.com/api/newroom?uid="+room.getUser_id()+"fid="+room.getFloor_id()+"&no="+room.getRoom_no());
        String resp = new httpJson().jsonRequest("http://127.0.0.1:8000/api/newroom?uid="+room.getUser_id()+"&fid="+room.getFloor_id()+"&no="+room.getRoom_no());
        System.out.println(resp);
        System.out.println("----------------------------------------------------");
        if (resp != null) {
            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject responseObj = (JSONObject) jsonParser.parse(resp);
                System.out.println(responseObj.get("code"));
                if (Integer.parseInt(responseObj.get("code").toString()) == 1) {
                    JSONObject newsensor = (JSONObject) responseObj.get("floor");
                    return Integer.parseInt(newsensor.get("id").toString());
                } else {
                    System.out.println("Something wrong");
                }

            } catch (Exception e) {
                System.out.println("Server Exception: " + e);
            }
        }

        return 0;
    }

    public int insertSensor(Sensor sensor) {

        String resp = new httpJson().jsonRequest("\"http://127.0.0.1:8000/api/newsensor?uid=" + sensor.getUser_id() + "&param1=0&param2=0&name=" + sensor.getSensor_name() + "&detail=" + sensor.getSensor_description());
        System.out.println(resp);
        System.out.println("----------------------------------------------------");
        if (resp != null) {
            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject responseObj = (JSONObject) jsonParser.parse(resp);
                System.out.println(responseObj.get("code"));
                if (Integer.parseInt(responseObj.get("code").toString()) == 1) {
                    JSONObject newsensor = (JSONObject) responseObj.get("floor");
                    return Integer.parseInt(newsensor.get("id").toString());
                } else {
                    System.out.println("Something wrong");
                }

            } catch (Exception e) {
                System.out.println("Server Exception: " + e);
            }
        }

        return 0;

    }

    public int insertRoomHasSensor(RoomHasSensors rhs) {

        String resp = new httpJson().jsonRequest("\"http://127.0.0.1:8000/api/newroomhassensor?rid=" + rhs.getRoom_id() + "&fid=" + rhs.getSensor_id());
        System.out.println(resp);
        if (resp != null) {
            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject responseObj = (JSONObject) jsonParser.parse(resp);
                System.out.println(responseObj.get("code"));
                if (Integer.parseInt(responseObj.get("code").toString()) == 1) {
                    JSONObject newsensor = (JSONObject) responseObj.get("floor");
                    System.out.println(newsensor.get("id").toString());
                    return Integer.parseInt(newsensor.get("id").toString());
                } else {
                    System.out.println("Something wrong");
                }

            } catch (Exception e) {
                System.out.println("Server Exception: " + e);
            }
        }

        return 0;

    }

}
