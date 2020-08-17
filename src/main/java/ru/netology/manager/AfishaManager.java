package ru.netology.manager;

import ru.netology.domain.MoviePoster;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private AfishaRepository repository;

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  public void add(MoviePoster item) {
    repository.save(item);
  }

  public MoviePoster[] getAll() {
    MoviePoster[] items = repository.findAll();
    MoviePoster[] result = new MoviePoster[items.length];
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

  public void removeById(int id) {
    repository.removeById(id);
  }

    public void removeAll(MoviePoster item) {
      repository.removeAll(item);
    }
//    MoviePoster[] items = repository.findAll();
//    MoviePoster[] result = new MoviePoster[0];

}
