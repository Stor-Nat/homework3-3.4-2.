package ru.netology.repository;

import ru.netology.domain.MoviePoster;

public class AfishaRepository {
  private MoviePoster[] items = new MoviePoster[0];

  //  добавляет объект в массив
  public void save(MoviePoster item) {
    int length = items.length + 1;
    MoviePoster[] tmp = new MoviePoster[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  //  возвращает массив всех хранящихся в массиве объектов
  public MoviePoster[] findAll() {
    return items;
  }

  //  удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
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

  //  возвращает объект по идентификатору (либо null, если такого объекта нет)
  public MoviePoster findById(int id) {
    for (MoviePoster item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  //  полностью вычищает репозиторий
  public void removeAll() {
    items = new MoviePoster[0];
  }

}
