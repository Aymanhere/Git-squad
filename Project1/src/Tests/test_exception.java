package Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.rules.ExpectedException;

import CODE.ENTITY.hero;
import CODE.MANAGER.Game;
import CODE.WORLD.World;
import CODE.WORLD.World1;
import CODE.WORLD.World3;
@TestMethodOrder(Alphanumeric.class)
public class test_exception {
	
	@Test
	public void TestAInvalideFile()throws Exception {
		Game game3 = new Game("Game",1000,640);
		World world3=new World1(game3,"nothing",game3.ld);
	}

	@Test
	public void TestBInvalidepos()throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"/worlds/worlds.txt",game.ld);
		hero h=new hero(game,world,1500,1500);
	}
	
	
	@Test
	public void TestDWithInsufficientlinesAndColons()throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"/worlds/worlds4.txt",game.ld);
	}
	@Test
	public void TestEWithInvalideCaracters()throws Exception {
		Game game = new Game("Game",1000,640);
		World world=new World1(game,"/worlds/worlds5.txt",game.ld);
	}
	//à ajouter le test de déposer des unitéssur le mur
}

