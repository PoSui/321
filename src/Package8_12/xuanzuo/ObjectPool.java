package Package8_12.xuanzuo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPool {
    //对象数据
    private static final Properties DATA = new Properties();

    static {
        try {
            DATA.load(ObjectPool.class.getResourceAsStream("data.properties"));
        } catch (IOException e) {
            System.exit(0);
        }
    }

    private Map<String, Object> mapObject = new HashMap<>();


    public void initPool() throws Exception {
        for (Map.Entry<Object, Object> entry : DATA.entrySet()) {
            System.out.println(entry.getKey().getClass().getSimpleName());
            Class<?> c = Class.forName(entry.getValue().toString());
            mapObject.put(entry.getKey().toString(), c.newInstance());
        }
    }


    public Object getObject(String key) {
        return mapObject.get(key);
    }
}
