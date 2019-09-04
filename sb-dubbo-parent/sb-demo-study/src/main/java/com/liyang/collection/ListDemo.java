package com.liyang.collection;

public class ListDemo {
    private Object [] array;
    private int size = 0;

    // 创建构造方法
    public ListDemo(int size){
        array = new Object[size];
    }
    public ListDemo(){
        this.array = new Object[10];
    }

    // 新增
    public void add(Object obj){
        if(size>=array.length){
            // 说明数组大小不够了，需要对数组扩容
            int length = array.length;
            // 定义一个和旧数组大小一样的数组，进行数组转移
            Object[] new_list  = new Object[length];
            for(int i=0;i<array.length;i++){
                new_list[i] = array[i]; // 进行数据的转移
            }
            // 更新原数组的长度
            length = (length*3)/2+1;
            array = new Object[length];

            // 再次进行数据的转移
            for(int i=0;i<new_list.length;i++){
                array[i] = new_list[i];
            }
            new_list = null; // 将原数组释放
        }
        array[size] = obj;
        size+=1; // 数组下标+1
    }

    public int getSize(){
        int x = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] != null){
                x+=1;
            }
        }
        return x;
    }

    public Object get(int index) {
        if (index >= 0){
            return array[index];
        }
        return null;

    }

}
