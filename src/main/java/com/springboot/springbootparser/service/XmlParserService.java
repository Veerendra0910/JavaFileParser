package com.springboot.springbootparser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.springbootparser.dao.XmlParserDao;
import com.springboot.springbootparser.entity.Person;
import com.springboot.springbootparser.parser.DomXmlParserExample;
import com.springboot.springbootparser.parser.SaxXmlParserExample;
import com.springboot.springbootparser.parser.StaxXmlParserExample;

@Service
public class XmlParserService {

	@Autowired
	XmlParserDao xmlParserDao;

	@Autowired
	StaxXmlParserExample staxParserExample;

	@Autowired
	DomXmlParserExample domParserExample;

	@Autowired
	SaxXmlParserExample saxParserExample;

	@Value("${xml.file.path}")
	private String xmlFilePath;

	public List<Person> getAllPersons() {
		return xmlParserDao.getAllPersons();
	}

	// add Persons By Using StaxParser
	public Boolean loadPersonsByStaxParser() {
		return xmlParserDao.loadPersons(staxParserExample.parseXmlUsingStax(xmlFilePath));
	}

	// add Persons By Using DomParser
	public Boolean loadPersonsByDomParser() {
		return xmlParserDao.loadPersons(domParserExample.parseXmlUsingDom(xmlFilePath));
	}

	// add Persons By Using SaxParser
	public Boolean loadPersonsBySaxParser() {
		return xmlParserDao.loadPersons(saxParserExample.parseXmlUsingSax(xmlFilePath));
	}

}
