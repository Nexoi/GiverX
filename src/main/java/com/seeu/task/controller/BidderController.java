package com.seeu.task.controller;

import com.seeu.task.model.TaskBidder;
import com.seeu.task.service.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("task/bidder")
public class BidderController {

    @Autowired
    BidderService bidderService;

    // 查询竞标人列表 (所有登录过的人都可以查看)
    @RequestMapping(value = "querybidders",method = RequestMethod.POST)
    public String queryBidders(@RequestParam("TID") Integer TID) {
        return bidderService.queryBidders(TID);
    }

    // 竞标
    @RequestMapping(value = "bid",method = RequestMethod.POST)
    public String bidIt(@RequestAttribute("UID") Integer UID, @ModelAttribute TaskBidder bidder) {
        return bidderService.bidIt(UID, bidder);
    }

    // 取消竞标
    @RequestMapping(value = "cancelbidding",method = RequestMethod.POST)
    public String bidIt(@RequestAttribute("UID") Integer UID, @RequestParam("TID") Integer TID) {
        return bidderService.cancelBidding(UID, TID);
    }
}
