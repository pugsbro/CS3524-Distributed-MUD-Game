/***********************************************************************
 * cs3524.solutions.mud.Edge
 ***********************************************************************/
/*
CS2524: DISTRIBUTED SYSTEMS AND SECURITY 
ASSESSMENT MUD GAME 
WRITTEN BY BRADLEY SCOTT 
B.SCOTT.16@ABERDEEN.AC.UK
STUDENT ID: 51661169



*/
package cs3524.solutions.mud;

// Represents an path in the MUD (an edge in a graph).
class Edge
{
    public Vertex _dest;   // Your destination if you walk down this path
    public String _view;   // What you see if you look down this path
    
    public Edge( Vertex d, String v )
    {
        _dest = d;
	_view = v;
    }
}

