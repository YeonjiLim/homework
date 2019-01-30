package com.ssafy.edu.java;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NewsDAOSAXImpl implements INewsDAO{
	ArrayList<News> list=new ArrayList<News>();
	
	@Override
	public ArrayList<News> getNewsList(String url) {
		list.removeAll(list);
		connectNews(url);
		return list;
	}
	public News search(int index) {
		return list.get(index);
	}
	private void connectNews(String url){
		SAXParserFactory f=null;
		try{
			f=SAXParserFactory.newInstance();
			SAXParser p=f.newSAXParser();	
			p.parse(new URL(url).openConnection().getInputStream(), new SAXHandler());
		}catch(Exception e){
			System.out.println(e);
		}
	}	
	class SAXHandler  extends DefaultHandler{
		StringBuilder b;
		News n=null;
		
		@Override
		public void startDocument() throws SAXException {
			super.startDocument(); 
			list = new ArrayList<News>(); 
			b = new StringBuilder();
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equalsIgnoreCase("item")){
				n=new News();
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			b.setLength(0);
			b.append(ch, start, length);			
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(n!=null){
				if(qName.equalsIgnoreCase("title")) {
					n.setTitle(b.toString().trim());
				} else if(qName.equalsIgnoreCase("link")){
					n.setLink(b.toString().trim());
				} else if(qName.equalsIgnoreCase("description")){
					n.setDesc(b.toString().trim());
				} else if(qName.equalsIgnoreCase("item")){
					list.add(n);
				}
			}
			b.setLength(0); 
		}
		
	}
}
