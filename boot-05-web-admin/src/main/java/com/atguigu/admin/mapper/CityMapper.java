package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper//在main类中使用@MapperScan("相应的mapper接口的路径")注解这里就可以不用写@Mapper注解了
public interface CityMapper {
    @Select("select * from city where cityId=#{cityId}")
    public City getCity(int cityId);
/*  public void insertCity(City city);*/

    public void insertCity(Integer cityId,String cityName);
}
