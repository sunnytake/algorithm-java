package basic_class.class04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_01_HashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zuo", "31");

        System.out.println(map.containsKey("zuo"));
        System.out.println(map.containsKey("chengyun"));
        System.out.println("=========================");

        System.out.println(map.get("zuo"));
        System.out.println(map.get("chengyun"));
        System.out.println("=========================");

        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println("=========================");

        System.out.println(map.remove("zuo"));
        System.out.println(map.containsKey("zuo"));
        System.out.println(map.get("zuo"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println("=========================");

        map.put("zuo", "31");
        System.out.println(map.get("zuo"));
        map.put("zuo", "32");
        System.out.println(map.get("zuo"));
        System.out.println("=========================");

        map.put("zuo", "31");
        map.put("cheng", "32");
        map.put("yun", "33");

        for(String key : map.keySet()){
            System.out.println(key);
        }
        System.out.println("=========================");

        for(String value : map.values()){
            System.out.println(value);
        }

        map.clear();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "1");
        map.put("E", "2");
        map.put("F", "3");
        map.put("G", "1");
        map.put("H", "2");
        map.put("I", "3");
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }
        System.out.println("=========================");

        // 不能在遍历的时候删除项目
//        for(Map.Entry<String, String> entry : map.entrySet()){
//            if(!entry.getValue().equals("1"))
//                map.remove(entry.getKey());
//        }

        // 正确的删除项的方法为：收集需要删除的项，遍历结束后删除
        List<String> removeKeys = new ArrayList<String>();
        for(Map.Entry<String, String> entry: map.entrySet()){
            if(!entry.getValue().equals("1"))
                removeKeys.add(entry.getKey());
        }
        for(String removeKey : removeKeys)
            map.remove(removeKey);
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }
        System.out.println("=========================");

    }
}
