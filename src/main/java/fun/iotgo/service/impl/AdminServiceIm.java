package fun.iotgo.service.impl;

import fun.iotgo.dao.AdminMapper;
import fun.iotgo.dto.AdminDto;
import fun.iotgo.entity.Admin;
import fun.iotgo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AdminServiceIm implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 更新管理员信息
     */
    public void updateAdmin(AdminDto adminDto) throws Exception {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        adminMapper.updateByPrimaryKey(admin);
    }
}
