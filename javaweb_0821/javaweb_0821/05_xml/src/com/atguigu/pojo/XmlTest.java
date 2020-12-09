package com.atguigu.pojo;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class XmlTest {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("05_xml/xml/books.xml");
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.asXML());
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            String sn = book.attributeValue("sn");
            String name = book.elementText("name");
            String author = book.elementText("author");
            String price = book.elementText("price");
            System.out.println(new Book(sn, name, author, price));

        }


    }

    @Test
    public void testXml() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("xml/books.xml");
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.asXML());
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            String sn = book.attributeValue("sn");
            String name = book.elementText("name");
            String author = book.elementText("author");
            String price = book.elementText("price");
            System.out.println(new Book(sn, name, author, price));

        }

    }
    @Test
    public void testXml2() throws DocumentException {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(new File("xml/cars.xml"));
//        Element rootElement = document.getRootElement();
//        Iterator<Element> iterator=rootElement.elementIterator("car");
//       for (;iterator.hasNext();){
//           Element element = iterator.next();
//           System.out.println(element.asXML());
//
//
//       }
        treeWalk(document);


    }
    public  void treeWalk(Document document){
        getNode(document.getRootElement());

    }

    private void getNode(Element element) {
        for (int i = 0,size=element.nodeCount(); i <size ; i++) {
//            System.out.println(element.nodeCount());
            Node node = element.node(i);
            if ( node instanceof Element){
                getNode((Element) node);
            }else {
                System.out.println(node.getText());
            }
        }
    }
}
