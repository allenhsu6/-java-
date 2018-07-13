package GaoQi;

import java.util.*;

public class Example9_1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add("a" + i);
        }
        System.out.println(set);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("a" + i);
        }
        System.out.println(list);

        //两种遍历map的方式

        Map<String, String> map = new HashMap<>();
        map.put("1", "allen");
        map.put("2", "miya");
        Set<Map.Entry<String, String>> ss = map.entrySet();
        for (Iterator<Map.Entry<String, String>> iterator = ss.iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> e = iterator.next();
            System.out.println(e.getKey() + "--" + e.getValue());
        }

        Map<String, String> map1 = new TreeMap<>();
        map1.put("big", "大");
        map1.put("small", "小");
        Set<String> set1 = map1.keySet();
        for (Iterator<String> iterator = set1.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            System.out.println(s + "--" + map1.get(s));
        }


        Map<String, String> map2 = new HashMap<>();
        String sss = "code";
        map2.put(sss, "1");
        map2.put(sss, "2");
        System.out.println(map2.size());
    }
}
