package mp.BridgeScene_Composite;

import mp.BridgeScene_Atomic.ALine;
import mp.BridgeScene_Atomic_Interfaces.Line;
import mp.BridgeScene_Composite_Interfaces.Gorge;

public class AGorge implements Gorge {
	Line leftGorge;
	Line rightGorge;
	Line upBridge;
	Line downBridge;
	
	public AGorge() {
		leftGorge = new ALine(500,100,0,800);
		rightGorge = new ALine(700,100,0,800);
		upBridge = new ALine(500,300,200,0);
		downBridge = new ALine(500,330,200,0);
	}
	
	public Line getLeftGorge() {
		return leftGorge;
	}
	
	public Line getRightGorge() {
		return rightGorge;
	}
	public Line getUpBridge() {
		return upBridge;
	}
	public Line getDownBridge() {
		return downBridge;
	}
}
