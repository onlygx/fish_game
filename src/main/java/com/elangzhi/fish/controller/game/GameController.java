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
        model.put("game",gameService.findById(888888l));
        return new ModelAndView("game/setting",model);
    }


    @RequestMapping("/update")
    @ResponseBody
    public Tip update(Game game){
        gameService.updateById(game);
        return new Tip();
    }

    // --- service ---------
    @Resource
    GameService gameService;
}
