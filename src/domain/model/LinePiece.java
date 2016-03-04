package domain.model;

public class LinePiece extends AFigure{

	private Block b1;
	private Block b2;
	private Block b3;
	private Block b4;
	
	public LinePiece(String colorHex, IObserver o, Field field, PlayingFieldCalculator pfc) {
		super(colorHex, o, field, pfc);
	}

	@Override
	public void changePos() {
		//Omdraaien
	}

	@Override
	public void generateBlocks() {
		
		XMLReader r = new XMLReader("LinePiece");
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
		if(rotateState == 1){
			blocks.get(0).adjustPos(2,-1);
			blocks.get(1).adjustPos(1, 0);
			blocks.get(2).adjustPos(0, 1);
			blocks.get(3).adjustPos(-1, 2);
			rotateState = 2;
		}
		else if(rotateState == 2){
			blocks.get(0).adjustPos(-2,1);
			blocks.get(1).adjustPos(-1, 0);
			blocks.get(2).adjustPos(0, -1);
			blocks.get(3).adjustPos(1, -2);
			rotateState = 1;
		}
	}


	
}
