package com.drrufus.lab1client;

import com.drrufus.lab1client.soap.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Application {
    
    private final static String ENDPOINT_URL = "http://localhost:8080/ws";
    private final static String SOAP_ACTION = "someTestHeader";
    private final static String[] READ_UPDATE_PARAMS = { "id", "login", "name", "email", "pass"};
    private final static String[] CREATE_PARAMS = { "login", "name", "email", "pass"};
    private final static String[] DELETE_PARAMS = { "id" };
    
    public static void main(String[] args) throws IOException {
    
        Map<String, String> paramsMap = new HashMap();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter operation name: ");
        String operation = br.readLine();
        System.out.println();
        
        switch (operation) {
            case "read":
                for (String param : READ_UPDATE_PARAMS) {
                    System.out.print(param + ": ");
                    String value = br.readLine();
                    System.out.println();
                    if (!value.isEmpty())
                        paramsMap.put(param, value);
                }
                Utils.callSoapWebService(ENDPOINT_URL, SOAP_ACTION, paramsMap, "getUserRequest");
                break;
                
            case "update":
                for (String param : READ_UPDATE_PARAMS) {
                    System.out.print(param + ": ");
                    String value = br.readLine();
                    System.out.println();
                    if (!value.isEmpty())
                        paramsMap.put(param, value);
                }
                Utils.callSoapWebService(ENDPOINT_URL, SOAP_ACTION, paramsMap, "updateUserRequest");
                break;
                
            case "create":
                for (String param : CREATE_PARAMS) {
                    System.out.print(param + ": ");
                    String value = br.readLine();
                    System.out.println();
                    if (!value.isEmpty())
                        paramsMap.put(param, value);
                }
                Utils.callSoapWebService(ENDPOINT_URL, SOAP_ACTION, paramsMap, "createUserRequest");
                break;
                
            case "delete":
                for (String param : DELETE_PARAMS) {
                    System.out.print(param + ": ");
                    String value = br.readLine();
                    System.out.println();
                    if (!value.isEmpty())
                        paramsMap.put(param, value);
                }
                Utils.callSoapWebService(ENDPOINT_URL, SOAP_ACTION, paramsMap, "deleteUserRequest");
                break;
                
            default:
                System.out.println("Unsupported operation");
        }
        
        
        
        
    }
}
