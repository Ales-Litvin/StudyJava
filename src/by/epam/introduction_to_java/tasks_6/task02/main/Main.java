package by.epam.introduction_to_java.tasks_6.task02.main;

/*
 * Задание 2. Блокнот. Разработать консольное приложение, работающее с
 * Заметками в Блокноте.
 * Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).
 * Общие пояснения к практическому заданию.
 * • В начале работы приложения данные должны считываться из файла, в конце
 * работы – сохраняться в файл.
 * • У пользователя должна быть возможность найти запись по любому параметру
 * или по группе параметров (группу параметров можно определить
 * самостоятельно), получить требуемые записи в отсортированном виде, найти
 * записи, текстовое поле которой содержит определенное слово, а также
 * добавить новую запись.
 * • Особое условие: поиск, сравнение и валидацию вводимой информации
 * осуществлять с использованием регулярных выражений.
 * • Особое условие: проверку введенной информации на валидность должен
 * осуществлять код, непосредственно добавляющий информацию.
 */

import by.epam.introduction_to_java.tasks_6.task02.view.View;
import by.epam.introduction_to_java.tasks_6.task02.entity.Note;
import by.epam.introduction_to_java.tasks_6.task02.loader.DataLoader;
import by.epam.introduction_to_java.tasks_6.task02.utils.NoteDao;


public class Main {
    public static void main(String[] args) {
        DataLoader<Note> userDataLoader = new DataLoader<>(
                "./src/by_epam/introduction_to_java/tasks_6/task02/resources/notes.txt"
        );

        NoteDao noteDao = new NoteDao(userDataLoader);

        View view = new View(noteDao);

        view.action();

    }
}
