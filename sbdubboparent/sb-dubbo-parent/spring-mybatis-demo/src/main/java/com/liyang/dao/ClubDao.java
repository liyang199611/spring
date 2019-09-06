package com.liyang.dao;

import com.liyang.pojo.Club;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClubDao {
    public void addClub(@Param("club") Club club);
}
