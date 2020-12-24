package Package8_12.xuanzuo;

import java.util.HashMap;
import java.util.Map;

public class ObjectPool2 {

    private static final Map<String,String>  MAP_DATA= new HashMap<>();
    private static  Map<String,Object> mapObject = new HashMap();
    static {
        MAP_DATA.put("student","Package8_12.xuanzuo.Student");
        MAP_DATA.put("teacher","Package8_12.xuanzuo.Teacher");
    }

    public void initPool() throws Exception {
        for(Map.Entry<String,String> entry : MAP_DATA.entrySet()){
            Class c = Class.forName(entry.getValue());
            mapObject.put(entry.getKey(),c.newInstance());
        }

    }

    public Object getObject(String name){
        return mapObject.get(name);
    }
}
