package launcher;

import domain.model.FigInput;
import domain.model.XMLReader;

public class Launcher2 {

	public static void main(String[] args) {
		XMLReader t = new XMLReader("LinePiece");
		FigInput f = t.getFigure();
		System.out.println(f.b1x);
		
	}

}
