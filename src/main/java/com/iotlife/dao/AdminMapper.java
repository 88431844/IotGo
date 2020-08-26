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

    /**
     * 通过账号密码查询管理员信息
     *
     * @param adminDto
     * @return
     */
    AdminDto selectByLoginNameAndPass(AdminDto adminDto);
}