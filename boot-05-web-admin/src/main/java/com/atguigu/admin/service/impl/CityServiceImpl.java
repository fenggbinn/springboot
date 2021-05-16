package com.atguigu.admin.service.impl;

import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.bean.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl {
    @Autowired
    CityMapper cityMapper;

    public City getCity(Integer cityId){
        return cityMapper.getCity(cityId);
    }

    public void insertCity(Integer cityId,String cityName){
        cityMapper.insertCity(cityId,cityName);
    }
}
