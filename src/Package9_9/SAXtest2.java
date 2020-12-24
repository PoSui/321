package Package9_9;


import java.io.IOException;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXtest2 {
    public static void main(String[] args) {
        SAXtest2 dom = new SAXtest2();
        String filePath = "D:\\idea Project\\321\\src\\oracle.xml";
        dom.saxParse(filePath);
    }

    public void saxParse(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();


        try {
            SAXParser saxParser =saxParserFactory.newSAXParser();

            try {
                saxParser.parse(filePath, new DefaultHandler() {

                    @Override
                    public void startDocument() {
                        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                    }

                    @Override
                    public void endDocument() {
                        System.out.println("解析文档结束");
                    }
                    /**
                     * 当解析器解析到一个开始标签的时候，调用该方法
                     * @param uri 命名空间
                     * @param localName 本地名称（不带前缀）
                     * @param qName 限定的名称（带有前缀）
                     * @param attributes 该节点上的属性列表
                     * @throws SAXException
                     */
                    @Override
                    public void startElement(String uri, String localName,String qname,Attributes attributes) {
                        StringBuilder stringBuilder = new StringBuilder();
                        //	System.out.println("节点"+qname+"开始解析");
                        stringBuilder.append("<").append(qname);
                        //	if(attributes.getLength()>0) {
                        //		System.out.println("属性列表：");
                        for(int i = 0;i<attributes.getLength();i++) {
                            String attrName = attributes.getQName(i);
                            String attrValue = attributes.getValue(i);
                            System.out.print(attrName+"="+attrValue+" ");
                            stringBuilder.append(" ");
                            stringBuilder.append(attrName+"='"+attrValue+"'");
                        }
                        stringBuilder.append(">");
                        System.out.println(stringBuilder);
                        //	}
                    }
                    /**
                     * 当解析器解析到一个结束标签的时候，调用该方法
                     * @param uri 命名空间
                     * @param localName 本地名称（不带前缀）
                     * @param qName 限定的名称（带有前缀）
                     * @throws SAXException
                     */
                    @Override
                    public void endElement(String uri, String localName, String qName) throws SAXException {
                        System.out.print("<"+qName+">");
                    }

                    //当解析器解析到文件值的时候，调用该方法
                    @Override
                    public void characters(char[] ch, int start, int length) throws SAXException {
                        String str = new String(ch,start,length);
                        if(!"".equals(str.trim())) {
                            System.out.println(new String(ch,start,length));
                        }
                    }



                });
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
