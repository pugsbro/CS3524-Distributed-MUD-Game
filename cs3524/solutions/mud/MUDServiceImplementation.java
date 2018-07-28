/*
CS2524: DISTRIBUTED SYSTEMS AND SECURITY 
ASSESSMENT MUD GAME 
WRITTEN BY BRADLEY SCOTT 
B.SCOTT.16@ABERDEEN.AC.UK
STUDENT ID: 51661169



*/


package cs3524.solutions.mud;

import java.rmi.*; 
import java.util.*;

import cs3524.solutions.mud.MUD;
import cs3524.solutions.mud.MUDinterface;

public class MUDServiceImplementation implements MUDinterface 
{
	private MUD mudInstance;
    public Map<String, MUD> MUDs = new HashMap<String, MUD>();
    //limits the number of muds that can be created
    
    public Integer mudlimit = 4;
    public Integer mudcount = 0;

    public MUDServiceImplementation() throws RemoteException
    {

    }


	public void makeMUD(String mudName) throws RemoteException 
    {
		try 
        {
			//try and make a mud instance
            if(mudcount == mudlimit)
            {
                System.out.println("max number of MUDS have been created.");
            }
            
            else
            {
                MUDs.put(mudName, new MUD("mymud.edg","mymud.msg","mymud.thg"));
                System.out.println("MUD " + mudName + " created");
                mudcount = mudcount + 1;
            }
		}
		
        catch (Exception ex) 
        {
			System.err.println("error creating mud: " + ex.getMessage()); 
		}

	}


    public String welcome() throws RemoteException
    {
        String output = "";
        output = ("\n Available MUDS are listed below: \n");
        
        for(Map.Entry<String, MUD> entry : MUDs.entrySet()) 
        {
            String key = entry.getKey();
            output += (key + "\n");
        }
        
        output += ("\n");
        output += ("please select a MUD to connect to > ");
        
        return output;
    }

    public String pickMUD(String inputMud) throws RemoteException 
    {
        
        String output = "";
        
        if(MUDs.containsKey(inputMud))
        {
            mudInstance = MUDs.get(inputMud);
            output = ( "welcome to mud server:" + inputMud + "\n" );
            output += ( "please enter a username >  " );
        }     else {
            output = "False"; 
        }   
        
        return output;    

    }

    public String myStartLocation() throws RemoteException 
    {
       
        return mudInstance.startLocation();
    }

    public void addThing( String loc,String thing ){
            mudInstance.addThing(loc, thing);
    }

    public String moveThing( String loc, String dir, String thing ){
            return mudInstance.moveThing(loc, dir, thing);

    }

    public String locationInfo( String loc ) {
            return mudInstance.locationInfo(loc);
    }

    public boolean take(String item, String location){
            return mudInstance.take(item, location);
    }

    public String ItemsAtLocation( String loc ){
            return mudInstance.ItemsAtLocation(loc);
    }

    public void addUser(String auser){
        mudInstance.addUser(auser);
    }

    public void removeUser(String auser){
        mudInstance.removeUser(auser);
    }

    public String whoIsonline(){
        return mudInstance.whoIsonline();
    }

    public void delThing( String loc, String thing ){
        mudInstance.delThing(loc, thing);
    }
            

    
}