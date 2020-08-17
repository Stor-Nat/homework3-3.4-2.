package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MoviePoster;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTestNonEmpty {
  @Mock
  private AfishaRepository repository;
  @InjectMocks
  private AfishaManager manager;
  private MoviePoster first = new MoviePoster(1, 1, "first", 1, 1);
  private MoviePoster second = new MoviePoster(2, 2, "second", 1, 1);
  private MoviePoster third = new MoviePoster(3, 3, "third", 1, 1);

  @BeforeEach
  public void setUp() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
  }

  @Test
  public void shouldRemoveIfExists() {
    int idToRemove = 1;
    // настройка заглушки
    MoviePoster[] returned = new MoviePoster[]{second, third};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).removeById(idToRemove);

    manager.removeById(idToRemove);
    MoviePoster[] expected = new MoviePoster[]{third, second};
    MoviePoster[] actual = manager.getAll();
    assertArrayEquals(expected, actual);

    // удостоверяемся, что заглушка была вызвана с нужным значением
    // но это уже проверка "внутренней" реализации
    verify(repository).removeById(idToRemove);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 4;
    MoviePoster[] returned = new MoviePoster[]{first, second, third};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).removeById(idToRemove);

    manager.removeById(idToRemove);
    MoviePoster[] expected = new MoviePoster[]{third, second, first};
    MoviePoster[] actual = manager.getAll();

    assertArrayEquals(expected, actual);
    // удостоверяемся, что заглушка была вызвана с нужным значением
    // но это уже проверка "внутренней" реализации
    verify(repository).removeById(idToRemove);
  }
}