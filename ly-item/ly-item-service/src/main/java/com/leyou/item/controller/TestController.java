package com.leyou.item.controller;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class TestController {
    @GetMapping("test")
    public ResponseEntity<Integer> test() {
        throw new LyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
    }
}
