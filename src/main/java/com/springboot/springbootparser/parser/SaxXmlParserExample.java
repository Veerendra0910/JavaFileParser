package com.springboot.springbootparser.parser;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.springboot.springbootparser.entity.Person;

@Component
public class SaxXmlParserExample {

	public List<Person> parseXmlUsingSax(String xmlFilePath) {
		List<Person> persons = new LinkedList<>();

		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();

			DefaultHandler defaultHandler = new DefaultHandler() {
				boolean bPersondId = Boolean.FALSE, bFirstName = Boolean.FALSE, bLastName = Boolean.FALSE,
						bEmail = Boolean.FALSE, bAge = Boolean.FALSE;
				Person person = null;

				public void startElement(String uri, String localName, String qName, Attributes attributes) {
					if (qName.equalsIgnoreCase("person")) {
						person = new Person();
					} else if (qName.equalsIgnoreCase("personId"))
						bPersondId = Boolean.TRUE;
					else if (qName.equalsIgnoreCase("firstName"))
						bFirstName = Boolean.TRUE;
					else if (qName.equalsIgnoreCase("lastName"))
						bLastName = Boolean.TRUE;
					else if (qName.equalsIgnoreCase("email"))
						bEmail = Boolean.TRUE;
					else if (qName.equalsIgnoreCase("age"))
						bAge = Boolean.TRUE;
				}

				public void endElement(String uri, String localName, String qName) {
					if (qName.equalsIgnoreCase("person")) {
						persons.add(person);
					}
				}

				public void characters(char[] ch, int start, int length) throws SAXException {
					if (bPersondId) {
						person.setPersonId(Integer.parseInt(new String(ch, start, length)));
						bPersondId = Boolean.FALSE;
					} else if (bFirstName) {
						person.setFirstName(new String(ch, start, length));
						bFirstName = Boolean.FALSE;
					} else if (bLastName) {
						person.setLastName(new String(ch, start, length));
						bLastName = Boolean.FALSE;
					} else if (bEmail) {
						person.setEmail(new String(ch, start, length));
						bEmail = Boolean.FALSE;
					} else if (bAge) {
						person.setAge(Integer.parseInt(new String(ch, start, length)));
						bAge = Boolean.FALSE;
					}
				}

			};
			saxParser.parse(new File(xmlFilePath), defaultHandler);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return persons;
	}
}
