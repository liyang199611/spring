package com.liyang.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Job{
    public void test1(){
        /**
         * 逆序输出字符串
         */
        System.out.println("请输入一个字符串:");
        Scanner in = new Scanner(System.in);
        String line = in.next();
        String [] str_arrays = line.split("");
        String [] new_str_array = new String[str_arrays.length];
        int index = 0;
        for(int i=str_arrays.length-1;i>= 0;i--){
            new_str_array[index] = str_arrays[i];
            index++;
        }
        for (String str: new_str_array) {
            System.out.println(str);
        }
    }

    public void test2(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入排列字符");
        String line = in.next();
        String [] line_array = line.split("");
        List list = new ArrayList();
        for(int i=0;i<line_array.length;i++){
            for(int j=0;j<line_array.length;j++){
                for(int k=0;k<line_array.length;k++){
                    if(i!=j && j!=k && i!=k){
                        list.add(line_array[i]+line_array[j]+line_array[k]);
                    }
                }
            }
        }
        for (Object str : list) {
            System.out.println(str.toString());
        }

    }
}
public class Main {
    public static void main(String [] args){
        Job job = new Job();
        job.test2();
    }
}
