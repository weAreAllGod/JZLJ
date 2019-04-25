package cn.edu.bjtu.jzlj.controller;

import cn.edu.bjtu.jzlj.contant.Result;
import cn.edu.bjtu.jzlj.domain.User;
import cn.edu.bjtu.jzlj.service.UserService;
import cn.edu.bjtu.jzlj.utils.CusAccessObjectUtils;
import cn.edu.bjtu.jzlj.utils.JwtUtils;
import cn.edu.bjtu.jzlj.vo.LoginVo;
import cn.edu.bjtu.jzlj.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: LiuYi
 * @date: 2019/4/20 0:48
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户注册登录API")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Result login(@RequestParam(value = "username", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password,
                        HttpServletRequest request, HttpServletResponse response) {
//        验证逻辑
//        User query_user = userService.getUserByName(userName);
//        if (query_user == null) {
//            return ResultVo.error(ResultCode.USERNAME_PASSWORD_ERROR);
//        };
//        //验证密码
//        boolean is_password = password != null && password.equals(query_user.getPassword());
//        if (!is_password) {
//            //密码错误，返回提示
//            return ResultVo.error(ResultCode.USERNAME_PASSWORD_ERROR);
//        }

        User query_user = new User();
        query_user.setUserName("");
        query_user.setPassword("");
        query_user.setRole("");
        query_user.setUserId("");

        String jwtToken = JwtUtils.createJWT(query_user, CusAccessObjectUtils.getIpAddress(request));
        response.setHeader("Authorization", jwtToken);
        return ResultVo.ok(new LoginVo(jwtToken, query_user));
    }
}
