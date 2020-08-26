package fun.iotgo.service;

import fun.iotgo.dao.AdminMapper;
import fun.iotgo.dto.AdminDto;
import fun.iotgo.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AdminService {
    @Resource
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
