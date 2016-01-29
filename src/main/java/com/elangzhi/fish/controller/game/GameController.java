package com.elangzhi.fish.controller.game;

import com.elangzhi.fish.controller.json.Tip;
import com.elangzhi.fish.model.Game;
import com.elangzhi.fish.model.Grade;
import com.elangzhi.fish.model.Person;
import com.elangzhi.fish.services.GameService;
import com.elangzhi.fish.services.GradeService;
import com.elangzhi.fish.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by GaoXiang on 2016/1/19 0019.
 */

@Controller
@RequestMapping("/game")
public class GameController {

    @RequestMapping("/setting")
    public ModelAndView setting(ModelMap model){
        Game game = gameService.findNew();
        model.put("game",game);
        if(game != null){
            List<Person> persons = personService.listExcludePersonTypeByGame(game.getId(),20);
            model.put("persons",persons);
        }
        return new ModelAndView("game/setting",model);
    }

    @RequestMapping("/show/{id}")
    public ModelAndView show(@PathVariable Long id, ModelMap model){
        Game game = gameService.findById(id);
        model.put("game",game);
        return new ModelAndView("game/down",model);
    }

    @RequestMapping("/downGame")
    @ResponseBody
    public Game down(){
        Game game = gameService.findNew();

        return game;
    }

    @RequestMapping("/downUser")
    @ResponseBody
    public List<Person> downUser(){
        Game game = gameService.findNew();
        List<Person> personList = personService.listByGame(game.getId());
        return personList;
    }

    @RequestMapping("/downGrade")
    @ResponseBody
    public List<Grade> downGrade(){
        Game game = gameService.findNew();
        List<Grade> gradeList = gradeService.listByGame(game.getId());
        return gradeList;
    }


    @RequestMapping("/save")
    @ResponseBody
    public Tip save(Game game){

        try {
            gameService.save(game);
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public Tip update(Game game){

        try {
            gameService.updateById(game);
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }
    }

    // --- service ---------
    @Resource
    GameService gameService;

    @Resource
    PersonService personService;

    @Resource
    GradeService gradeService;
}
