package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.dublee.app.domain.providers.Session
import com.dublee.app.domain.providers.UserIconProvider
import com.dublee.app.domain.providers.UserProviderImpl
import com.dublee.app.domain.providers.UserUpdater

class EditProfileViewModel(
    userProviderImpl: UserProviderImpl
) : ViewModel(),
    Session by userProviderImpl,
    UserIconProvider by userProviderImpl,
    UserUpdater by userProviderImpl {
}