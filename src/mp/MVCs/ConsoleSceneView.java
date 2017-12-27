package mp.MVCs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.BridgeScene.BridgeScene;
import mp.FactoryMethod.FactoryMethod;

public class ConsoleSceneView implements PropertyChangeListener{
	public ConsoleSceneView() {
		BridgeScene bs = FactoryMethod.getOrCreateBridgeScene();
		bs.getArthur().addPropertyChangeListener(this);
		bs.getGalahad().addPropertyChangeListener(this);
		bs.getGuard().addPropertyChangeListener(this);
		bs.getLancelot().addPropertyChangeListener(this);
		bs.getRobin().addPropertyChangeListener(this);
		bs.addPropertyChangeListener(this);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
		//System.out.println("666");
		
	}

}
