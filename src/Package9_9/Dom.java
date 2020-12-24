package Package9_9;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Dom {
    public static void main(String[] args) {
        Dom dom = new Dom();
        String filePath = "D:\\idea Project\\321\\src\\oracle.xml";
        dom.domParse();
    }

    public Map<String, String> domParse() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        Map<String, String> map = new HashMap();
        List<String> listName = new ArrayList<>();
        List<String> listMoney = new ArrayList<>();

        try {
            //工厂创建DocumentBuilder对象
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            //解析xml，获取document对象
            Document document = documentBuilder.parse("D:\\idea Project\\321\\src\\oracle.xml");
            //获取document的根节点
            Element root = document.getDocumentElement();
            //获取根节点的子节点
            NodeList childNodes = root.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);

                switch (node.getNodeType()) {
                    case Node.TEXT_NODE:
                        //    System.out.println("文本节点，内容为"+node.getTextContent());
                        break;
                    case Node.ELEMENT_NODE:
                        //System.out.println("元素节点，名称为" + node.getNodeName());
                        listName.add(node.getNodeName());
                        //获取当前元素节点的所有属性
                        NamedNodeMap attributes = node.getAttributes();
                        //循环得到每一个属性
                        for (int j = 0; j < attributes.getLength(); j++) {
                            //强制转换为Attr类型，表示属性
                            Attr attr = (Attr) attributes.item(j);
                            //   System.out.println("元素节点的属性，名称为"+attr.getName()+",属性值："+attr.getValue());

                        }
                        //再次获取当前元素节点下面的子节点
                        NodeList list = node.getChildNodes();
                        for (int k = 0; k < list.getLength(); k++) {
                            Node item = list.item(k);
                            if (item.getNodeType() == Node.ELEMENT_NODE) {
                            //    System.out.println("    子节点，名称为" + item.getNodeName() + ",文本内容：" + item.getTextContent());
                            }
                            if (item.getNodeType() == Node.TEXT_NODE) {
                            //    System.out.println("文本节点，内容为" + item.getTextContent());
                                listMoney.add(item.getTextContent());
                            }
                        }
                        break;
                    default:
                        throw new RuntimeException("解析到意外的节点类型:" + node);
                }
            }
//		System.out.println(listName);
//		System.out.println(listMoney);

            for (int i = 0; i < listName.size(); i++) {
                map.put(listName.get(i), listMoney.get(i));
            }
//            System.out.println(map);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }
}