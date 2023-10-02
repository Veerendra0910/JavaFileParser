package com.springboot.springbootparser.parser;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.springboot.springbootparser.entity.Person;

@Component
public class DomXmlParserExample {

	public List<Person> parseXmlUsingDom(String xmlFilePath) {

		List<Person> persons = new LinkedList<>();
		Person person = null;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new File(xmlFilePath));
			document.getDocumentElement().normalize();
		
			NodeList nodeList = document.getElementsByTagName("person");

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element personElement = (Element) node;
					person = new Person();
					System.out.println(personElement.getElementsByTagName("personId").item(0).getTextContent());
					person.setPersonId(Integer.parseInt(personElement.getElementsByTagName("personId").item(0).getTextContent()));
					person.setFirstName(personElement.getElementsByTagName("firstName").item(0).getTextContent());
					person.setLastName(personElement.getElementsByTagName("lastName").item(0).getTextContent());
					person.setEmail(personElement.getElementsByTagName("email").item(0).getTextContent());
					person.setAge(Integer.parseInt(personElement.getElementsByTagName("age").item(0).getTextContent()));

					persons.add(person);
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return persons;
	}
}
