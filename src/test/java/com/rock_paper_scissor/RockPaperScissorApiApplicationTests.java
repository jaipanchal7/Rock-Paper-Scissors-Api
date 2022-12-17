package com.rock_paper_scissor;

import com.rock_paper_scissor.Calculator;
import com.rock_paper_scissor.services.Game;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = Game.class)
class RockPaperScissorApiApplicationTests {

	@Test
	void contextLoads() {
	}

//	Calculator calculator = new Calculator();
//
//	@Test
//	void testSum(){ // for test purpose
//		// expected
//		int i = 8;
//		// actual
//		int j = calculator.doSum(4,2,2);
//		assertThat(j).isEqualTo(i);
//	}

	Logger logger = LoggerFactory.getLogger(RockPaperScissorApiApplicationTests.class);
	//	@Autowired
	Game game = new Game();

	@Test
	void playVal() {
		logger.info(game.handle("Rock") + ", when test case is Rock");
		logger.info(game.handle("Paper") + ", when test case is Paper");
		logger.info(game.handle("Scissor") + ", when test case is Scissor");
	}

	@Test
	void checkRockPresent() {
		String s1 = game.s1();
		assertThat("rock").isEqualTo(s1);
	}
	@Test
	void checkPaperPresent() {
		String s2 = game.s2();
		assertThat("paper").isEqualTo(s2);
	}
	@Test
	void checkScissorPresent() {
		String s3 = game.s1();
		assertThat("scissor").isEqualTo(game.s3());
	}
}