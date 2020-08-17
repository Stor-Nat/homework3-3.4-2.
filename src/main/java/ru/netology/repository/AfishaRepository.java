package ru.netology.repository;

import ru.netology.domain.MoviePoster;

public class AfishaRepository {
  private MoviePoster[] items = new MoviePoster[0];

  public void save(MoviePoster item) {
    int length = items.length + 1;
    MoviePoster[] tmp = new MoviePoster[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public MoviePoster[] findAll() {
    return items;
  }

  public void removeById(int id) {
    int length = items.length - 1;
    MoviePoster[] tmp = new MoviePoster[length];
    int index = 0;
    for (MoviePoster item : items) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    items = tmp;
  }
}
