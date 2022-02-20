package com.code.arraysn;

import java.util.*;

public class n380 {

    private List<Integer> num = new ArrayList<>();

    public Map<Integer, Integer> map = new HashMap<>();
    Random rand = new Random();
    public n380() {
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }else {

            map.put(val, num.size());
            num.add(num.size(), val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int count = map.get(val);
            int lastIndex = num.size() - 1;
            Integer last = num.get(lastIndex);
            num.set(count, last);
            map.put(last, count);
            num.remove(lastIndex);
            map.remove(val);
            return true;
        }else {
            return false;
        }

    }

    public int getRandom() {
        return num.get(rand.nextInt(num.size()));

    }


}
