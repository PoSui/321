package BeanFactory;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {
    private Map<String,Object> map = new HashMap<>();
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.initBeanFactory("src/test/three/student.xml");
        Object student = beanFactory.getObject("student");
        System.out.println(student);
    }
    public void initBeanFactory(String path){
        Document document = null;
        try {
            document = new SAXReader().read(path);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
//遍历<bean> 获取id 和 class属性
            for (Element e:elements) {
                String id = e.attribute("id").getValue();
                String className = e.attribute("class").getValue();
//获取属性
                String methodName=null;
                String methodParm=null;
//反射创建对象
                Class<?> clazz = Class.forName(className);
                Object o = o = clazz.newInstance();
                for (Element e1: e.elements()) {
//解析<bean>下的property节点
                    Attribute nameAttr = e1.attribute("name");
                    methodName = nameAttr.getValue();
                    methodParm = e1.getText();
//创建该对象，传递属性
//Object o = createObject(className,methodName,methodParm);
//name
                    methodName =
                            "set"+methodName.substring(0,1).toUpperCase()+methodName.substring(1);
//反射调用方法
                    Method method = clazz.getMethod(methodName,
                            methodParm.getClass());
                    method.invoke(o,methodParm);
                }
//存入工厂中
                map.put(id,o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //根据id获取从工厂中取出对象
    public Object getObject(String id){
        return map.get(id);
    }
}