/*
CS2524: DISTRIBUTED SYSTEMS AND SECURITY 
ASSESSMENT MUD GAME 
WRITTEN BY BRADLEY SCOTT 
B.SCOTT.16@ABERDEEN.AC.UK
STUDENT ID: 51661169



*/


package cs3524.solutions.mud;

import java.rmi.Naming;
import java.lang.SecurityManager;
import java.net.InetAddress;
import java.rmi.server.UnicastRemoteObject;

/*
command to run me:

java cs3524.solutions.mud.MUDserver 50010 50011
java cs3524.solutions.mud.MUDserver <registry port> <server port>

*/


public class MUDserver
{
    public static void main(String args[])
    {
	if (args.length < 2) {
	    System.err.println( "Usage:\njava mudserver <registryport> <serverport>" ) ;
	    return;
	}

	try {
	    String hostname = (InetAddress.getLocalHost()).getCanonicalHostName() ;
	    int registryport = Integer.parseInt( args[0] ) ;
	    int serverport = Integer.parseInt( args[1] ) ;
    
        System.out.println("server created on port " + Integer.toString(registryport));
        

	    System.setProperty( "java.security.policy", "mud.policy" ) ;
	    System.setSecurityManager( new SecurityManager() ) ;

	  

		//create new instance of MUDServiceImplementation 

		MUDServiceImplementation MUDservice = new MUDServiceImplementation();
		
		//create new stub for MUD service interface
		MUDinterface stub = (MUDinterface)UnicastRemoteObject.exportObject(MUDservice, serverport);
		
		//building the url
        Naming.rebind( "rmi://" + hostname + ":" + registryport + "/Mudservice", stub );


		
        System.out.println("Host name: " + hostname);
		System.out.println("Server Port: " + serverport);
        System.out.println("Registry Port: " + registryport);

	   //call service method that creates new MUD instance for first MUD on server 
	   
		MUDservice.makeMUD("default");


	}
	catch(java.net.UnknownHostException e) {
	    System.err.println( "java can't find the localhost!" );
	}
	catch (java.io.IOException e) {
            System.out.println( "failed to register." );
        }
    }
}

