package com.kfyty.loveqq.framework.boot.web.example.config;

import com.kfyty.loveqq.framework.web.core.annotation.ControllerAdvice;
import com.kfyty.loveqq.framework.web.core.annotation.ExceptionHandler;
import com.kfyty.loveqq.framework.web.core.http.ServerRequest;

/**
 * 描述: 全局异常处理
 *
 * @author kfyty725
 * @date 2024/8/2 17:07
 * @email kfyty725@hotmail.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理
     *
     * @param request 抽象的统一的请求对象
     * @param e       异常
     * @return 返回错误信息，返回值的处理和目标控制器方法相同，即如果目标控制器应返回 json，则该返回值也写出 json；如果目标控制器应返回视图，则该返回值也将尝试返回一个视图
     */
    @ExceptionHandler
    public String onException(ServerRequest request, Exception e) {
        return e.getClass().getName() + ":" + e.getMessage();
    }
}
