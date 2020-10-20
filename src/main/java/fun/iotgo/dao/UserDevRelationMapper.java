package fun.iotgo.dao;

import fun.iotgo.entity.UserDevRelation;
import org.apache.ibatis.annotations.Param;

public interface UserDevRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDevRelation record);

    int insertSelective(UserDevRelation record);

    UserDevRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDevRelation record);

    int updateByPrimaryKey(UserDevRelation record);

    /**
     * 通过用户id和设备id删除用户绑定设备关系
     */
    void delByUserIdAndDevId(UserDevRelation userDevRelation);

    /**
     * 解绑用户所有设备
     */
    void unBindUserAllDev(@Param("userId") String userId);
}