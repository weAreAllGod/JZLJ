# JZLJ
> 建筑垃圾精准管控与示范平台

本项目基于springboot2.1.4开发，java版本1.8

## 重要说明

> **重要类库说明**

* **druid**数据源：可通过`项目路径/druid`可访问后台sql访问情况，具体使用可参考[SpringBoot使用Druid数据源](https://blog.csdn.net/saytime/article/details/78963121)
* **swagger2**开发api：可通过`项目路径//swagger-ui.html`可访问后台sql访问情况<br>
编写controller要注意注解，可参考[Swagger2的集成和使用](http://www.importnew.com/29514.html)
* **logbom**简化代码：记录日志，生成domain时可以使用，可参考[使用Lombok来优雅的编码](https://www.cnblogs.com/qnight/p/8997493.html)。
**IDEA需要安装logbom插件，以防止报错；IDEA设置里打开`Annotation Processors > Enable annotation processing`，不然编译报错**
* **guava**工具：方便处理一些简单逻辑，可参考[Google Guava官方教程（中文版）](http://ifeve.com/google-guava/)
* **jackson**处理json：**已经在`cn.edu.bjtu.jzlj.config.CustomConfig`为容器中注入ObjectMapper**，可自动注入直接使用，可参考[Jackson快速入门](https://blog.csdn.net/u011054333/article/details/80504154)
<br>

> **关于静态资源引入说明**<br>
* 项目中常用的第三方静态文件采用webjars的方式，具体使用参考[SpringBoot 使用WebJars统一管理静态资源](https://www.jianshu.com/p/66d1b35bcd9d)<br>

> **关于异常处理说明**<br>
* 项目中采用统一异常处理，具体参考了[ErrorController与@ControllerAdvice区别和用法](https://blog.csdn.net/jwf111/article/details/88571067)
* 已经定义的异常类型参考 `cn.edu.bjtu.jzlj.exception.CustomException`；具体的错误信息可以参考`cn.edu.bjtu.jzlj.contant.ResultCode`，开发中自定义的异常信息可以继承此类或直接在里面添加,为避免重复可以以第一个数字区分，比如王2、张3、尚4、梁5、吴6
* 全局异常处理类：`cn.edu.bjtu.jzlj.exception.handler.GlobalExceptionHandler`
* 关于自定义异常的抛出，暂时可以参考`cn.edu.bjtu.jzlj.controller.CarCarryInfoController`
```
@RestController
@RequestMapping("/carCarryInfo")
@Api(tags="车辆承载信息API") //api生成信息
@Slf4j // 开启日志，可以直接使用log
public class CarCarryInfoController {

    @Autowired
    CarCarryInfoService carCarryInfoService;

    @GetMapping("/cci")
    @ApiOperation(value="信息列表")
    public List<CarCarryInfo> list(){
        List<CarCarryInfo> carCarryInfos = carCarryInfoService.selectList(null);

        log.warn(carCarryInfos.toString()); // 日志举例
        if (carCarryInfos != null) {
//            空异常抛出
            throw new CustomException(ResultCode.NULL);
        }
        return carCarryInfos;
    }
}
```
<br>

> **关于mybatis说明**<br>
* 项目中采用的mybatis-plus，拓展功能说明可参考[MyBatis Plus 入门使用](https://blog.csdn.net/codejas/article/details/81054791)。
基于拓展功能，项目中已自动生成controller、domain、mapper、service、service.impl，业务逻辑可以直接写在相应的类里；
* 【注意】：利用拓展中crud的功能，能简化代码量，但是，**为使实体类与表对应，现在必须用上@TableName和@ApiModelProperty，来使驼峰命名和下划线命名方式对应**，目前还没有找到偷懒的办法~.~

> **关于jwt说明**<br>
* 可参考[SpringBoot使用JWT实现登录验证](https://segmentfault.com/a/1190000012874052)，项目要求将token放在请求头的`Authorization`，可通过自定义的`@PassToken`注解来取消jwt检验，默认`/user/login`已经不用检验

## 项目结构说明
* 包结构说明如下

| 包名 | 说明 | 建议 |
| :------| :------ | :------ |
| cn.edu.bjtu.jzlj.annotation | 自定义注解类 |  |
| cn.edu.bjtu.jzlj.component | 组件类，包括拦截器、监听器等 |  |
| cn.edu.bjtu.jzlj.contant | 常量类 |  |
| cn.edu.bjtu.jzlj.controller | 控制类 |  |
| cn.edu.bjtu.jzlj.domain | 实体类 | 前端交互变量建议放在vo |
| cn.edu.bjtu.jzlj.exception | 自定义异常类 |  |
| cn.edu.bjtu.jzlj.mapper | mapper类 |  |
| cn.edu.bjtu.jzlj.service | 服务接口 |  |
| cn.edu.bjtu.jzlj.service.impl | 服务实现类 |  |
| cn.edu.bjtu.jzlj.util | 工具类 |  |
| cn.edu.bjtu.jzlj.vo | 表现层对象类 | [PO/POJO/BO/DTO/VO的区别](https://www.cnblogs.com/yeyuchangfeng/p/4546138.html) |
| cn.edu.bjtu.jzlj.bo | 业务对象类 | [PO/POJO/BO/DTO/VO的区别](https://www.cnblogs.com/yeyuchangfeng/p/4546138.html) |
| cn.edu.bjtu.jzlj.Application | 主程序启动对象 |  |

* 资源结构如下（[静态资源的访问和配置](https://blog.csdn.net/plei_yue/article/details/79360645)）

| 文件夹 | 说明 | 建议 |
| :------| :------ | :------ |
| mapper | mapper文件 | 非必须 |
| public | 可直接访问 | 存放html文件，每人可分为不同文件夹 |
| static.assets | 存放vue等相关文件 |  |
| static.css | 存放css文件 |  |
| static.fonts | 存放字体文件 |  |
| static.img | 存放图片文件 |  |
| static.js | 存放js文件 |  |
| static/index.html | 首页 |  |
| application.properties | 主配置文件 |  |
| logback-spring.xml | 日志配置文件 |  |
| mybatis-config.xml | mybatis配置文件 |  |


## RESTFUL风格
* CRUD映射规要满足rest风格，具体要求和例子参考[RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)
* 建议参考`cn.edu.bjtu.jzlj.controller.CarCarryInfoController`，以`/carCarryInfo/ccis`为例，是对全部车载信息的请求，cci为首字母缩写。
* 统一的回复格式,`success`字段表示是否成功，`data`字段表示数据信息，样例如下
```
{
	"success": true,
	"code": 10000,
	"message": "操作成功！",
	"data": [{
		"carId": "2",
		"carNo": "2",
		"fleet": "2",
		"carUnit": "2",
		"linkman": "2",
		"phoneNo": "2",
		"weight": "2",
		"weightUnit": "2",
		"inputName": "2",
		"inputTime": "2019-04-19 00:54:00",
		"content": "2"
	}, {
		"carId": "3",
		"carNo": "3",
		"fleet": "3",
		"carUnit": "3",
		"linkman": "3",
		"phoneNo": "3",
		"weight": "3",
		"weightUnit": "3",
		"inputName": "3",
		"inputTime": "2019-04-18 01:04:00",
		"content": "3"
	}]
}
```

## 其他
* [IDEA中Git的使用](https://www.cnblogs.com/javabg/p/8567790.html)



