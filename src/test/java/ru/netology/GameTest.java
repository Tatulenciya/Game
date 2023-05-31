package ru.netology;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class GameTest {

    @Test
    public void secondPlayerWin() {
        Player luntick = new Player(324, "Лунтик", 1_200);
        Player gamer3000 = new Player(123, "Геймер3000", 3_000);
        Game game = new Game();

        game.register(luntick);
        game.register(gamer3000);
        int actual = game.round("Лунтик", "Геймер3000");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWin() {
        Player luntick = new Player(324, "Лунтик", 1_200);
        Player gamer3000 = new Player(123, "Геймер3000", 3_000);
        Game game = new Game();

        game.register(luntick);
        game.register(gamer3000);
        int actual = game.round("Геймер3000", "Лунтик");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawWin() {
        Player luntick = new Player(324, "Лунтик", 3_000);
        Player gamer3000 = new Player(123, "Геймер3000", 3_000);
        Game game = new Game();

        game.register(luntick);
        game.register(gamer3000);
        int actual = game.round("Геймер3000", "Лунтик");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        Player luntick = new Player(324, "Лунтик", 1_200);
        Player gamer3000 = new Player(123, "Геймер3000", 3_000);
        Game game = new Game();

        game.register(luntick);
        game.register(gamer3000);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Геймер", "Лунтик"));
    }

    @Test
    public void secondPlayerNotRegistered() {
        Player luntick = new Player(324, "Лунтик", 1_200);
        Player gamer3000 = new Player(123, "Геймер3000", 3_000);
        Game game = new Game();

        game.register(luntick);
        game.register(gamer3000);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Геймер3000", "Лунатик"));
    }

    @Test
    public void bothPlayerNotRegistered() {
        Player luntick = new Player(324, "Лунтик", 1_200);
        Player gamer3000 = new Player(123, "Геймер3000", 3_000);
        Game game = new Game();

        game.register(luntick);
        game.register(gamer3000);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Геймер", "Лунатик"));
    }

}