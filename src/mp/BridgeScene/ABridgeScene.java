package mp.BridgeScene;
import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mp.BridgeScene_Atomic_Interfaces.StringShape;
import mp.BridgeScene_Composite.AAvatar;
import mp.BridgeScene_Composite.AGorge;
import mp.BridgeScene_Composite.AStandingPlace;
import mp.BridgeScene_Composite_Interfaces.Avatar;
import mp.BridgeScene_Composite_Interfaces.Gorge;
import mp.BridgeScene_Composite_Interfaces.StandingPlace;
import util.annotations.Tags;
import util.annotations.Visible;
import util.models.PropertyListenerRegisterer;

@Tags ({"BridgeScene"})
public class ABridgeScene implements BridgeScene, PropertyListenerRegisterer {

	Avatar Arthur;
	Avatar Lancelot;
	Avatar Robin;
	Avatar Galahad;
	Avatar Guard;
	Gorge TheGorge;
	StandingPlace KnightArea;
	StandingPlace GuardArea;
	@Visible (false)
	public boolean Occupied = false;
	@Visible (false)
	public boolean KnightTurn = false;
	
	Avatar InteractingKnight;
	
	public ABridgeScene() {
		Arthur = new AAvatar("arthur", 50,20);
		Lancelot = new AAvatar("lancelot", 100,20);
		Robin = new AAvatar("robin", 50,100);
		Galahad = new AAvatar("galahad", 100,100);
		Guard = new AAvatar("guard", 400,230);
		TheGorge = new AGorge();
		KnightArea = new AStandingPlace(200,200);
		GuardArea = new AStandingPlace(350,200);
	}
	
	@Override
	public Avatar getArthur() {
		// TODO Auto-generated method stub
		return Arthur;
	}

	@Override
	public Avatar getLancelot() {
		// TODO Auto-generated method stub
		return Lancelot;
	}

	@Override
	public Avatar getRobin() {
		// TODO Auto-generated method stub
		return Robin;
	}

	@Override
	public Avatar getGalahad() {
		// TODO Auto-generated method stub
		return Galahad;
	}

	@Override
	public Avatar getGuard() {
		// TODO Auto-generated method stub
		return Guard;
	}
	

	@Override
	public void rotateArthursArms(int unit) {
		// TODO Auto-generated method stub
		Arthur.rotatingArms(unit);
	}
	
	public void scale(double x) {
		Arthur.scale(x);
		Lancelot.scale(x);
		Robin.scale(x);
		Galahad.scale(x);
		Guard.scale(x);
		
	}
	
	public Gorge getGorge() {
		return TheGorge;
	}
	
	public StandingPlace getKnightArea() {
		return KnightArea;
	}
	
	public StandingPlace getGuardArea() {
		return GuardArea;
	}
	
	public boolean getOccupied() {
		return Occupied;
	}

	public boolean getKnightTurn() {
		return KnightTurn;
	}
	
	public boolean preApproach() {
		return (Occupied == false);
	}
	
