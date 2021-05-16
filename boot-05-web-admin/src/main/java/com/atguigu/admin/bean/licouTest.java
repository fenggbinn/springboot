package com.atguigu.admin.bean;

import java.util.HashMap;
import java.util.Map;

public class licouTest {
        public void majorityElement(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                if(map.containsValue(nums[i])){
                    Integer integer = map.get(nums[i]);
                    map.put(nums[i],integer++);
                }else{
                    map.put(nums[i],1);
                }
            }
            int x=n/2;
            for(Map.Entry<Integer,Integer> m:map.entrySet()){
                if(m.getValue()>x){
                    System.out.println(m.getKey());
                }
            }
         //   return 0;
        }
}
