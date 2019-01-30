package com.ssafy.edu.java;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class NewsDAODOMImpl implements INewsDAO{
	List<News> list=new ArrayList<News>();
	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		return list;
	}
	public News search(int index) {
		return list.get(index);
	}
	private void connectNews(String url){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = null;
		try {
			parser = dbf.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			NodeList cs = root.getElementsByTagName("item");

			for (int i = 0; i < cs.getLength(); i++) {
				News n = new News();
				Node item = cs.item(i);
				
				NodeList kids = item.getChildNodes();
				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);
					String name = kid.getNodeName();
					if (name.equalsIgnoreCase("title")) {
						n.setTitle(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("link")) {
						n.setLink(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("Description")) {
						n.setDesc(kid.getFirstChild().getNodeValue());
					}

				}
				list.add(n);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
