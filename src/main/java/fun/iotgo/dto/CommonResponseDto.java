package fun.iotgo.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 返回公共类
 */
@Data
public class CommonResponseDto<T> {
    private String code;
    private String msg;
    private T data;
    private String responseTime = new SimpleDateFormat("YYYY-MM-dd HH:mm").format(new Date());

}
