package com.seeu.task.controller;

import com.seeu.task.service.LikerClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("task")
public class TaskLikerClickItController {

    @Autowired
    LikerClickService likerClickService;

    @RequestMapping(value = "like",method = RequestMethod.POST)
    public String likeIt(@RequestAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        return likerClickService.likeIt(UID, TID);
    }

    @RequestMapping(value = "dislike",method = RequestMethod.POST)
    public String dislikeIt(@RequestAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        return likerClickService.dislikeIt(UID, TID);
    }
}
