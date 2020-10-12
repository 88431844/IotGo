package fun.iotgo.dto;

import lombok.Data;

/**
 * 请求公共类
 */
@Data
public class CommonRequestDto {
    //每页页数
    private long pageSize;
    //第几页
    private long pageIndex;
    //是否需要分页
    private boolean needPage;
    //请求token
    private String token;

}
