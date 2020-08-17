package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class AfishaRepositoryTest {

    @Test
    public void shouldFindById() {
        int idToFind = 1;
        repositoty.findById(idToFind);

        MoviePoster[] expected = new MoviePoster[]{first};
        MoviePoster[] actual = repository.finfById();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {
        int idToFind = 4;
        repository.findById(idToFind);

        MoviePoster[] expected = null;
        MoviePoster[] actual = repository.findById();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.removeAll();

        MoviePoster[] actual = repositopy.findAll();
        MoviePoster[] expected = new MoviePoster[]{};
        assertArrayEquals(expected, actual);
    }

}