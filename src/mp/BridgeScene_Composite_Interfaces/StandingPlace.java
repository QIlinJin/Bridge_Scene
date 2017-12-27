package mp.BridgeScene_Composite_Interfaces;

import mp.BridgeScene_Atomic_Interfaces.Line;

public interface StandingPlace {
	public Line getLeftLine();
	public Line getRightLine();
	public Line getUpLine();
	public Line getDownLine();
}
