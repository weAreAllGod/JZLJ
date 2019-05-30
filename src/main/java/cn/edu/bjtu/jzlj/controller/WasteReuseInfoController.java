package cn.edu.bjtu.jzlj.controller;


import cn.edu.bjtu.jzlj.annotation.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiuYi
 * @since 2019-04-17
 */
@Controller
@RequestMapping("/wasteReuseInfo")
public class WasteReuseInfoController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PassToken
    @GetMapping(value = "/hello")
    public List getStuList(){
        //查询受纳场的信息
        String sql = "select * from INTAKE_PLANT_INFO";
        List list =  jdbcTemplate.queryForList(sql);

        //查询受纳场的具体安全系数
        String sql1 ="select * from SECURITY_PARA";
        List list1 =  jdbcTemplate.queryForList(sql1);

        //查询产生源的信息
        String sql2 = "select * from SOURCE_INFO";
        List list2 =  jdbcTemplate.queryForList(sql2);


        //查询受纳场源的数据条数
        String sql4="select COUNT(INTAKE_PLANT_ID) as IPI from INTAKE_PLANT_INFO";
        List list4 =jdbcTemplate.queryForList(sql4);

        //查询产生源的条数
        String sql5="select COUNT(SOURCE_ID) as SI from SOURCE_INFO";
        List list5 =jdbcTemplate.queryForList(sql5);

        //查询产生源具体信息


        List<String> list7=new ArrayList<String>();
        //添加信息
        list7.addAll(list);
        list7.addAll(list1);
        list7.addAll(list2);

        //添加数据条数
        list7.addAll(list4);
        list7.addAll(list5);

        return list7;
    }


}

