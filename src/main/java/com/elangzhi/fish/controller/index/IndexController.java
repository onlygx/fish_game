package com.elangzhi.fish.controller.index;

import com.elangzhi.fish.controller.json.Tip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by GaoXiang on 2015/10/22 0022.
 */

@Controller
//@RequestMapping("/")
public class IndexController {

    @RequestMapping("/game")
    public ModelAndView showCall(HttpServletRequest request,ModelMap model){
        model.put("indexTest","结果1");
        return new ModelAndView("index",model);
    }


    @RequestMapping("/saveTest")
    @ResponseBody
    public Tip saveTest(@RequestParam String name){

        System.out.println(name);
        return new Tip();
    }

}
