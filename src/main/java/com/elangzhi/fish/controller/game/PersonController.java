package com.elangzhi.fish.controller.game;

import com.elangzhi.fish.controller.json.Tip;
import com.elangzhi.fish.model.Person;
import com.elangzhi.fish.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/1/20 0020.
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    @RequestMapping("/save")
    @ResponseBody
    public Tip save(Person person){
        try {
            personService.save(person);
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }
    }




    //------- services --------
    @Resource
    PersonService personService;
}
