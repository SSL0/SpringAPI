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
docker-compose.exe up
```
#### Unix
```
docker-compose up
```
