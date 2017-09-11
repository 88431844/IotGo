package com.iotlife.service;

import com.iotlife.dao.AdminMapper;
import com.iotlife.dto.AdminDto;
import com.iotlife.dto.CommonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminMapper adminMapper;

    public CommonDto updateAdmin(AdminDto adminDto) {
        CommonDto commonDto = new CommonDto();
        return commonDto;
    }
}
