package cn.edu.bjtu.jzlj.controller;


import cn.edu.bjtu.jzlj.annotation.PassToken;
import cn.edu.bjtu.jzlj.contant.ResultCode;
import cn.edu.bjtu.jzlj.domain.EnvironPara;
import cn.edu.bjtu.jzlj.domain.IntakePlantInfo;
import cn.edu.bjtu.jzlj.domain.SecurityPara;
import cn.edu.bjtu.jzlj.exception.CustomException;
import cn.edu.bjtu.jzlj.service.EnvironParaService;
import cn.edu.bjtu.jzlj.service.IntakePlantInfoService;
import cn.edu.bjtu.jzlj.service.SecurityParaService;
import cn.edu.bjtu.jzlj.vo.SaftyAppConsumersVo;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.internal.tools.Klist;

import java.sql.Wrapper;
import java.util.*;

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
    @Autowired
    SecurityParaService securityParaService;
    @Autowired
    EnvironParaService environParaService;
    @PassToken
    @GetMapping("/list")
    public List<IntakePlantInfo> list(){
        List<IntakePlantInfo> intakePlantInfos=intakePlantInfoService.selectList(null);
        if(intakePlantInfos==null){
            throw new CustomException(ResultCode.NULL);


        }
        return intakePlantInfos;
    }
    @PassToken
    @GetMapping("/consumes")
    public List<SaftyAppConsumersVo> saftyAppConsumersVos(){
        List<SaftyAppConsumersVo> saftyAppConsumersVos;
        saftyAppConsumersVos=new ArrayList<>();
        SaftyAppConsumersVo saftyAppConsumersVo;

        List<IntakePlantInfo> intakePlantInfos=intakePlantInfoService.selectList(null);

//        List<EnvironPara> environParas=environParaService.selectList(null);
        for(IntakePlantInfo intakePlant:intakePlantInfos){

            saftyAppConsumersVo=new SaftyAppConsumersVo();
            saftyAppConsumersVo.setId(intakePlant.getIntakePlantId());
            saftyAppConsumersVo.setName(intakePlant.getIntakePlantName());
            saftyAppConsumersVo.setLatitude(intakePlant.getIntakePlantLat());
            saftyAppConsumersVo.setLongtitude(intakePlant.getIntakePlantLong());
//            saftyAppConsumersVo.setType("目前灭有该字段");
//            Map<String,Object> thismap=new HashMap<>();
//            thismap.put("intakePlantId",intakePlant.getIntakePlantId());
//            List<Object> securityParas1=securityParaService.selectObjs(new QueryWrapper);
            //这里可以写很多的eq,betwwten 等等
            List<SecurityPara> thisSecurityParas=securityParaService.selectList(new EntityWrapper<SecurityPara>().eq("INTAKE_PLANT_ID",intakePlant.getIntakePlantId())) ;
            for (SecurityPara securityPara:thisSecurityParas){
                saftyAppConsumersVo.setType(securityPara.getConstructionWasteType());
                saftyAppConsumersVo.setArea(securityPara.getConstructionWasteSize());
                //volume
                saftyAppConsumersVo.setVolume("目前不确定");
                saftyAppConsumersVo.setVedio(securityPara.getSecurityParaData1());


            }
            List<EnvironPara> thisenvironParas=environParaService.selectList(new EntityWrapper<EnvironPara>().eq("INTAKE_PLANT_ID",intakePlant.getIntakePlantId())) ;
            for(EnvironPara environPara:thisenvironParas){
                saftyAppConsumersVo.setEnvironparaid(environPara.getEnvironParaId());
                saftyAppConsumersVo.setSafepara(environPara.getSafePara());
                saftyAppConsumersVo.setWaterpara(environPara.getWaterPara());
                saftyAppConsumersVo.setSolfpara(environPara.getSoilPara());
                saftyAppConsumersVo.setAtmpara(environPara.getAtmPara());
                saftyAppConsumersVo.setWarnpara(environPara.getWarnPara());


            }
            saftyAppConsumersVos.add(saftyAppConsumersVo);


        }



        return saftyAppConsumersVos;

    }




}

