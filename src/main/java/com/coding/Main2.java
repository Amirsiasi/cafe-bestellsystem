package com.coding;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
     String text = "hallo welt hallo java welt";

     Map<String,Integer> map = new HashMap<>();

     for (String word : text.split(" " )) {
         map.put(word, map.getOrDefault(word, 0) + 1);
     }
        System.out.println(map);



    }
}
