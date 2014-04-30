import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.io.*;
import java.util.*;

public class Jumper extends Actor {

    public Jumper () {// technically not even needed
        
    }
    
    public void act () {
	if (canMove () ) {
	    move ();
	}

	else {
	    turn ();
	}
    }

    public void move () {
        Grid<Actor> gr = getGrid();
	if (gr == null) {
	    return;
	}

	Location loc = getLocation();
	Location next = loc.getAdjacentLocation (getDirection());
	Location next2 = next.getAdjacentLocation(getDirection());
	if (gr.isValid(next2)) {
	    moveTo (next2);
	}
    }

    public void turn() {
	setDirection (getDirection () + Location.HALF_RIGHT);
    }

    public boolean canMove () {
	Grid<Actor> gr = getGrid();
	if (gr ==null) {
	    return false;
	}
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	Location next2= next.getAdjacentLocation(getDirection());

	if (!gr.isValid(next2)) {
	    return false;
	}
	Actor neighbor = gr.get(next2);
	return (neighbor == null);
    }
}
