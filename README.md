# Dublee — Roadmap проекта

> Статус: 🔄 В разработке
> ## 📊 Прогресс: 21/100

---
## 1. Подготовка

- [x] 1.1 Создать проект Android
- [x] 1.2 Настроить Gradle (Compose, Hilt, Retrofit, DataStore, FCM)
- [x] 1.3 Создать проект Spring Boot
- [x] 1.4 Настроить Gradle для бэкенда
- [ ] 1.5 Поднять PostgreSQL
- [ ] 1.6 Настроить Swagger
- [ ] 1.7 Настроить FCM
- [ ] 1.8 Подключить Hilt
- [ ] 1.9 Настроить DataStore
- [ ] 1.10 Настроить Retrofit
---
## 2. Бэкенд: Модели

- [x] 2.1 User
- [x] 2.2 Option
- [x] 2.3 Pair
- [x] 2.4 Vote
- [x] 2.5 Match
- [x] 2.6 Category
- [ ] 2.7 Репозитории
- [ ] 2.8 DTO
- [ ] 2.9 Мапперы
- [ ] 2.10 Миграции
---
## 3. Бэкенд: Auth

- [x] 3.1 Spring Security (CSRF off)
- [x] 3.2 JWT генерация
- [x] 3.3 PasswordEncoder
- [x] 3.4 UserRepository
- [ ] 3.5 POST /auth/register
- [ ] 3.6 POST /auth/login
- [ ] 3.7 Refresh token
- [ ] 3.8 Logout
- [ ] 3.9 AuthController
- [ ] 3.10 AuthService
---
## 4. Бэкенд: API

- [ ] 4.1 POST /api/vote
- [ ] 4.2 GET /api/options
- [ ] 4.3 POST /api/pairs/create
- [ ] 4.4 GET /api/pairs/status
- [ ] 4.5 GET /api/matches/pending
- [ ] 4.6 POST /api/users/fcm-token
- [ ] 4.7 PairService
- [ ] 4.8 VoteService
- [ ] 4.9 MatchService
- [ ] 4.10 Логика мэтча
---
## 5. Бэкенд: Интеграции

- [ ] 5.1 FCM сервис
- [ ] 5.2 Поле fcmToken в User
- [ ] 5.3 Отправка пуша при мэтче
- [ ] 5.4 Polling API
- [ ] 5.5 lastCheckedAt
- [ ] 5.6 WebSocket (опционально)
- [ ] 5.7 Dockerfile
- [ ] 5.8 docker-compose
- [ ] 5.9 Деплой на сервер
- [ ] 5.10 Переменные окружения
---
## 6. Android: Data Layer

- [ ] 6.1 Модели данных
- [ ] 6.2 ApiService
- [ ] 6.3 Repository interface
- [ ] 6.4 RepositoryImpl
- [ ] 6.5 DataStore Manager
- [ ] 6.6 FCM сервис
- [ ] 6.7 Polling сервис
- [ ] 6.8 Hilt модули
- [ ] 6.9 Обработка ошибок
- [ ] 6.10 Кэш в памяти
---
## 7. Android: Domain Layer

- [ ] 7.1 RegisterUseCase
- [ ] 7.2 LoginUseCase
- [ ] 7.3 GetOptionsUseCase
- [ ] 7.4 VoteUseCase
- [ ] 7.5 CreatePairUseCase
- [ ] 7.6 CheckMatchesUseCase
- [ ] 7.7 SaveFcmTokenUseCase
- [ ] 7.8 Получение invite-кода
- [ ] 7.9 Присоединение к паре
- [ ] 7.10 Логика мэтча на клиенте
---
## 8. Android: UI Авторизация

- [x] 8.1 Экран регистрации
- [x] 8.2 Экран логина
- [x] 8.3 Навигация
- [ ] 8.4 AuthViewModel
- [ ] 8.5 Сохранение токена
- [ ] 8.6 Автовход
- [ ] 8.7 Валидация полей
- [ ] 8.8 Loading состояния
- [ ] 8.9 Ошибки входа
- [ ] 8.10 Сохранение пароля
---
## 9. Android - UI: Создание пары

- [x] 9.1 Экран «Создать пару»
- [x] 9.2 Экран «Присоединиться»
- [x] 9.3 Переход к категориям
- [ ] 9.4 PairViewModel
- [ ] 9.5 Генерация кода
- [ ] 9.6 Ввод кода
- [ ] 9.7 POST /pairs/create
- [ ] 9.8 Присоединение
- [ ] 9.9 Статус пары
- [ ] 9.10 Ожидание подтверждения
---
## 10. Android - UI: Основной 

- [ ] 10.1 Экран выбора категории
- [ ] 10.2 CategoryViewModel
- [ ] 10.3 Swipe-стек
- [ ] 10.4 Карточки вариантов
- [ ] 10.5 Свайп вправо (лайк)
- [ ] 10.6 Свайп влево (дизлайк)
- [ ] 10.7 Индикатор загрузки
- [ ] 10.8 Диалог мэтча
- [ ] 10.9 Поллинг мэтчей
- [ ] 10.10 FCM уведомления
---

**Автор:** Епифанов М.О.

**Проект:** Dublee  

**Стек:** Kotlin + Spring Boot + PostgreSQL + Jetpack Compose
