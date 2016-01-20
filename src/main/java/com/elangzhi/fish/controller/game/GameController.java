package com.elangzhi.fish.controller.game;

import com.elangzhi.fish.controller.json.Tip;
import com.elangzhi.fish.model.Game;
import com.elangzhi.fish.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/1/19 0019.
 */

@Controller
@RequestMapping("/game")
public class GameController {

    @RequestMapping("/setting")
    public ModelAndView setting(ModelMap model){
        model.put("game",gameService.findNew());
        return new ModelAndView("game/setting",model);
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
}
