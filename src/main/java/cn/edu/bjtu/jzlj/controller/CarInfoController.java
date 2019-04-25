package cn.edu.bjtu.jzlj.controller;


import cn.edu.bjtu.jzlj.contant.Result;
import cn.edu.bjtu.jzlj.domain.CarCarryInfo;
import cn.edu.bjtu.jzlj.domain.CarInfo;
import cn.edu.bjtu.jzlj.service.CarInfoService;
import cn.edu.bjtu.jzlj.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/carInfo")
@Api(tags = "车辆基本信息API")
@Slf4j
public class CarInfoController {

    @Autowired
    CarInfoService carInfoService;

    //    @PassToken
    @GetMapping("/ci")
    @ApiOperation(value = "信息列表")
    public Result list() {
        List<CarInfo> carInfos = carInfoService.selectList(null);
        log.warn(carInfos.toString());
        return ResultVo.ok(carInfos);
    }
}

