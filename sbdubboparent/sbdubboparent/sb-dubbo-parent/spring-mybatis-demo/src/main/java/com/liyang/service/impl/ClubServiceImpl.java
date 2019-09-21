package com.liyang.service.impl;

import com.liyang.dao.ClubDao;
import com.liyang.pojo.Club;
import com.liyang.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "clubService")
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubDao clubDao;
    @Override
    public void addClub(Club club) {
        clubDao.addClub(club);
    }
}
