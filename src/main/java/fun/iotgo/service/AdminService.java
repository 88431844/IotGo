package fun.iotgo.service;

import fun.iotgo.dao.AdminMapper;
import fun.iotgo.dto.AdminDto;
import fun.iotgo.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
