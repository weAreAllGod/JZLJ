package cn.edu.bjtu.jzlj.controller;

import cn.edu.bjtu.jzlj.contant.EmptyResult;
import cn.edu.bjtu.jzlj.contant.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: LiuYi
 * @date: 2019/4/18 17:39
 */

//@RequestMapping("${server.error.path:${error.path:/error}}")
@Controller
public class CustomErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Autowired
    ObjectMapper objectMapper;

    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * web页面错误处理
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    @ResponseBody
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ServletWebRequest requestAttributes = new ServletWebRequest(request);
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        EmptyResult emptyResult = new EmptyResult(false, (int) attr.get("status"), (String) attr.get("message"));
        return objectMapper.writeValueAsString(emptyResult);
    }

    /**
     * 除web页面外的错误处理，比如json/xml等
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Result errorApiHander(HttpServletRequest request) {
        ServletWebRequest requestAttributes = new ServletWebRequest(request);
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        return new EmptyResult(false, (int) attr.get("status"), (String) attr.get("message"));
    }

}
