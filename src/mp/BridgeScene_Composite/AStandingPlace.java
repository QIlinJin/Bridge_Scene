package mp.BridgeScene_Composite;

import mp.BridgeScene_Atomic.ALine;
import mp.BridgeScene_Atomic_Interfaces.Line;
import mp.BridgeScene_Composite_Interfaces.StandingPlace;

public class AStandingPlace implements StandingPlace {
	Line rightLine;
	Line leftLine;
	Line upLine;
	Line downLine;
	
	public AStandingPlace(int x, int y) {
		rightLine = new ALine(x+100,y,0,100);
		leftLine = new ALine(x,y,0,100);
		upLine = new ALine(x,y,100,0);
		downLine = new ALine(x,y+100,100,0);
	}
	
	@Override
	public Line getLeftLine() {
		// TODO Auto-generated method stub
		return leftLine;
	}

	@Override
	public Line getRightLine() {
		// TODO Auto-generated method stub
		return rightLine;
	}

	@Override
	public Line getUpLine() {
		// TODO Auto-generated method stub
		return upLine;
	}

	@Override
	public Line getDownLine() {
		// TODO Auto-generated method stub
		return downLine;
	}

}
