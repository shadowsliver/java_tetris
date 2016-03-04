package domain.model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLReader {
	private String figure;

	public XMLReader(String figure) {
		this.figure = figure;
	}
	
	public FigInput getFigure(){
		return DOMParser();
	}

	private FigInput DOMParser() {
		
		
		
		FigInput result = new FigInput();

		
		try {

			File fXmlFile = new File("/figures.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(getClass().getResourceAsStream("/figures.xml"));

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("figure");
			
			
			boolean check = false;

			for (int temp = 0;!check && temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
	
					
					if (eElement.getAttribute("NAME").equals(figure)){
						
						
						String b1x = eElement.getElementsByTagName("block1x").item(0).getTextContent();
						String b1y = eElement.getElementsByTagName("block1y").item(0).getTextContent();
						String b2x = eElement.getElementsByTagName("block2x").item(0).getTextContent();
						String b2y = eElement.getElementsByTagName("block2y").item(0).getTextContent();
						String b3x = eElement.getElementsByTagName("block3x").item(0).getTextContent();
						String b3y = eElement.getElementsByTagName("block3y").item(0).getTextContent();
						String b4x = eElement.getElementsByTagName("block4x").item(0).getTextContent();
						String b4y = eElement.getElementsByTagName("block4y").item(0).getTextContent();
						String color = eElement.getElementsByTagName("color").item(0).getTextContent();
						

						result.b1x = Integer.parseInt(b1x);
						result.b1y = Integer.parseInt(b1y);
						result.b2x = Integer.parseInt(b2x);
						result.b2y = Integer.parseInt(b2y);
						result.b3x = Integer.parseInt(b3x);
						result.b3y = Integer.parseInt(b3y);
						result.b4x = Integer.parseInt(b4x);
						result.b4y = Integer.parseInt(b4y);
						result.color = color;
						
						check = true;
						System.out.println(temp);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}