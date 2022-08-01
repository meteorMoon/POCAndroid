package com.example.pocshoppinglist.common.di

import com.example.pocshoppinglist.data.repository.LoginRepositoryImpl
import com.example.pocshoppinglist.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginModule {

    @Binds
    @ViewModelScoped
    abstract fun bindLoginRepository(repositoryImpl: LoginRepositoryImpl): LoginRepository
}