	//need precondition
	public void approach(Avatar a) {
			assert preApproach();
			a.move(250-a.getBody().getX(),230-a.getBody().getY());
			Occupied = true;
			System.out.println("666"+Occupied);
			notifyAllListeners(new PropertyChangeEvent(this, "this", "approach",false));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "say",true));//wan
			//notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",true));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "failed",true));
			InteractingKnight = a;
			KnightTurn=false;
			//Occupied = true;
	}
	@Visible(false)
	public Avatar getInteractingKnight() {
		return InteractingKnight;
	}
	
	public boolean preSay() {
		return (Occupied == true);
	}
	
	
	
	public void say(String s) {
		assert preSay();
		if(KnightTurn==false) {
			
			Guard.getStringShape().setText(s);
			KnightTurn = true;
			notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",false));
			
			
		}
		else if(KnightTurn==true) {
			InteractingKnight.getStringShape().setText(s);
			KnightTurn = false;
			notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",true));
			
		}
		
	}
	
	public boolean prePassed() {
		return (Occupied==true && KnightTurn==false);
	}
	
	public void passed() {
		assert prePassed();
		InteractingKnight.move(400,50);
		Occupied=false;
		notifyAllListeners(new PropertyChangeEvent(this, "this", "approach",true));
		notifyAllListeners(new PropertyChangeEvent(this, "this", "say",false));
		//notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",false));
		notifyAllListeners(new PropertyChangeEvent(this, "this", "failed",false));
		KnightTurn=false;
		
	}
	
	public boolean preFailed() {
		return Occupied==true;
	}
	
	public void failed() {
		assert preFailed();
		if(KnightTurn==false) {
			InteractingKnight.move(300,100);
			Occupied = false;
			notifyAllListeners(new PropertyChangeEvent(this, "this", "approach",true));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "say",false));
			//notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",false));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "failed",false));
			//wanyiwan
			//KnightTurn=true;
			//notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",false));
		}
		else if(KnightTurn==true) {
			Guard.move(150,100);
			//wanyiwan
			KnightTurn=false;
			Occupied = false;
			notifyAllListeners(new PropertyChangeEvent(this, "this", "approach",true));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "say",false));
			//notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",false));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "failed",false));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "pass",true));
		}
		
	}
	@Tags ({"scroll"})
	public void scroll(int x, int y) {
		Arthur.move(-x, -y);
		Lancelot.move(-x, -y);
		Robin.move(-x, -y);
		Galahad.move(-x, -y);
		Guard.move(-x, -y);
		TheGorge.getDownBridge().setX(TheGorge.getDownBridge().getX()-x);
		TheGorge.getLeftGorge().setX(TheGorge.getLeftGorge().getX()-x);
		TheGorge.getRightGorge().setX(TheGorge.getRightGorge().getX()-x);
		TheGorge.getUpBridge().setX(TheGorge.getUpBridge().getX()-x);
		TheGorge.getDownBridge().setY(TheGorge.getDownBridge().getX()-y);
		TheGorge.getLeftGorge().setY(TheGorge.getLeftGorge().getX()-y);
		TheGorge.getRightGorge().setY(TheGorge.getRightGorge().getX()-y);
		TheGorge.getUpBridge().setY(TheGorge.getUpBridge().getX()-y);
		KnightArea.getDownLine().setX(KnightArea.getDownLine().getX()-x);
		KnightArea.getRightLine().setX(KnightArea.getRightLine().getX()-x);
		KnightArea.getLeftLine().setX(KnightArea.getLeftLine().getX()-x);
		KnightArea.getUpLine().setX(KnightArea.getUpLine().getX()-x);
		KnightArea.getDownLine().setY(KnightArea.getDownLine().getY()-y);
		KnightArea.getRightLine().setY(KnightArea.getRightLine().getY()-y);
		KnightArea.getLeftLine().setY(KnightArea.getLeftLine().getY()-y);
		KnightArea.getUpLine().setY(KnightArea.getUpLine().getY()-y);
		GuardArea.getDownLine().setX(GuardArea.getDownLine().getX()-x);
		GuardArea.getRightLine().setX(GuardArea.getRightLine().getX()-x);
		GuardArea.getLeftLine().setX(GuardArea.getLeftLine().getX()-x);
		GuardArea.getUpLine().setX(GuardArea.getUpLine().getX()-x);
		GuardArea.getDownLine().setY(GuardArea.getDownLine().getY()-y);
		GuardArea.getRightLine().setY(GuardArea.getRightLine().getY()-y);
		GuardArea.getLeftLine().setY(GuardArea.getLeftLine().getY()-y);
		GuardArea.getUpLine().setY(GuardArea.getUpLine().getY()-y);
		
	}
	public void animate() {
		Arthur.move(150, 150);
		Arthur.getStringShape().setText("LOL");
		Arthur.getArms().getLeftLine().rotate(6);
		Arthur.getArms().getRightLine().rotate(6);
		Arthur.getLegs().getLeftLine().rotate(6);
		Arthur.getLegs().getRightLine().rotate(6);
		
	}

	
	List<PropertyChangeListener> contents = new ArrayList<>();
	
	public void notifyAllListeners(PropertyChangeEvent event) {
		Iterator<PropertyChangeListener> it = contents.iterator();
		while(it.hasNext()) {
			it.next().propertyChange(event);
		}
		
		
	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener l) {
		// TODO Auto-generated method stub
		contents.add(l);
	}
	
}










