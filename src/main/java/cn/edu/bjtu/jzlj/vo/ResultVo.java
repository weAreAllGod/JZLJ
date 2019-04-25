package cn.edu.bjtu.jzlj.vo;

import cn.edu.bjtu.jzlj.contant.EmptyResult;
import cn.edu.bjtu.jzlj.contant.RespResult;
import cn.edu.bjtu.jzlj.contant.Result;
import cn.edu.bjtu.jzlj.contant.ResultCode;

/**
 * @author: LiuYi
 * @date: 2019/4/19 22:20
 */
public class ResultVo {

    public static Result ok(Object data) {
        return new RespResult(ResultCode.SUCCESS, data);
    }

    public static Result error(ResultCode resultCode) {
        return new EmptyResult(resultCode);
    }
}
