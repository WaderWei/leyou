package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * 统一异常结果返回对象
 */
@Data
public class ExceptionResult {
    private int status;
    private String msg;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum exceptionEnum) {
        this.status = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
