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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by GaoXiang on 2016/1/20 0020.
 */

@Controller
@RequestMapping("/grade")
public class GradeController {

    @RequestMapping("/show/{gameId}/{chang}/{qu}")
    public ModelAndView show1(@PathVariable Long gameId,@PathVariable Long chang,@PathVariable Long qu,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        model.put("qu",qu);

        return new ModelAndView("grade/show",model);
    }

    @RequestMapping("/show/{gameId}/{chang}")
    public ModelAndView show2(@PathVariable Long gameId,@PathVariable Long chang,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);

        return new ModelAndView("grade/show",model);
    }

    @RequestMapping("/info/{gameId}/{chang}/{qu}")
    public ModelAndView info1(@PathVariable Long gameId,@PathVariable Long chang,@PathVariable Long qu,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        model.put("qu",qu);

        return new ModelAndView("grade/info",model);
    }

    @RequestMapping("/info/{gameId}/{chang}")
    public ModelAndView info2(@PathVariable Long gameId,@PathVariable Long chang,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);

        return new ModelAndView("grade/info",model);
    }

    @RequestMapping("/save")
    @ResponseBody
    public Tip save(Grade grade){
        try {
            gradeService.save(grade);
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }
    }

    @RequestMapping("/{id}")
    public ModelAndView show1(@PathVariable Long id, HttpServletRequest request, ModelMap model){

        model.put("obj",gradeService.findById(id));

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
