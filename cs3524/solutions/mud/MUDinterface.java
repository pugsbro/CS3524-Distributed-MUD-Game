/*
CS2524: DISTRIBUTED SYSTEMS AND SECURITY 
ASSESSMENT MUD GAME 
WRITTEN BY BRADLEY SCOTT 
B.SCOTT.16@ABERDEEN.AC.UK
STUDENT ID: 51661169



*/
package cs3524.solutions.mud;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MUDinterface extends Remote
{   



    
    public void makeMUD(String mudName) throws RemoteException;
    public String pickMUD(String inputMud) throws RemoteException;
    public String welcome() throws RemoteException;
    public String myStartLocation() throws RemoteException;
    public void addThing( String loc,String thing ) throws RemoteException;
    public String moveThing( String loc, String dir, String thing ) throws RemoteException;
    public String locationInfo( String loc ) throws RemoteException;
    public boolean take(String item, String location) throws RemoteException ;
    public String ItemsAtLocation( String loc ) throws RemoteException;
    public void removeUser(String auser) throws RemoteException;
    public void addUser(String auser) throws RemoteException;
    public String whoIsonline() throws RemoteException;
    public void delThing( String loc, String thing ) throws RemoteException;
}