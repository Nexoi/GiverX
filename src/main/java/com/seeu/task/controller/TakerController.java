package com.seeu.task.controller;

import com.TP;
import com.seeu.task.service.TakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("task")
public class TakerController {

    @Autowired
    TakerService takerService;

    @RequestMapping(value = "taker",method = RequestMethod.POST)
    public String itakeBidder(@ModelAttribute("UID") Integer UID, @RequestParam("TID") Integer TID, @RequestParam("bidderUID") Integer bidderUID) {
        return this.takerService.takeBidder(UID, TID, bidderUID);
    }

    @RequestMapping(value = "canceltaker",method = RequestMethod.POST)
    public String icancelBidder(@ModelAttribute("UID") Integer UID, @RequestParam("TID") Integer TID, @RequestParam("bidderUID") Integer bidderUID) {
        return this.takerService.cancelBidder(UID, TID, bidderUID);
    }

    @RequestMapping(value = "bidding2token",method = RequestMethod.POST)
    public String changeStatus1(@ModelAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        // 关闭竞选，开始任务流程
        return takerService.changeStatus(UID, TID, TP.TASK_STATUS_TOKEN);
    }

    @RequestMapping(value = "token2bidding",method = RequestMethod.POST)
    public String changeStatus2(@ModelAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        // 重新竞选，开始竞选流程
        return takerService.changeStatus(UID, TID, TP.TASK_STATUS_BIDDING);
    }

    @RequestMapping(value = "finishtask",method = RequestMethod.POST)
    public String changeStatus3(@ModelAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        // 关闭任务
        return takerService.changeStatus(UID, TID, TP.TASK_STATUS_CLOSED);
    }
}
