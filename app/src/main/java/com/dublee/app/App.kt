package com.dublee.app

import android.app.Application
import android.content.Context
import com.dublee.app.data.remote.services.ActivityApiService
import com.dublee.app.data.remote.services.AuthApiService
import com.dublee.app.data.remote.services.PairApiService
import com.dublee.app.data.remote.services.UserApiService
import com.dublee.app.data.repositories.ActivityRepository
import com.dublee.app.data.repositories.CategoryRepository
import com.dublee.app.data.repositories.OptionRepository
import com.dublee.app.data.repositories.PairRepository
import com.dublee.app.data.repositories.SettingsRepository
import com.dublee.app.data.repositories.TokenRepository
import com.dublee.app.data.repositories.UserRepository
import com.dublee.app.domain.providers.ActivityProviderImpl
import com.dublee.app.domain.providers.ContentProviderImpl
import com.dublee.app.domain.providers.PairProviderImpl
import com.dublee.app.domain.providers.UserProviderImpl
import com.dublee.app.domain.usecases.PartnerSession
import com.dublee.app.domain.usecases.UserSession
import com.dublee.app.ui.viewmodels.ActivityViewModel
import com.dublee.app.ui.viewmodels.EditProfileViewModel
import com.dublee.app.ui.viewmodels.LoginViewModel
import com.dublee.app.ui.viewmodels.MainViewModel
import com.dublee.app.ui.viewmodels.PairViewModel
import com.dublee.app.ui.viewmodels.ProfileViewModel
import com.dublee.app.ui.viewmodels.RegisterViewModel
import com.dublee.app.ui.viewmodels.SettingsViewModel
import com.dublee.app.ui.viewmodels.SplashViewModel
import com.dublee.app.ui.viewmodels.SwipeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

private object AppContext {
    lateinit var context: Context
        private set

    fun init(context: Context) {
        this.context = context.applicationContext
    }
}

val appModule = module {
    // Сессии
    single { UserSession() }
    single { PartnerSession() }

    // API сервис
    single { ActivityApiService() }
    single { AuthApiService() }
    single { PairApiService() }
    single { UserApiService() }

    // Репозитории
    single { ActivityRepository(get(), get()) }
    single { CategoryRepository() }
    single { OptionRepository() }
    single { PairRepository(get(), get()) }
    single {
        SettingsRepository(
            AppContext.context
        )
    }
    single { TokenRepository(AppContext.context) }
    single {
        UserRepository(
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }

    // Провайдер
    single { ActivityProviderImpl(get()) }
    single { ContentProviderImpl(get(), get()) }
    single { PairProviderImpl(get()) }
    single { UserProviderImpl(get()) }

    // ViewModels
    factory { ActivityViewModel(get(), get()) }
    factory { EditProfileViewModel(get()) }
    factory { LoginViewModel(get()) }
    factory { MainViewModel(get(), get()) }
    factory { PairViewModel(get(), get()) }
    factory { ProfileViewModel(get()) }
    factory { RegisterViewModel(get()) }
    factory { SettingsViewModel(get()) }
    factory { SplashViewModel(get(), get()) }

    // Категории
    factory { params ->
        SwipeViewModel(
            params.get(),
            get(),
            get(),
            get()
        )
    }
}

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContext.init(this)
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}