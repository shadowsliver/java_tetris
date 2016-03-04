package domain.model;

public class PieceFactory {
	
	private IObserver observer;
	private Field field;
	PropertiesReader p;
	private PlayingFieldCalculator pfc;
	
	public PieceFactory(IObserver o, Field field, PlayingFieldCalculator pfc){
		this.pfc = pfc;
		observer = o;
		this.field = field;
		p = new PropertiesReader();
	}
	
	public AFigure GeneratePiece(){
		int random = (int)(Math.random() * ( 8 - 1 ));
		AFigure figure;
		observer.toString();
		 switch (random){ // waarde
	        case 0:
	            figure = new LinePiece(p.getProperty("colorLinePiece"),observer, field, pfc);
	            break;
	        case 1:
	            figure = new ZedPiece(p.getProperty("colorZedPiece"),observer, field, pfc);
	            break;
	        case 2:
	            figure = new ZedPieceReverse(p.getProperty("colorZedPieceReverse"),observer, field, pfc);
	            break;
	        case 3:
	            figure = new LPiece(p.getProperty("colorLPiece"),observer, field, pfc); 
	            break;
	        case 4:
	            figure = new LPieceReverse(p.getProperty("colorLPieceReverse"),observer, field, pfc);
	            break;    
	        case 5:
	            figure = new BlockPiece(p.getProperty("colorBlockPiece"),observer, field, pfc);
	            break;
	        case 6:
	            figure = new TPiece(p.getProperty("colorTPiece"),observer, field, pfc);
	            break;   
	        default:
	        	figure = null;
	            System.out.println("De figure is null");
	            break;
	        }
		 return figure;
	}

}
