package Package9_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXtest {
    public static void main(String[] args) {
        SAXtest dom = new SAXtest();
        String filePath = "D:\\idea Project\\321\\src\\oracle.xml";
        dom.saxParse(filePath);
    }

    public void saxParse(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        Map<String,Double> map = new HashMap<>();
        List<String> listName = new ArrayList<>();
        List<Double> listMoney = new ArrayList<>();

        try {
            SAXParser saxParser =saxParserFactory.newSAXParser();

            try {
                saxParser.parse(filePath, new DefaultHandler() {

                    @Override
                    public void startDocument() {
                    //    System.out.println("解析器开始解析文档");
                    }

                    @Override
                    public void endDocument() {
                    //   System.out.println("解析文档结束");
                    }
                    /**
                     * 当解析器解析到一个开始标签的时候，调用该方法
                     * @param uri 命名空间
                     * @param localName 本地名称（不带前缀）
                     * @param qname 限定的名称（带有前缀）
                     * @param attributes 该节点上的属性列表
                     * @throws SAXException
                     */
                    @Override
                    public void startElement(String uri, String localName,String qname,Attributes attributes) {
                        System.out.println("节点"+qname+"开始解析");
                        if(attributes.getLength()>0) {
                        //    System.out.println("属性列表：");
                            for(int i = 0;i<attributes.getLength();i++) {
                                String attrName = attributes.getQName(i);
                                String attrValue = attributes.getValue(i);
                            //    System.out.print(attrName+"="+attrValue+" ");
                                System.out.print(attrValue+":");
                                listName.add(attrValue);
                            }
                        }
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
                    //    System.out.println("节点："+qName+"解析结束");
                    }

                    //当解析器解析到文件值的时候，调用该方法
                    @Override
                    public void characters(char[] ch, int start, int length) throws SAXException {
                        String str = new String(ch,start,length);
                        if(!"".equals(str.trim())) {

                         // System.out.println("文本节点："+str);
                            System.out.println(str);
                            listMoney.add(Double.parseDouble(str));
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
        for(int l = 0;l<listName.size();l++){
            int flag=0;
            String no1 = listName.get(l);
            Double no2 = listMoney.get(l);
            listName.remove(l);
            listMoney.remove(l);
            for(int i=0;i<listName.size();i++){
                if(no1.equals(listName.get(i))){
                    listMoney.set(i,no2+listMoney.get(i));
                    flag=1;
                }
            }
            if(flag==0){
                listName.add((no1));
                listMoney.add(no2);
            }
        }
        for(int i = 0; i<2;i++){
            map.put(listName.get(i),listMoney.get(i));
        }
        System.out.println(map);
    }

}
