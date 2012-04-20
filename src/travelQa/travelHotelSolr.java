package travelQa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fit.ColumnFixture;

public class travelHotelSolr extends ColumnFixture {
public String city_id,city_name;
Document dom;
public String hotelCount(){
String hotel=null;
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			dom = db.parse("http://mtc073-l285.sis.travel.com:9082/solr/select/?q=city_id:"+city_id);


		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}


Element docEle = dom.getDocumentElement();
NodeList nl = docEle.getElementsByTagName("result");
Element el = (Element)nl.item(0);
String hotelnum = el.getAttribute("numFound");
return hotelnum ;    
}
}
