# Dublee — Roadmap проекта

> Статус: 🔄 В разработке  

---

## 1. Подготовка

- [x] 1.1 Создать проект Android (Empty Activity)
- [x] 1.2 Настроить Gradle (Compose, Hilt, Retrofit, DataStore, FCM)
- [x] 1.3 Создать проект Spring Boot (Kotlin)
- [x] 1.4 Настроить Gradle для бэкенда (JPA, PostgreSQL, Swagger)
- [ ] 1.5 Поднять локально PostgreSQL

### Выполнено: 4/5
---

## 2. Бэкенд — Авторизация

- [x] 2.1 Сущность User
- [x] 2.2 UserRepository
- [x] 2.3 Spring Security (CSRF off)
- [x] 2.4 JWT (генерация)
- [ ] 2.5 POST /auth/register
- [ ] 2.6 POST /auth/login
- [x] 2.7 PasswordEncoder (BCrypt)

### Выполнено: 5/7
---

## 3. Бэкенд — Основная логика

- [x] 3.1 Сущность Option 
- [x] 3.2 Сущность Pair 
- [x] 3.3 Сущность Vote
- [x] 3.4 Сущность Match
- [x] 3.5 Сущность Category
- [x] 3.6 Репозитории для всех сущностей
- [ ] 3.7 PairService (invite-код)
- [ ] 3.8 VoteService (сохранение голоса)
- [ ] 3.9 Логика проверки мэтча
- [ ] 3.10 POST /api/vote
- [ ] 3.11 GET /api/options?category=
- [ ] 3.12 POST /api/pairs/create
- [ ] 3.13 GET /api/pairs/status

### Выполнено: 5/13
---

## 4. Бэкенд — Polling и Push

- [ ] 4.1 GET /api/matches/pending
- [ ] 4.2 Поле lastCheckedAt (или timestamp на клиенте)
- [ ] 4.3 Сервис отправки FCM
- [ ] 4.4 Поле fcmToken в User
- [ ] 4.5 POST /api/users/fcm-token
- [ ] 4.6 Отправка пуша при мэтче

### Выполнено: 0/6
---

## 5. Бэкенд — Swagger и тесты

- [ ] 5.1 Настроить springdoc-openapi
- [ ] 5.2 Аннотации для контроллеров
- [ ] 5.3 Юнит-тесты VoteService
- [ ] 5.4 Интеграционные тесты API
- [ ] 5.5 Проверка Swagger UI

### Выполнено: 0/5
---

## 6. Android — Data Layer

- [ ] 6.1 Настроить Retrofit
- [ ] 6.2 Модели данных
- [ ] 6.3 DataStore Manager (токен, userId, timestamp)
- [ ] 6.4 ApiService (интерфейс)
- [ ] 6.5 Repository interface
- [ ] 6.6 RepositoryImpl (кэш в памяти)
- [ ] 6.7 FCM-сервис (токен → бэкенд)
- [ ] 6.8 Polling-сервис (каждые 3 сек)
- [ ] 6.9 Hilt модули (Network, DataStore)
- [ ] 6.10 Обработка ошибок

### Выполнено: 0/10
---

## 7. Android — Domain Layer

- [ ] 7.1 RegisterUseCase
- [ ] 7.2 LoginUseCase
- [ ] 7.3 GetOptionsUseCase
- [ ] 7.4 VoteOptionUseCase
- [ ] 7.5 CreatePairUseCase
- [ ] 7.6 CheckMatchesUseCase

### Выполнено: 0/6
---

## 8. Android — UI: Авторизация

- [x] 8.1 Экран регистрации (login, password)
- [x] 8.2 Экран логина (login, password)
- [ ] 8.3 AuthViewModel
- [ ] 8.4 Навигация (Splash → Auth → Main)
- [ ] 8.5 Сохранение токена в DataStore
- [ ] 8.6 Автовход по токену

### Выполнено: 2/6
---

## 9. Android — UI: Создание пары

- [ ] 9.1 Экран «Создать пару» (код + кнопка)
- [ ] 9.2 Экран «Присоединиться» (ввод кода)
- [ ] 9.3 PairViewModel
- [ ] 9.4 POST /pairs/create
- [ ] 9.5 Присоединение к паре
- [ ] 9.6 Переход к выбору категорий

### Выполнено: 0/6
---

## 10. Android — UI: Выбор категории

- [ ] 10.1 Экран выбора (Еда / Досуг)
- [ ] 10.2 CategoryViewModel
- [ ] 10.3 Переход на свайп-экран с categoryId
- [ ] 10.4 Передача параметра через навигацию

### Выполнено: 0/4
---

## 11. Android — UI: Свайп

- [ ] 11.1 Swipe-стек (карточки)
- [ ] 11.2 SwipeCard (composable)
- [ ] 11.3 Свайп вправо (лайк)
- [ ] 11.4 Свайп влево (дизлайк)
- [ ] 11.5 Вызов VoteUseCase при лайке
- [ ] 11.6 Дизлайк — без запроса
- [ ] 11.7 Индикатор загрузки
- [ ] 11.8 Автопереход к следующей карточке

### Выполнено: 0/8
---

## 12. Android — UI: Мэтч

- [ ] 12.1 Диалог «Мэтч!»
- [ ] 12.2 Polling → слушатель новых мэтчей
- [ ] 12.3 Показ диалога при мэтче
- [ ] 12.4 FCM-пуш (системное уведомление)
- [ ] 12.5 История мэтчей (опционально)

### Выполнено: 0/5
---

## 13. Android — Навигация и состояния

- [ ] 13.1 NavHost (все экраны)
- [ ] 13.2 Bottom bar (если нужен)
- [ ] 13.3 Logout (очистка токена)
- [ ] 13.4 401 → экран логина
- [ ] 13.5 ProgressBar / Loading states

### Выполнено: 0/5
---

## 14. Android — Тесты

- [ ] 14.1 Мок-тесты репозитория
- [ ] 14.2 UseCase тесты (MockK)
- [ ] 14.3 AuthViewModel тесты
- [ ] 14.4 VoteViewModel тесты
- [ ] 14.5 Compose UI-тест логина
- [ ] 14.6 Compose UI-тест свайпа
- [ ] 14.7 Интеграционный тест (логин → лайк)
- [ ] 14.8 Coverage report

### Выполнено: 0/8
---

## 15. Завершение

- [ ] 15.1 README (запуск бэкенда и Android)
- [ ] 15.2 Демо-видео (2 мин)
- [ ] 15.3 Сборка APK
- [ ] 15.4 Деплой бэкенда
- [ ] 15.5 Проверка Swagger
- [ ] 15.6 Презентация (5 слайдов)

### Выполнено: 0/6
---

## 📊 Прогресс: 32/100

**Автор:** Епифанов М.О.
**Проект:** Dublee  
**Стек:** Kotlin + Spring Boot + PostgreSQL + Jetpack Compose
