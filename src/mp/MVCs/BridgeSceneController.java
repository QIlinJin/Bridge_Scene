package mp.MVCs;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mp.BridgeScene.BridgeScene;
import mp.FactoryMethod.FactoryMethod;
import util.annotations.Tags;

@Tags ({"BridgeSceneController"})
public class BridgeSceneController implements KeyListener, MouseListener{

	Component ibsp;
	BridgeScene bs;
	Point p;
	boolean hasClicked = false;
	
	/*int arthurOriginalX = bs.getArthur().getArms().getLeftLine().getX();
	int arthurOriginalY = bs.getArthur().getArms().getLeftLine().getY();
	int galahadOriginalX = bs.getGalahad().getArms().getLeftLine().getX();
	int galahadOriginalY = bs.getGalahad().getArms().getLeftLine().getY();
	int lancelotOriginalX = bs.getLancelot().getArms().getLeftLine().getX();
	int lancelotOriginalY = bs.getLancelot().getArms().getLeftLine().getY();
	int robinOriginalX = bs.getRobin().getArms().getLeftLine().getX();
	int robinOriginalY = bs.getRobin().getArms().getLeftLine().getY();*/
	
	int arthurOriginalX = 20;
	int arthurOriginalY = 20;
	int galahadOriginalX = 120;
	int galahadOriginalY = 120;
	int lancelotOriginalX = 20;
	int lancelotOriginalY = 120;
	int robinOriginalX = 120;
	int robinOriginalY = 20;		
	
	public BridgeSceneController(Component IBSP) {
		bs = FactoryMethod.getOrCreateBridgeScene();
		ibsp = IBSP;
		ibsp.addKeyListener(this);
		ibsp.addMouseListener(this);
		ibsp.setFocusable(true);
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		p = e.getPoint();
		hasClicked = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(hasClicked == true) {
			char typedChar = e.getKeyChar();
			switch(typedChar) {
			case 'a' :
				bs.getArthur().move((int)p.getX()-arthurOriginalX,(int)p.getY()-arthurOriginalY);
			case 'g' :
				bs.getGalahad().move((int)p.getX()-galahadOriginalX, (int)p.getY()-galahadOriginalY);
			case 'l' :
				bs.getLancelot().move((int)p.getX()-lancelotOriginalX, (int)p.getY()-lancelotOriginalY);
			case 'r' :
				bs.getRobin().move((int)p.getX()-robinOriginalX, (int)p.getY()-robinOriginalY);
			case 'o' :
				bs.getArthur().move(arthurOriginalX-bs.getArthur().getArms().getLeftLine().getX(),arthurOriginalY-bs.getArthur().getArms().getLeftLine().getY());
				bs.getGalahad().move(galahadOriginalX-bs.getGalahad().getArms().getLeftLine().getX(),galahadOriginalY-bs.getGalahad().getArms().getLeftLine().getY());
				bs.getLancelot().move(lancelotOriginalX-bs.getLancelot().getArms().getLeftLine().getX(),lancelotOriginalY-bs.getLancelot().getArms().getLeftLine().getY());
				bs.getRobin().move(robinOriginalX-bs.getRobin().getArms().getLeftLine().getX(),robinOriginalY-bs.getRobin().getArms().getLeftLine().getY());
			}
		}
		hasClicked = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
