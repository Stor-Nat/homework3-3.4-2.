package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class AfishaRepositoryTest {

    private AfishaRepository repository = new AfishaRepository();
    private MoviePoster first = new MoviePoster(1, 1, "first", 1, 1);

    @Test
    public void shouldFindById() {
        repository.save(first);
        int idToFind = 1;

        MoviePoster actual = repository.findById(idToFind);
        assertEquals(first, actual);
    }

    @Test
    public void shouldNotFindById() {
        repository.save(first);
        int idToFind = 4;

        MoviePoster expected = null;
        MoviePoster actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.save(first);
        repository.removeAll();

        MoviePoster[] actual = repository.findAll();
        MoviePoster[] expected = new MoviePoster[]{};
        assertArrayEquals(expected, actual);
    }

}