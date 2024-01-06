package ru.netology.Mockito;

public class FilmManager {

    private String[] films = new String[0];
    int limit;

    public FilmManager() {      // конструктор для лимита по умолчанию 5
        limit = 5;
    }

    public FilmManager(int limit) {     // конструктор для лимита по запросу
        this.limit = limit;
    }

    public void addFilm(String film) {             // добавляем фильм
        String[] tmp = new String[films.length + 1];  // Создаем новый массив и добавляем временную ячейку на один больше предыдущего
        for (int i = 0; i < films.length; i++) {    // перебираем ячейки массива
            tmp[i] = films[i];                      // Копируем фильмы во временный массив tmp i-той ячейки
        }
        tmp[tmp.length - 1] = film;                     // Вычисляем номер последней ячейки: длина массива - 1. Кладем туда фильм
        films = tmp;                                // Переносим массив из tmp в films
    }

    public String[] findAll() {
        return films;                               // возвращаем все фильмы
    }

    public String[] findLast() {                    // Выводим добавленные фильмы в обратном порядке
        int resultLength;                          // Определение ожидаемого размера результирующего массива-ответа
        if (limit < films.length) {
            resultLength = limit;
        } else {
            resultLength = films.length;
        }
        String[] result = new String[resultLength]; // создание массива строк
        for (int i = 0; i < result.length; i++) {    // перебираем ячейки массива
            result[i] = films[films.length - i - 1];  // заполнение массива в обратном порядке. в перую ячейку result[0] кладем последнюю ячейку films и т.д. в цикле
        }
        return result;                                  // возвращаем result
    }
}
