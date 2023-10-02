package com.springboot.springbootparser.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.springframework.stereotype.Component;

import com.springboot.springbootparser.entity.Person;

@Component
public class StaxXmlParserExample {

	public List<Person> parseXmlUsingStax(String xmlFilePath) {
		List<Person> persons = new LinkedList<>();
		Person person = null;

		try {
			
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(xmlFilePath));

			while (xmlEventReader.hasNext()) {

				XMLEvent xmlEvent = xmlEventReader.nextEvent();

				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();

					switch (startElement.getName().getLocalPart()) {

					case "person":
						person = new Person();
						break;
						
					case "personId" : 
						xmlEvent = xmlEventReader.nextEvent();
						System.out.println(Integer.parseInt(xmlEvent.asCharacters().getData()));
						person.setPersonId(Integer.parseInt(xmlEvent.asCharacters().getData()));
						break;
						
					case "firstName":
						xmlEvent = xmlEventReader.nextEvent();
						System.out.println(xmlEvent);
						person.setFirstName(xmlEvent.asCharacters().getData());
						break;

					case "lastName":
						xmlEvent = xmlEventReader.nextEvent();
						person.setLastName(xmlEvent.asCharacters().getData());
						break;

					case "email":
						xmlEvent = xmlEventReader.nextEvent();
						person.setEmail(xmlEvent.asCharacters().getData());
						break;

					case "age":
						xmlEvent = xmlEventReader.nextEvent();
						person.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
						break;
					}
				}

				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("person")) {
						persons.add(person);
					}
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		return persons;
	}

}
