package main;

import java.awt.Component;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.BridgeScene.BridgeScene;
import mp.ClearanceManager.ClearanceManager;
import mp.CommandInterpreter.ACommandInterpreter;
import mp.CommandInterpreter.CommandInterpreter;
import mp.FactoryMethod.FactoryMethod;
import mp.MVCs.BridgeSceneController;
import mp.MVCs.ConsoleSceneView;

public class Assignment12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BridgeScene bs = FactoryMethod.getOrCreateBridgeScene();
		
		PropertyChangeListener ibsp = FactoryMethod.getOrCreateInheritingBridgeScenePainter();
		BridgeSceneController bsc = FactoryMethod.getOrCreateBridgeSceneController();
		
		JFrame frame = new JFrame("Cartesian Plane");
		frame.add((Component) ibsp);
		frame.setSize(300, 300);
		frame.setVisible(true);
		//bs.approach(bs.getArthur());
		ConsoleSceneView  csv = FactoryMethod.getOrCreateConsoleSceneView();
		
		ClearanceManager cl = FactoryMethod.getOrCreateBroadcastingClearanceManager();
		OEFrame editor2 = ObjectEditor.edit(cl);
		
		CommandInterpreter ci = new ACommandInterpreter(bs,FactoryMethod.getOrCreateScannerBean());
		OEFrame editor1 = ObjectEditor.edit(ci);
		
		//ci.asynchronousArthur();
		//ci.asynchronousGalahad();
		//ci.asynchronousLancelot();
		//ci.asynchronousRobin();
		
		//cl.waitForProceed();
		//ci.setCommand("");
	}

}
