package com.example.sport.Service.Impl;

import com.example.sport.Bean.GamesBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.sql.Timestamp;


/**
 * @author 小王同学
 * @version 1.0
 * @date 2022/4/15 18:24
 */
@SpringBootTest
public class GamesServiceTest {
    @Resource
    GamesServiceImpl gamesService;

    @Test
    public void testInsertGame() {
        Timestamp start = Timestamp.valueOf("2022-04-15 10:30:10");
        Timestamp end = Timestamp.valueOf("2022-04-15 11:10:20");
//        GamesBean game = new GamesBean(2, "400米", 1, 1, 2, 10, 1, start, end, start);
//        System.out.println(gamesService.insertGame(game));
    }

    @Test
    public void testDelGame() {
        System.out.println(gamesService.delGame(2));
    }

    @Test
    public void testUpdateGame() {
//        Timestamp start = Timestamp.valueOf("2022-04-15 9:30:10");
//        Timestamp end = Timestamp.valueOf("2022-04-15 11:10:20");
//        GamesBean game = new GamesBean(2, "400米接力", 1, 0, 2, 8, 1, start, end, start);
//        System.out.println(gamesService.updateGame(game));
    }

    @Test
    public void testGetGame() {
        System.out.println(gamesService.getGame(1, 10));
    }

    @Test
    public void testCountGames() {
        System.out.println(gamesService.countGames());
    }
}
