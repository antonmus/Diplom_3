# Diplom_3
Особенности запуска автотестов
По умолчанию тесты проходят в Chrome.

Для запуска тестов в Яндекс браузере введи команду:
mvn clean test -Dbrowser=yandex

Для получения отчета allure введи:
mvn clean test
mvn allure:serve  
