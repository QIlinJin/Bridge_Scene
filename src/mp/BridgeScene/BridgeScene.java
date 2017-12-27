package mp.BridgeScene;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.BridgeScene_Composite_Interfaces.Avatar;
import mp.BridgeScene_Composite_Interfaces.Gorge;
import mp.BridgeScene_Composite_Interfaces.StandingPlace;
import util.annotations.Tags;

@Tags ({"BridgeScene"})
public interface BridgeScene {
	public Avatar getArthur();
	public Avatar getLancelot();
	public Avatar getRobin();
	public Avatar getGalahad();
	public Avatar getGuard();
	public void rotateArthursArms(int unit);
	public void scale(double x);
	public Gorge getGorge();
	public StandingPlace getKnightArea();
	public StandingPlace getGuardArea();
	public void say(String s);
	public void approach(Avatar a);
	public void animate();
	public void addPropertyChangeListener(PropertyChangeListener l);
	public void notifyAllListeners(PropertyChangeEvent event);
	public void passed();
	public void failed();
	public boolean getOccupied();
	public boolean getKnightTurn();
}

