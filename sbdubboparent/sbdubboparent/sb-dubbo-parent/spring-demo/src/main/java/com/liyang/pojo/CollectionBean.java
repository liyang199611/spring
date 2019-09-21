package com.liyang.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 创建集合的实体类
 */
public class CollectionBean {
    private List list;
    private Set set;
    private Map map;

    public Set getSet() {
        return set;
    }

    public Map getMap() {
        return map;
    }

    public List getList() {
        return list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setList(List list) {
        this.list = list;
    }
}
