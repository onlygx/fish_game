package com.elangzhi.fish.controller.game;

import com.elangzhi.fish.controller.json.Tip;
import com.elangzhi.fish.model.Game;
import com.elangzhi.fish.model.Person;
import com.elangzhi.fish.services.GameService;
import com.elangzhi.fish.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by GaoXiang on 2016/1/20 0020.
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    @RequestMapping("/setting")
    public ModelAndView setting(ModelMap model){
        Game game = gameService.findNew();
        model.put("game",game);
        if(game != null){
            List<Person> persons = personService.listByGameType(game.getId(),20);
            model.put("persons",persons);
        }
        return new ModelAndView("person/setting",model);
    }


    @RequestMapping("/save")
    @ResponseBody
    public Tip save(Person person){
        try {
            person.setNumber(genNumber(personService.findNewNumber(person.getGameId())));
            Long id = personService.save(person);
            return new Tip(id.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }
    }

    public Integer genNumber(Person old){
        if(old == null){
            return 1001;
        }else{
            return old.getNumber() + 1;
        }
    }

    @RequestMapping("/lucky/{id}")
    public ModelAndView lucky(@PathVariable Long id, HttpServletRequest request, ModelMap model){

        model.put("persons",personService.listByGame(id));

        return new ModelAndView("person/lucky",model);
    }

    @RequestMapping("/{id}")
    public ModelAndView show(@PathVariable Long id, HttpServletRequest request, ModelMap model){

        model.put("obj",personService.findById(id));

        return new ModelAndView("person/print",model);
    }

    @RequestMapping("/print/{id}")
    public ModelAndView print(@PathVariable Long id, HttpServletRequest request, ModelMap model){

        model.put("obj",personService.findById(id));

        return new ModelAndView("person/print",model);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Tip delete(@RequestParam(value="id", required=false) Long id){

        try {
            personService.deleteById(id);
        }catch (Exception e){
            return new Tip(1);
        }
        return new Tip();
    }


    //------- services --------
    @Resource
    PersonService personService;

    @Resource
    GameService gameService;
}
