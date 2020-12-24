package Package9_11;

import org.dom4j.*;
import org.dom4j.io.SAXReader;


import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        String filePath = "D:\\idea Project\\321\\src\\Package9_11\\student.xml";
        try {
            Document document = test.parse(new File(filePath));
            test.handler1(document);
            test.handler2(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Document parse(File file) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        return document;
    }
    public void handler1(Document document) {
        Element root = document.getRootElement();
        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
            Element element = it.next();
            System.out.println(element.getName());
        }
        List<Node> list2 = document.selectNodes("//@id");
        list2.forEach(n->System.out.println(n.getName()+"="+n.getText()));
        List<Node> list3 = document.selectNodes("//@class");
        list3.forEach(n->System.out.println(n.getName()+"="+n.getText()));
}
    public void handler2(Document document) {
        List<Node> list = document.selectNodes("//property");
        list.forEach(n->System.out.println(n.getName()+"="+n.getText()));

        List<Node> list2 = document.selectNodes("//@name");
        list2.forEach(n->System.out.println(n.getName()+"="+n.getText()));

    }

}
