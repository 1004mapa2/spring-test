package com.springtest.six;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    void add(int id, String name);

    String getName(int id);
}
