package com.liyang.tree;

public interface Tree {
    public Node find(int key); // 查询节点
    public boolean insert(int key); // 插入节点
    public boolean delete(int key); // 删除节点

}
