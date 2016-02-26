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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoXiang on 2016/1/20 0020.
 */

@Controller
@RequestMapping("/grade")
public class GradeController {

    @RequestMapping("/jifen/{gameId}")
    @ResponseBody
    public Tip jifen(@PathVariable Long gameId,ModelMap model){
        try {
            Game game = gameService.findById(gameId);
            for(int i = 1 ;i<=game.getChang();i++){
                List<Grade> grades = gradeService.jifen(gameId,i);
                //初始化
                for(int j = 0;j<grades.size() ; j ++){
                    grades.get(j).setGrade(j+1.0);
                }

                for(int j = 0;j<grades.size() ; j ++){

                    List<Grade> temp = new ArrayList<>();
                    temp.add(grades.get(j));
                    for(int s = 0;s<grades.size() ; s ++){
                        if(grades.get(j).equals(grades.get(s))){
                            continue;
                        }
                        if(grades.get(0).getNumber() != null && grades.get(0).getNumber() != 0 ){
                            if(grades.get(s).getNumber() == grades.get(j).getNumber()){
                                temp.add(grades.get(s));
                                grades.remove(grades.get(s));
                                s--;
                            }
                        }else{
                            if(grades.get(s).getWeight() == grades.get(j).getWeight()){
                                temp.add(grades.get(s));
                                grades.remove(grades.get(s));
                                s--;
                            }
                        }

                    }
                    Double grade = 0.0;
                    for(Grade g : temp){
                        grade += g.getGrade();
                    }
                    for(Grade g : temp){
                        g.setGrade(grade/temp.size());
                        gradeService.updateById(g);
                    }
                }
            }
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }
    }


    @RequestMapping("/fafen")
    @ResponseBody
    public Tip fafen(Grade grade){
        try {
            Grade grade1 = gradeService.findByChangNumber(grade.getGameId(),grade.getChang(),grade.getPersonId());
            grade1.setRanking(grade.getRanking());
            gradeService.updateById(grade1);
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }
    }


    @RequestMapping("/show/{gameId}/{chang}/{qu}")
    public ModelAndView show1(@PathVariable Long gameId,@PathVariable Integer chang,@PathVariable Integer qu,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        model.put("qu",qu);
        List<Grade> grades = gradeService.gradeShow(gameId,chang,qu);

        model.put("grades",grades);
        return new ModelAndView("grade/show",model);
    }

    @RequestMapping("/show/{gameId}/{chang}")
    public ModelAndView show2(@PathVariable Long gameId,@PathVariable Integer chang,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        List<Grade> grades = gradeService.gradeShow(gameId,chang,null);
        model.put("grades",grades);
        return new ModelAndView("grade/show",model);
    }

    @RequestMapping("/show/{gameId}")
    public ModelAndView show3(@PathVariable Long gameId,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        List<Grade> grades = gradeService.zongfenShow(gameId);
        model.put("grades",grades);
        return new ModelAndView("grade/show-all",model);
    }


    @RequestMapping("/group/{gameId}/{chang}/{qu}")
    public ModelAndView groupShow1(@PathVariable Long gameId,@PathVariable Integer chang,@PathVariable Integer qu,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        model.put("qu",qu);
        List<Grade> grades = gradeService.groupShow(gameId,chang,qu);

        model.put("grades",grades);
        return new ModelAndView("grade/group-show",model);
    }

    @RequestMapping("/group/{gameId}/{chang}")
    public ModelAndView groupShow1(@PathVariable Long gameId,@PathVariable Integer chang,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        List<Grade> grades = gradeService.groupShow(gameId,chang,null);

        model.put("grades",grades);
        return new ModelAndView("grade/group-show",model);
    }


    @RequestMapping("/group/{gameId}")
    public ModelAndView groupShow1(@PathVariable Long gameId,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        List<Grade> grades = gradeService.groupShow(gameId,null,null);

        model.put("grades",grades);
        return new ModelAndView("grade/group-show",model);
    }

    @RequestMapping("/info/{gameId}/{chang}/{qu}")
    public ModelAndView info1(@PathVariable Long gameId,@PathVariable Integer chang,@PathVariable Integer qu,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        model.put("qu",qu);
        model.put("grades",gradeService.findInfo1(gameId,chang,qu));
        return new ModelAndView("grade/info",model);
    }

    @RequestMapping("/info/{gameId}/{chang}")
    public ModelAndView info2(@PathVariable Long gameId,@PathVariable Integer chang,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("chang",chang);
        model.put("grades",gradeService.findInfo1(gameId,chang,null));
        return new ModelAndView("grade/info",model);
    }

    @RequestMapping("/info/{gameId}")
    public ModelAndView info2(@PathVariable Long gameId,ModelMap model){
        Game game = gameService.findById(gameId);
        model.put("game",game);
        model.put("grades",gradeService.findInfo1(gameId,null,null));
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

    @RequestMapping("/saveValue")
    @ResponseBody
    public Tip saveValue(Grade grade){
        try {
            Grade grade1 = gradeService.findByGameChangPerson(grade.getGameId(),grade.getChang(),grade.getPersonId());
            if(grade1 != null){
                grade1.setWeight(grade.getWeight());
                grade1.setNumber(grade.getNumber());
                gradeService.updateById(grade1);
                return new Tip();
            }else{
                return new Tip(1);
            }
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
