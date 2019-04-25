package cn.edu.bjtu.jzlj.controller;


import cn.edu.bjtu.jzlj.annotation.PassToken;
import cn.edu.bjtu.jzlj.contant.ResultCode;
import cn.edu.bjtu.jzlj.domain.CarCarryInfo;
import cn.edu.bjtu.jzlj.exception.CustomException;
import cn.edu.bjtu.jzlj.service.CarCarryInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/carCarryInfo")
@Api(tags = "车辆承载信息API")
@Slf4j
public class CarCarryInfoController {

    @Autowired
    CarCarryInfoService carCarryInfoService;
    @PassToken
    @GetMapping("/cci")
    @ApiOperation(value = "信息列表")
    public List<CarCarryInfo> list() {
        List<CarCarryInfo> carCarryInfos = carCarryInfoService.selectList(null);

        log.warn(carCarryInfos.toString());
        if (carCarryInfos == null) {
//            空异常抛出
            throw new CustomException(ResultCode.NULL);
        }
        return carCarryInfos;
    }
}

