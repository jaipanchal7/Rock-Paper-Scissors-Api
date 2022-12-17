package com.rock_paper_scissor.controller;

import com.rock_paper_scissor.services.Game;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    // @RequestMapping(value = "/test", method = RequestMethod.GET)
    // @ResponseBody

    @Autowired
    Game g1;

    @GetMapping("/{userInput}")
    @ApiOperation(value = "Choose b/w rock, paper and scissor",notes = "Please enter b/w rock, paper and scissor", response = Game.class)

    public String handle(
            @ApiParam(value = "Choose b/w rock, paper and scissor",required = true) @PathVariable("userInput") String userInput
    ){
        logger.trace("Handle method accessed");
        System.out.println(userInput);
        String ans = g1.handle(userInput);
        logger.debug(ans + "\n");
        return ans;
        // return userInput;
    }
}