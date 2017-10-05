package com.iotlife.service;

import com.iotlife.dao.AdminMapper;
import com.iotlife.dto.AdminDto;
import com.iotlife.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 更新管理员信息
     *
     * @param adminDto
     * @throws Exception
     */
    public void updateAdmin(AdminDto adminDto) throws Exception {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        adminMapper.updateByPrimaryKey(admin);
    }
}
