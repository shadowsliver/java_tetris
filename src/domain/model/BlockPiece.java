package domain.model;

import java.awt.Point;
import java.util.ArrayList;

public class BlockPiece extends AFigure{

	private Block b1;
	private Block b2;
	private Block b3;
	private Block b4;
	
	public BlockPiece(String colorHex, IObserver o, Field field, PlayingFieldCalculator pfc) {
		super(colorHex, o, field, pfc);
		XMLReader r = new XMLReader("BlockPiece");
		FigInput f = r.getFigure();
	}

	@Override
	public void changePos() {
		//doet niets
	}

	@Override
	public void generateBlocks() {

		XMLReader r = new XMLReader("BlockPiece");
		FigInput f = r.getFigure();
		
		b1 = new Block(pfc.getHeightRow(), new Punt(f.b1x, f.b1y), getColorHex(), field, pfc);
		b2 = new Block(pfc.getHeightRow(), new Punt(f.b2x, f.b2y), getColorHex(), field, pfc);
		b3 = new Block(pfc.getHeightRow(), new Punt(f.b3x, f.b3y), getColorHex(), field, pfc);
		b4 = new Block(pfc.getHeightRow(), new Punt(f.b4x, f.b4y), getColorHex(), field, pfc);
		super.blocks.add(b1);
		super.blocks.add(b2);
		super.blocks.add(b3);
		super.blocks.add(b4);
	}

	@Override
	public void rotate() {
		//nvt
	}

}
