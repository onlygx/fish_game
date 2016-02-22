package com.elangzhi.fish.controller.game;

import com.elangzhi.fish.controller.json.Tip;
import com.elangzhi.fish.model.Game;
import com.elangzhi.fish.model.Grade;
import com.elangzhi.fish.model.Person;
import com.elangzhi.fish.services.GameService;
import com.elangzhi.fish.services.GradeService;
import com.elangzhi.fish.services.PersonService;
import com.elangzhi.fish.tools.UUIDFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @RequestMapping("/firstChouHao")
    @ResponseBody
    public Grade firstChouHao(@RequestParam("id") Long id){
        Game game = gameService.findNew();
        Person person = personService.findById(id);
        List<Grade> quCount = gradeService.countQu(game.getId());
        try {

            for(int i = 0 ; i < game.getQu(); i ++){
                List<Grade> gradeCount = gradeService.findInfo1(game.getId(),1,i+1);
                if(gradeCount.size() == 0){
                    return addGrade(game.getId(),id,i+1,1,person);
                }
            }

            return addGrade(game.getId(),id,quCount.get(0).getQu(),quCount.get(0).getQuCount()+1,person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addGrade(game.getId(),id,quCount.get(0).getQu(),quCount.get(0).getQuCount()+1,person);
    }

    public Grade addGrade(Long gameId,Long personId,Integer qu,Integer number,Person person){
        Grade grade = new Grade();
        grade.setChang(1);
        grade.setPersonId(personId);
        grade.setGameId(gameId);
        grade.setQu(qu);
        grade.setRoom(number);
        grade.setPersonName(person.getName());
        grade.setPersonNumber(person.getNumber());
        gradeService.save(grade);
        return grade;
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

    @Resource
    GradeService gradeService;
}
