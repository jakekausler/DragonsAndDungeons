package map;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Area { 
	
	private String areaDefinition;
	
	private int width;
	private int height;
	
	private String name;
	
	private Tile[] tiles;
	
	public Area(String ad) {
		areaDefinition = ad;
		File file = new File(areaDefinition);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			
			doc.getDocumentElement().normalize();
			
			width = Integer.parseInt(doc.getDocumentElement().getAttribute("width"));		
			height = Integer.parseInt(doc.getDocumentElement().getAttribute("height"));
			tiles = new Tile[width*height];
			
			name = doc.getDocumentElement().getAttribute("name");
			
			NodeList nl = doc.getElementsByTagName("tile");
			for (int i=0; i<nl.getLength(); i++) {
				Node n = nl.item(i);
				Element e = (Element)n;
				int x = Integer.parseInt(e.getAttribute("x"));
				int y = Integer.parseInt(e.getAttribute("y"));
				String img = e.getAttribute("img");
				tiles[x+width*y] = new Tile(new Point(x, y), img);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Get the tile at point p
	public Tile getTile(Point p) {
		return tiles[p.getX()+width*p.getY()];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Tile t: tiles) {
			s += t.toString() + "\n";
		}
		return s;
	}

}
