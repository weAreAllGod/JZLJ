package cn.edu.bjtu.jzlj.service.impl;

import cn.edu.bjtu.jzlj.domain.EnvironPara;
import cn.edu.bjtu.jzlj.service.EnvironParaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class EnvironParaServiceImplTest {
    @Autowired
EnvironParaService environParaService;
    public List<EnvironPara> list(){

        List<EnvironPara> environParas=environParaService.selectList(null);
        return environParas;
    }
}