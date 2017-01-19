package com.seeu.task.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.task.model.TaskComment;
import com.seeu.task.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("task")
public class TaskCommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    TurnBackUtil turnBackUtil;

    @RequestMapping("comment")
    public String commentIt(@RequestAttribute("UID") Integer UID, @ModelAttribute TaskComment comment) {
        if (comment == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "评论失败", null);

        comment.setCommentUID(UID);
        return commentService.commentIt(comment);
    }

    @RequestMapping("delcomment")
    public String delComment(@RequestAttribute("UID") Integer UID, @RequestParam("commentID") Integer commentID) {
        return commentService.delComment(UID,commentID);
    }
}
