package Package9_1;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class xmlExport {
    public static void main(String[] args) {

        xmlExport dom = new xmlExport();
        String filePath = "D:\\idea Project\\321\\src\\Package9_1\\myxml.xml";
        dom.creatDocument(filePath);
    }

    public void creatDocument(String filePath) {
        //创建DocumentBuilderFactory类的对象
        DocumentBuilderFactory builderFactory =
                DocumentBuilderFactory.newInstance();
        try {
//通过工厂对象创建出DocumentBuilder对象
            DocumentBuilder documentBuilder =
                    builderFactory.newDocumentBuilder();
//通过DocumentBuilder对象，创建出一个新的document对象
            Document document = documentBuilder.newDocument();
//创建一个根节点
            Element root =
                    document.createElement("records");
//创建三个元素节点user
            Element record1 =
                    document.createElement("record");
            Element record2 =
                    document.createElement("record");
            Element name1 = document.createElement("name");
            Element price1 = document.createElement("price");

            Element name2 = document.createElement("name");
            Element price2 = document.createElement("price");
//设置这三个元素节点的属性

//创建一个注释节点comment
            Comment comment = document.createComment("这里是注释信息");
//创建name节点中的文本内容

            name1.setTextContent("tom");
            price1.setTextContent("80");
            name2.setTextContent("jack");
            price2.setTextContent("80");
//将根节点添加到document中
            document.appendChild(root);
//将注释节点添加到根节点中
            //root.appendChild(comment);
//将student节点添加到根节点中
            root.appendChild(record1);
            record1.appendChild(name1);
            record1.appendChild(price1);
            root.appendChild(record2);
            record2.appendChild(name2);
            record2.appendChild(price2);
//调用自定义的私有方法，将document对象写出为指定路径的xml文件
            creatXMLByDocument(document,filePath);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }


    private void creatXMLByDocument(Document document,String filePath) {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            Transformer transformer = transformerFactory.newTransformer();
            //设置xml中的编码
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            //设置xml中的内容换行，否则全部写到一行中
            transformer.setOutputProperty(OutputKeys.INDENT,"yse");
            //把document对象转为xml文件
            transformer.transform(new DOMSource(document), new StreamResult(filePath));



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




















}
