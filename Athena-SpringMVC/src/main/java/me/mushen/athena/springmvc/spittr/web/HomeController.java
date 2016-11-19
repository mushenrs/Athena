package me.mushen.athena.springmvc.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-10-23
 */
@Controller // 声明为一个控制器
@RequestMapping({"/", "/homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home"; // 返回视图名
    }
}
