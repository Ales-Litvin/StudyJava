package by_epam.introduction_to_java.tasks_6.task03.entity.message;

public enum MessageType {
    USER_REQUEST,  // запрос на авторизацию пользователя

    USER_DATA,     // в сообщении отправлен объект тип User для авторизации

    USER_ACCEPTED, // пользователь зарегистрирован


    TEXT,

    // зачем пользователь прислал сообщение :) ? наверное хочет пообщаться

    DOSSIER, // в сообщении приходит объект

    // запрос на получение досье
    GET_DOSSIER,

    // запрос на изменение досье
    CHANGE_DOSSIER,

    // запрос на добавление досье
    ADD_DOSSIER,

    // ошибка в сообщенни придет текст ошибки
    ERROR,

    USER_ADDED,
    USER_REMOVED;
}