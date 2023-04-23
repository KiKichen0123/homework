package Map;

import java.util.*;

/**
 * @author 陈淇淇
 * @version 1.8
 */
public class homework03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);
        System.out.println(map);

        map.replace("jack",2600);
        System.out.println(map);

//        map.replaceAll();
        Set keySet =map.keySet();
        for (Object key :keySet) {
            map.put(key,(Integer)map.get(key)+100);
        }
        System.out.println(map);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        System.out.println("-----------遍历工资-----------");
        Collection values = map.values();
        for (Object value :values) {
            System.out.println("工资= " + value);
        }

    }
}
