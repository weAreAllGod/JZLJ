package cn.edu.bjtu.jzlj.exception.handler;

import cn.edu.bjtu.jzlj.contant.Result;
import cn.edu.bjtu.jzlj.contant.ResultCode;
import cn.edu.bjtu.jzlj.exception.CustomException;
import cn.edu.bjtu.jzlj.vo.ResultVo;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.SocketTimeoutException;

/**
 * @author: LiuYi
 * @date: 2019/4/18 14:59
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //使用mapp存放异常类型 和错误代码的映射，ImmutableMap的特点是已创建就不可变，并且线程安全
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //是由builder来构建一个异常类型和错误代码的映射
    private static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder =
            ImmutableMap.builder();

    static {
        //初始化基础类型异常与错误代码的映射
        builder.put(NullPointerException.class, ResultCode.NULL);
        builder.put(SocketTimeoutException.class, ResultCode.TIMEOUT);
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customException(CustomException e) {
        log.error("catch exception : {}", e.getMessage());
        return ResultVo.error(e.getResultCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e) {
        log.error("catch exception : {} \r\ndetail", e.getMessage(), e);
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        final ResultCode resultCode = EXCEPTIONS.get(e.getClass());
        if (resultCode != null) {
            return ResultVo.error(resultCode);
        } else {
            return ResultVo.error(ResultCode.FAIL);
        }

    }
}

