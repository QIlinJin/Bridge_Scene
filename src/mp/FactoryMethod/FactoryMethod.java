package mp.FactoryMethod;

import mp.BridgeScene.ABridgeScene;
import mp.BridgeScene.BridgeScene;
import mp.ClearanceManager.ABroadcastingClearanceManager;
import mp.ClearanceManager.AClearanceManager;
import mp.ClearanceManager.BroadcastingClearanceManager;
import mp.ClearanceManager.ClearanceManager;
import mp.CommandInterpreter.ACommandInterpreter;
import mp.CommandInterpreter.CommandInterpreter;
import mp.MVCs.BridgeSceneController;
import mp.MVCs.ConsoleSceneView;
import mp.MVCs.InheritingBridgeScenePainter;
import mp.Parser.Parser;
import mp.Scanner.AScannerBean;
import mp.Scanner.ScannerBean;
import mp.Table.ATable;
import mp.Table.Table;
import util.annotations.Tags;

@Tags ({"SingletonsCreator"})
public class FactoryMethod {
	static ScannerBean scanner;
	@Tags({"scannerFactoryMethod"})
	public static ScannerBean getOrCreateScannerBean(){
	if (scanner == null) {
	scanner = new AScannerBean();
	}
	return scanner;
	}

	static BridgeScene BS;
	@Tags({"bridgeSceneFactoryMethod"})
	public static BridgeScene getOrCreateBridgeScene(){
	if (BS == null) {
	BS = new ABridgeScene();
	}
	return BS;
	}
	
	static CommandInterpreter ci;
	@Tags({"commandInterpreterFactoryMethod"})
	public static CommandInterpreter getOrCreateCommandInterpreter(){
		if (ci == null) {
			BS = new ABridgeScene();
			scanner = new AScannerBean();
			ci = new ACommandInterpreter(BS,FactoryMethod.getOrCreateScannerBean());
		}
		return ci;
		}
	
	static Table Tb;
	@Tags({"avatarTableFactoryMethod"})
	public static Table getOrCreateAvatarTable(){
	if (Tb == null) {
	Tb = new ATable();
	}
	return Tb;
	}
	static InheritingBridgeScenePainter ibsp;
	@Tags({"inheritingBridgeScenePainterFactoryMethod"})
	public static InheritingBridgeScenePainter getOrCreateInheritingBridgeScenePainter(){
		if (ibsp == null) {
		ibsp = new InheritingBridgeScenePainter();
		}
		return ibsp;
	}
	
	static BridgeSceneController bsc;
	@Tags({"bridgeSceneControllerFactoryMethod"})
	public static BridgeSceneController getOrCreateBridgeSceneController(){
		if (bsc == null) {
		bsc = new BridgeSceneController(FactoryMethod.getOrCreateInheritingBridgeScenePainter());
		}
		return bsc;
	}
	
	static ConsoleSceneView csv;
	@Tags({"consoleSceneViewFactoryMethod"})
	public static ConsoleSceneView getOrCreateConsoleSceneView(){
		if (csv == null) {
			csv = new ConsoleSceneView();
		}
		return csv;
	}
	
	static Parser p;
	@Tags({"parserFactoryMethod"})
	public static Parser getOrCreateParser() {
		if(p==null) {
			p = new Parser();
		}
		return p;
	}
	
	static BroadcastingClearanceManager singleton;
	@Tags({"broadcastingClearanceManagerFactoryMethod"})
	public static  BroadcastingClearanceManager getOrCreateBroadcastingClearanceManager() {
		if (singleton == null) {
			singleton = new ABroadcastingClearanceManager();
		}
		return singleton;
	}
	
	static Table<Runnable> environment;
	@Tags({"environmentFactoryMethod"})
	public static Table<Runnable> getOrCreateEnvironment(){
		if(environment == null) {
			environment = new ATable<>();
		}
		return environment;
	}
	
	/*static Table CI;
	@Tags({"avatarTableFactoryMethod"})
	public static Table getOrCreateAvatarTable(){
	if (Tb == null) {
	Tb = new ATable();
	}
	return Tb;
	}
	*/
	
}
