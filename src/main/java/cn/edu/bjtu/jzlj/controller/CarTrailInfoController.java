package cn.edu.bjtu.jzlj.controller;


import cn.edu.bjtu.jzlj.annotation.PassToken;
import cn.edu.bjtu.jzlj.domain.CarTrailInfo;
import cn.edu.bjtu.jzlj.service.CarTrailInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@PassToken
@RequestMapping("/carTrailInfo")
@Api(tags = "车辆运行信息API")
@Slf4j
public class CarTrailInfoController {
    @Autowired
    CarTrailInfoService carTrailInfoService;
    @PassToken
    @GetMapping("/hai")
    @ApiOperation(value="信息列表")
    public List<CarTrailInfo> list(){

        List<CarTrailInfo> carTrailInfos=carTrailInfoService.selectList(null);
        log.warn(carTrailInfos.toString());
        return carTrailInfos;
    }
}

