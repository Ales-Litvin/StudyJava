package javarush.task.task37.task3709;

import javarush.task.task37.task3709.connectors.Connector;
import javarush.task.task37.task3709.connectors.SecurityProxyConnector;
import javarush.task.task37.task3709.connectors.SimpleConnector;

/*
Security Proxy
*/
public class Solution {
    public static void main(String[] args) {
        Connector securityProxyConnector = new SecurityProxyConnector("google.com");
        Connector simpleConnector = new SimpleConnector("javarush.ru");


        System.out.println("Connecting with SimpleConnector...");
        simpleConnector.connect();

        System.out.println("----------------------------------------------------");

        System.out.println("Connecting with SecurityProxyConnector...");
        securityProxyConnector.connect();
    }
}