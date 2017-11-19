package com.XML;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Данный класс предостовляет возможность настраивать программу не перекомпилируя ее
 * за счет парсинга XML файла по средством DOM( Document Object Model )
 * 
 * @author oleg
 *
 */
public class XMLSetting {

	/**
	 * Путь к файлу
	 * 
	 */
	private String path;
	
	/**
	 * 
	 * Разделитель
	 */
	private String split;
	
	/**
	 * Конструктор содержит единственный метод load() который загружает и парсит файл,
	 * поэтому для получения path и split достаточно создать объект класса и вызвать их геттеры.  
	 * 
	 */
	public XMLSetting() {
		load();
	}
	
	/**
	 * Вызывает файл с именем settings.xml,
	 * который содержит три тега:
	 * <p> < main > - коренной тег
	 * <p> < path > - путь к файлу ar.txt 
	 * <p> < split >- разделитель значений, которые программа будет получать из файла
	 * 
	 * <p> После получения файла  
	 */
	private void load(){
		
	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	
	try {
		
		DocumentBuilder builder= factory.newDocumentBuilder();
		
		Document document=builder.parse("res/settings.xml");

		NodeList nodeList=document.getElementsByTagName("main");
		
		for(int i=0;i<nodeList.getLength();i++){
			
	   	Element element= (Element)nodeList.item(i);
	   	
		path=element.getElementsByTagName("path").item(0).getChildNodes().item(0).getNodeValue();
		
		split=element.getElementsByTagName("split").item(0).getChildNodes().item(0).getNodeValue();
		 
    }
	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		
	
	}
	public String getPath(){
		return path;
	}
	public String getSplit(){
		return split;
	}
}
