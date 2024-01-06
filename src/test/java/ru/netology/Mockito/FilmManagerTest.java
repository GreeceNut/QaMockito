package ru.netology.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    FilmManager manager = new FilmManager();

    String film1 = "Крепкий орешек 1";
    String film2 = "Крепкий орешек 2";
    String film3 = "Крепкий орешек 3";
    String film4 = "Крепкий орешек 4";
    String film5 = "Крепкий орешек 5";
    String film6 = "Крепкий орешек 6";

    @BeforeEach

    public void setup() {
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);
    }

    @Test

    public void testFindAll() {
        String[] actual = manager.findAll();
        String[] expected = {
                "Крепкий орешек 1",
                "Крепкий орешек 2",
                "Крепкий орешек 3",
                "Крепкий орешек 4",
                "Крепкий орешек 5",
                "Крепкий орешек 6"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLast() {

        String[] actual = manager.findLast();
        String[] expected = {
                "Крепкий орешек 6",
                "Крепкий орешек 5",
                "Крепкий орешек 4",
                "Крепкий орешек 3",
                "Крепкий орешек 2"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLimitLessThenSize2() {
        FilmManager manager = new FilmManager(3);

        String film1 = "Крепкий орешек 1";
        String film2 = "Крепкий орешек 2";
        String film3 = "Крепкий орешек 3";
        String film4 = "Крепкий орешек 4";
        String film5 = "Крепкий орешек 5";
        String film6 = "Крепкий орешек 6";


        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);

        String[] actual = manager.findLast();
        String[] expected = {
                "Крепкий орешек 6",
                "Крепкий орешек 5",
                "Крепкий орешек 4",};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLimitMoreThenSize() {
        FilmManager manager = new FilmManager(3);

        String film1 = "Крепкий орешек 1";
        String film2 = "Крепкий орешек 2";

        manager.addFilm(film1);
        manager.addFilm(film2);

        String[] actual = manager.findLast();
        String[] expected = {
                "Крепкий орешек 2",
                "Крепкий орешек 1"};

        Assertions.assertArrayEquals(expected, actual);
    }
}

