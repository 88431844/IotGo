package com.iotlife.dao;

import com.iotlife.dto.AdminDto;
import com.iotlife.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    AdminDto selectByLoginNameAndPass(AdminDto adminDto);
}