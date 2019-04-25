package cn.edu.bjtu.jzlj.controller;


import cn.edu.bjtu.jzlj.annotation.PassToken;
import cn.edu.bjtu.jzlj.contant.ResultCode;
import cn.edu.bjtu.jzlj.domain.EnvironPara;
import cn.edu.bjtu.jzlj.exception.CustomException;
import cn.edu.bjtu.jzlj.service.EnvironParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiuYi
 * @since 2019-04-17
 */
@RestController
@RequestMapping("/environPara")
public class EnvironParaController {
    @Autowired
    EnvironParaService environParaService;
    @PassToken
    @GetMapping("/list")
    public List<EnvironPara> list(){

        List<EnvironPara> environParas=environParaService.selectList(null);
        if (environParas==null){
            throw new CustomException(ResultCode.NULL);


        }
        else {
            return environParas;
        }
    }


}

