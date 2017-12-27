package mp.MVCs;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.BridgeScene.BridgeScene;
import mp.BridgeScene_Atomic.AImage;
import mp.BridgeScene_Atomic.ALine;
import mp.BridgeScene_Atomic.AStringShape;
import mp.BridgeScene_Atomic_Interfaces.Line;
import mp.BridgeScene_Atomic_Interfaces.StringShape;
import mp.FactoryMethod.FactoryMethod;
import util.annotations.Tags;

@Tags ({"InheritingBridgeScenePainter"})

public class InheritingBridgeScenePainter extends Component implements PropertyChangeListener{
	
	BridgeScene bs = FactoryMethod.getOrCreateBridgeScene();
	
	public InheritingBridgeScenePainter() {
		bs.getArthur().addPropertyChangeListener(this);
		bs.getGalahad().addPropertyChangeListener(this);
		bs.getGuard().addPropertyChangeListener(this);
		bs.getLancelot().addPropertyChangeListener(this);
		bs.getRobin().addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		draw(g, bs);
	}
	
	 public  void draw(Graphics g, BridgeScene bs) {
		 draw(g,bs.getArthur().getArms().getLeftLine());
		 draw(g,bs.getArthur().getArms().getRightLine());
		 draw(g,bs.getArthur().getBody());
		 draw(g,bs.getArthur().getHead());
		 draw(g,bs.getArthur().getLegs().getLeftLine());
		 draw(g,bs.getArthur().getLegs().getRightLine());
		 draw(g,bs.getArthur().getStringShape());
		 draw(g,bs.getGalahad().getArms().getLeftLine());
		 draw(g,bs.getGalahad().getArms().getRightLine());
		 draw(g,bs.getGalahad().getBody());
		 draw(g,bs.getGalahad().getHead());
		 draw(g,bs.getGalahad().getLegs().getLeftLine());
		 draw(g,bs.getGalahad().getLegs().getRightLine());
		 draw(g,bs.getGalahad().getStringShape());
		 draw(g,bs.getGuard().getArms().getLeftLine());
		 draw(g,bs.getGuard().getArms().getRightLine());
		 draw(g,bs.getGuard().getBody());
		 draw(g,bs.getGuard().getHead());
		 draw(g,bs.getGuard().getLegs().getLeftLine());
		 draw(g,bs.getGuard().getLegs().getRightLine());
		 draw(g,bs.getGuard().getStringShape());
		 draw(g,bs.getRobin().getArms().getLeftLine());
		 draw(g,bs.getRobin().getArms().getRightLine());
		 draw(g,bs.getRobin().getBody());
		 draw(g,bs.getRobin().getHead());
		 draw(g,bs.getRobin().getLegs().getLeftLine());
		 draw(g,bs.getRobin().getLegs().getRightLine());
		 draw(g,bs.getRobin().getStringShape());
		 draw(g,bs.getLancelot().getArms().getLeftLine());
		 draw(g,bs.getLancelot().getArms().getRightLine());
		 draw(g,bs.getLancelot().getBody());
		 draw(g,bs.getLancelot().getHead());
		 draw(g,bs.getLancelot().getLegs().getLeftLine());
		 draw(g,bs.getLancelot().getLegs().getRightLine());
		 draw(g,bs.getLancelot().getStringShape());
		 draw(g,bs.getGorge().getDownBridge());
		 draw(g,bs.getGorge().getLeftGorge());
		 draw(g,bs.getGorge().getRightGorge());
		 draw(g,bs.getGorge().getUpBridge());
		 draw(g,bs.getGuardArea().getDownLine());
		 draw(g,bs.getGuardArea().getLeftLine());
		 draw(g,bs.getGuardArea().getRightLine());
		 draw(g,bs.getGuardArea().getUpLine());
		 draw(g,bs.getKnightArea().getDownLine());
		 draw(g,bs.getKnightArea().getLeftLine());
		 draw(g,bs.getKnightArea().getRightLine());
		 draw(g,bs.getKnightArea().getUpLine());
	}
	
	 private void draw(Graphics g, mp.BridgeScene_Atomic_Interfaces.Image im) {
		// TODO Auto-generated method stub
		java.awt.Image img = Toolkit.getDefaultToolkit().getImage(im.getImageFileName());
		g.drawImage(img, im.getX(), im.getY(), im.getWidth(), im.getHeight(), this);
	}

	public  void draw(Graphics g, Line aLine) {
			
		g.drawLine(aLine.getX(), aLine.getY(), aLine.getX() + aLine.getWidth(), aLine.getY() + aLine.getHeight());		
	}
	 
	 public void draw(Graphics g, StringShape aLabel) {
		String s = aLabel.getText();
		g.drawString(s, aLabel.getX(), aLabel.getY());		
	}
	
	
	 
}
















