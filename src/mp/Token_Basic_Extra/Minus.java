package mp.Token_Basic_Extra;
import mp.Token_Basic.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags ({"Minus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@PropertyNames({"Input"}) 
@EditablePropertyNames({"Input"})
public class Minus extends Token implements MinusInterface{
	
	public Minus(String s) {
		super(s);
	}
	

}
