package com.rock_paper_scissor.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component
@EnableWebMvc
public class Game {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("rock", "paper", "scissor"));

    public String randomMoveGenerator(){ // random function
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    Logger logger = LoggerFactory.getLogger(Game.class);

    public String handle(String userInput) {
        String userInp = userInput.toLowerCase(); // for better execution
        String compChoice = randomMoveGenerator();
        if(list.contains(userInp)) {
            logger.info("Computer generated " + compChoice);
            if (userInp.equals(compChoice)) {
                return "[You choose : " + userInp + "]" + " , " + "[Computer choose : " + compChoice + "]" + " -> " + "So TIE";
            }
            if (userInp.equals(list.get(0)) && compChoice.equals(list.get(2))) {
                return "[You choose : " + list.get(0) + "]" + " , " + "[Computer choose : " + list.get(2) + "]" + " -> " + "So You Win";
            }
            if (userInp.equals(list.get(1)) && compChoice.equals(list.get(0))) {
                return "[You choose : " + list.get(1) + "]" + " , " + "[Computer choose : " + list.get(0) + "]" + " -> " + "So You Win";
            }
            if (userInp.equals(list.get(2)) && compChoice.equals(list.get(1))) {
                return "[You choose : " + list.get(2) + "]" + " , " + "[Computer choose : " + list.get(1) + "]" + " -> " + "So You Win";
            }
            return "[You choose : " + userInp + "]" + " , " + "[Computer choose : " + compChoice + "]" + " -> " + "So Computer Win";
        }
        return "You choose " + userInput + ", it's invalid. " + "Please choose b/w rock, paper and scissor";
    }

    public String s1(){
        return list.get(0);
    }
    public String s2(){
        return list.get(1);
    }
    public String s3(){
        return list.get(2);
    }
}
