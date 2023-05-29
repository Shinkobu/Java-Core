/*
Создать проект из трёх классов (основной с точкой входа и два класса в другом пакете),
которые вместе должны составлять одну программу, позволяющую
производить четыре основных математических действия и осуществлять форматированный
вывод результатов пользователю (ИЛИ ЛЮБОЕ ДРУГОЕ ПРИЛОЖЕНИЕ НА ВАШ ВЫБОР, которое просто демонстрирует работу некоторого механизма).

Пример моего приложения я прикрепил к материалам урока.

Необходимо установить Docker Desktop.
Создать Dockerfile, позволяющий откопировать исходный код вашего приложения в образ для демонстрации работы вашего
приложения при создании соответствующего контейнера.

Подобную процедуру мы с вами проделали на уроке, теперь необходимо проделать данную процедуру самостоятельно.
 */

import Methods.Decorator;
import Methods.MyOperations;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        result = MyOperations.sum(2,3);
        System.out.println(Decorator.decorate(result));
        result = MyOperations.multi(2,3);
        System.out.println(Decorator.decorate(result));
        result = MyOperations.division(2,3);
        System.out.println(Decorator.decorate(result));
        result = MyOperations.reduction(2,3);
        System.out.println(Decorator.decorate(result));
    }
}
