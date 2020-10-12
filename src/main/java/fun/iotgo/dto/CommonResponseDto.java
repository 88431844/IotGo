package fun.iotgo.dto;

import lombok.Data;

/**
 * 返回公共类
 */
@Data
public class CommonResponseDto<T> {
    private String code;
    private String msg;
    private T data;

}
