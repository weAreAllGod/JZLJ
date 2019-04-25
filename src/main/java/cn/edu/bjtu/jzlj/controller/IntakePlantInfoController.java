package cn.edu.bjtu.jzlj.controller;


import cn.edu.bjtu.jzlj.annotation.PassToken;
import cn.edu.bjtu.jzlj.contant.ResultCode;
import cn.edu.bjtu.jzlj.domain.IntakePlantInfo;
import cn.edu.bjtu.jzlj.exception.CustomException;
import cn.edu.bjtu.jzlj.service.IntakePlantInfoService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/intakePlantInfo")
@Slf4j
public class IntakePlantInfoController {
    @Autowired
    IntakePlantInfoService intakePlantInfoService;
    @PassToken
    @GetMapping("/list")
    public List<IntakePlantInfo> list(){
        List<IntakePlantInfo> intakePlantInfos=intakePlantInfoService.selectList(null);
        if(intakePlantInfos==null){
            throw new CustomException(ResultCode.NULL);


        }
        return intakePlantInfos;

    }



}

