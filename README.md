# Dublee — Roadmap проекта

> Статус: 🔄 В разработке  

---

## 1. Подготовка

- [ ] 1.1 Создать проект Android (Empty Activity)
- [ ] 1.2 Настроить Gradle (Compose, Hilt, Retrofit, DataStore, FCM)
- [ ] 1.3 Создать проект Spring Boot (Kotlin)
- [ ] 1.4 Настроить Gradle для бэкенда (JPA, PostgreSQL, Swagger)
- [ ] 1.5 Поднять локально PostgreSQL

---

## 2. Бэкенд — Авторизация

- [ ] 2.1 Сущность User (id, email, name, password)
- [ ] 2.2 UserRepository
- [ ] 2.3 Spring Security (CSRF off)
- [ ] 2.4 JWT (генерация)
- [ ] 2.5 POST /auth/register
- [ ] 2.6 POST /auth/login
- [ ] 2.7 PasswordEncoder (BCrypt)
- [ ] 2.8 JWT-фильтр

---

## 3. Бэкенд — Основная логика

- [ ] 3.1 Сущность Option (id, name, category, emoji)
- [ ] 3.2 Сущность Pair (id, user1Id, user2Id, status)
- [ ] 3.3 Сущность Like (id, pairId, userId, optionId)
- [ ] 3.4 Сущность Match (id, pairId, optionId, matchedAt)
- [ ] 3.5 Репозитории для всех сущностей
- [ ] 3.6 PairService (invite-код)
- [ ] 3.7 LikeService (сохранение лайка)
- [ ] 3.8 Логика проверки мэтча
- [ ] 3.9 POST /api/likes
- [ ] 3.10 GET /api/options?category=
- [ ] 3.11 POST /api/pairs/create
- [ ] 3.12 GET /api/pairs/status

---

## 4. Бэкенд — Polling и Push

- [ ] 4.1 GET /api/matches/pending
- [ ] 4.2 Поле lastCheckedAt (или timestamp на клиенте)
- [ ] 4.3 Сервис отправки FCM
- [ ] 4.4 Поле fcmToken в User
- [ ] 4.5 POST /api/users/fcm-token
- [ ] 4.6 Отправка пуша при мэтче

---

## 5. Бэкенд — Swagger и тесты

- [ ] 5.1 Настроить springdoc-openapi
- [ ] 5.2 Аннотации для контроллеров
- [ ] 5.3 Юнит-тесты LikeService
- [ ] 5.4 Интеграционные тесты API
- [ ] 5.5 Проверка Swagger UI

---

## 6. Android — Data Layer

- [ ] 6.1 Настроить Retrofit
- [ ] 6.2 Модели данных (User, Option, Like, Match)
- [ ] 6.3 DataStore Manager (токен, userId, timestamp)
- [ ] 6.4 ApiService (интерфейс)
- [ ] 6.5 Repository interface
- [ ] 6.6 RepositoryImpl (кэш в памяти)
- [ ] 6.7 FCM-сервис (токен → бэкенд)
- [ ] 6.8 Polling-сервис (каждые 3 сек)
- [ ] 6.9 Hilt модули (Network, DataStore)
- [ ] 6.10 Обработка ошибок

---

## 7. Android — Domain Layer

- [ ] 7.1 RegisterUseCase
- [ ] 7.2 LoginUseCase
- [ ] 7.3 GetOptionsUseCase
- [ ] 7.4 LikeOptionUseCase
- [ ] 7.5 CreatePairUseCase
- [ ] 7.6 CheckMatchesUseCase

---

## 8. Android — UI: Авторизация

- [ ] 8.1 Экран регистрации (email, name, password)
- [ ] 8.2 Экран логина (email, password)
- [ ] 8.3 AuthViewModel
- [ ] 8.4 Навигация (Splash → Auth → Main)
- [ ] 8.5 Сохранение токена в DataStore
- [ ] 8.6 Автовход по токену

---

## 9. Android — UI: Создание пары

- [ ] 9.1 Экран «Создать пару» (код + кнопка)
- [ ] 9.2 Экран «Присоединиться» (ввод кода)
- [ ] 9.3 PairViewModel
- [ ] 9.4 POST /pairs/create
- [ ] 9.5 Присоединение к паре
- [ ] 9.6 Переход к выбору категорий

---

## 10. Android — UI: Выбор категории

- [ ] 10.1 Экран выбора (Еда / Досуг)
- [ ] 10.2 CategoryViewModel
- [ ] 10.3 Переход на свайп-экран с categoryId
- [ ] 10.4 Передача параметра через навигацию

---

## 11. Android — UI: Свайп

- [ ] 11.1 Swipe-стек (карточки)
- [ ] 11.2 SwipeCard (composable)
- [ ] 11.3 Свайп вправо (лайк)
- [ ] 11.4 Свайп влево (дизлайк)
- [ ] 11.5 Вызов LikeUseCase при лайке
- [ ] 11.6 Дизлайк — без запроса
- [ ] 11.7 Индикатор загрузки
- [ ] 11.8 Автопереход к следующей карточке

---

## 12. Android — UI: Мэтч

- [ ] 12.1 Диалог «Мэтч!»
- [ ] 12.2 Polling → слушатель новых мэтчей
- [ ] 12.3 Показ диалога при мэтче
- [ ] 12.4 FCM-пуш (системное уведомление)
- [ ] 12.5 История мэтчей (опционально)

---

## 13. Android — Навигация и состояния

- [ ] 13.1 NavHost (все экраны)
- [ ] 13.2 Bottom bar (если нужен)
- [ ] 13.3 Logout (очистка токена)
- [ ] 13.4 401 → экран логина
- [ ] 13.5 ProgressBar / Loading states

---

## 14. Android — Тесты

- [ ] 14.1 Мок-тесты репозитория
- [ ] 14.2 UseCase тесты (MockK)
- [ ] 14.3 AuthViewModel тесты
- [ ] 14.4 LikeViewModel тесты
- [ ] 14.5 Compose UI-тест логина
- [ ] 14.6 Compose UI-тест свайпа
- [ ] 14.7 Интеграционный тест (логин → лайк)
- [ ] 14.8 Coverage report

---

## 15. Завершение

- [ ] 15.1 README (запуск бэкенда и Android)
- [ ] 15.2 Демо-видео (2 мин)
- [ ] 15.3 Сборка APK
- [ ] 15.4 Деплой бэкенда
- [ ] 15.5 Проверка Swagger
- [ ] 15.6 Презентация (5 слайдов)

---

## 📊 Прогресс

**Выполнено:** 0/90

**Автор:** Епифанов М.О.
**Проект:** Dublee  
**Стек:** Kotlin + Spring Boot + PostgreSQL + Jetpack Compose
