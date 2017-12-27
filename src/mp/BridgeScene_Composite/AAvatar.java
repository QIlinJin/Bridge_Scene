package mp.BridgeScene_Composite;

import java.beans.PropertyChangeListener;

import mp.BridgeScene_Atomic.AImage;
import mp.BridgeScene_Atomic.ALine;
import mp.BridgeScene_Atomic.AStringShape;
import mp.BridgeScene_Atomic_Interfaces.Image;
import mp.BridgeScene_Atomic_Interfaces.Line;
import mp.BridgeScene_Atomic_Interfaces.StringShape;
import mp.BridgeScene_Composite_Interfaces.Angle;
import mp.BridgeScene_Composite_Interfaces.Avatar;
import util.annotations.Tags;
@Tags ({"Avatar"})
public class AAvatar implements Avatar {
	StringShape Text;
	Line Body;
	Image Head;
	Angle Arms;
	Angle Legs;
	
	int default_head_X = 20;
	int default_head_Y = 20;
	int default_Width = 10;
	int default_Height = 15;
	int default_Line_X = default_head_X+default_Width/2;
	int default_Line_Y = default_head_Y+default_Height;
	int default_Line_Width = 0;
	int default_Line_Height = 30;
	int default_Arms_X = default_Line_X;
	int default_Arms_Y = default_Line_Y;
	int default_Legs_X = default_Line_X;
	int default_Legs_Y = default_Line_Y+default_Line_Height;
	
	
	public AAvatar(String i) {
		
		Head = new AImage(i+".jpg", default_head_X, default_head_Y,
				default_Width, default_Height);
		Body = new ALine(default_Line_X, default_Line_Y, default_Line_Width, default_Line_Height);
		Arms = new AAngle(default_Arms_X, default_Arms_Y);
		Legs = new AAngle(default_Legs_X, default_Legs_Y);
		Text = new AStringShape(i,default_head_X+default_Width, default_head_Y = 20);
	}
	
	public AAvatar(String i, int x, int y) {
		Head = new AImage(i+".jpg", x-default_Width/2, y-default_Height,
				default_Width, default_Height);
		Body = new ALine(x, y, default_Line_Width, default_Line_Height);
		Arms = new AAngle(x, y);
		Legs = new AAngle(x, y+default_Line_Height);
		Text = new AStringShape(i,x+default_Width, y);
	}
	
	@Override
	public Line getBody() {
		// TODO Auto-generated method stub
		return Body;
	}
////////////////////////////////
	public void setString(String s) {
		this.getStringShape().setText(s);
	}
	/////////////////////////
	@Override
	public StringShape getStringShape() {
		// TODO Auto-generated method stub
		return Text;
	}

	@Override
	public Image getHead() {
		// TODO Auto-generated method stub
		return Head;
	}

	@Override
	public Angle getArms() {
		// TODO Auto-generated method stub
		return Arms;
	}

	@Override
	public Angle getLegs() {
		// TODO Auto-generated method stub
		return Legs;
	}
	@Tags ({"move"})
	public void move(int x, int y) {
		Head.setX(Head.getX()+x);
		Head.setY(Head.getY()+y);
		Body.setX(Body.getX()+x);
		Body.setY(Body.getY()+y);
		Arms.move(x,y);
		Legs.move(x, y);
		Text.setX(Text.getX()+x);
		Text.setY(Text.getY()+y);
	}
	
	public void rotatingArms(int unit) {
		Arms.getLeftLine().rotate(unit);
		Arms.getRightLine().rotate(unit);
	}
	@Tags ({"scale"})
	public void scale(double i) {
		default_Line_Height = (int)(i*this.default_Line_Height);
		default_Width = (int)(i*this.default_Width);
		default_Height = (int)(i*this.default_Height);
		Head.setX(Body.getX()-default_Width/2);
		Head.setY(Body.getY()-default_Height);
		Head.setWidth(default_Width);
		Head.setHeight(default_Height);
		
		Body.setHeight(default_Line_Height);
		Arms.getLeftLine().setHeight((int)(i*Arms.getLeftLine().getHeight()));
		Arms.getRightLine().setHeight((int)(i*Arms.getRightLine().getHeight()));
		Arms.getLeftLine().setWidth((int)(i*Arms.getLeftLine().getWidth()));
		Arms.getRightLine().setWidth((int)(i*Arms.getRightLine().getWidth()));
		Legs.getLeftLine().setHeight((int)(i*Legs.getLeftLine().getHeight()));
		Legs.getRightLine().setHeight((int)(i*Legs.getRightLine().getHeight()));
		Legs.getLeftLine().setWidth((int)(i*Legs.getLeftLine().getWidth()));
		Legs.getRightLine().setWidth((int)(i*Legs.getRightLine().getWidth()));
		
		Legs.getLeftLine().setY(Arms.getLeftLine().getY()+default_Line_Height);
		Legs.getRightLine().setY(Arms.getRightLine().getY()+default_Line_Height);
		
		
		
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		// TODO Auto-generated method stub
		this.Arms.addPropertyChangeListener(l);
		this.Body.addPropertyChangeListener(l);
		this.Legs.addPropertyChangeListener(l);
		this.Text.addPropertyChangeListener(l);
		this.Head.addPropertyChangeListener(l);
		
	}
}
