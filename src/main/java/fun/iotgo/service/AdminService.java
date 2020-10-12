package fun.iotgo.service;

import fun.iotgo.dto.AdminDto;

public interface AdminService {

    /**
     * 更新管理员信息
     */
    void updateAdmin(AdminDto adminDto) throws Exception;
}
