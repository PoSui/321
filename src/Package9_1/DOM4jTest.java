package Package9_1;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DOM4jTest {
    public static void main(String[] args) {
        DOM4jTest test = new DOM4jTest();
      //  运行后得到的XML文件如下：
        try {
            test.createPrettyXML(test.createDocument());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Document parse(File file) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        return document;
    }
    @SuppressWarnings("all")
    public Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("records");
        Element record1 = root.addElement("record");
        record1.addElement("name").addText("tom");
        record1.addElement("price").addText("80");


        Element record2 = root.addElement("record");
        record2.addElement("name").addText("jack");
        record2.addElement("price").addText("80");
        return document;
    }

    public void createPrettyXML(Document document) {
        try {
            FileWriter out = new FileWriter("D:\\idea Project\\321\\src\\Package9_1\\prettyxml.xml");
            //指定格式：pretty
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(out,format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}