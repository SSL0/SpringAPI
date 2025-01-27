# SpringAPI

### Зависимости
Для запуска приложения требуется:
- Docker-compose
- Docker


### Сборка приложения

Для сборки приложения необходимо выполнить команду:
```
mvn clean package -Dmaven.test.skip 
```

### Запуск приложения
Для запуска приложения необходимо выполнить следующую команду:
#### Windows
```
docker-compose.exe up --build
```
#### Unix
```
docker-compose up --build
```

### Заполнение базы данных

Для заполнения базы данных можно изменить файл `src/main/resources/db/migration/V1__init.sql`, добавив туда новые сущности

### Тесты

Для тестов, необходимо запустить базу данных
```
docker-compose up -d db
```

И выполнить команду Maven

```
mvn test
```