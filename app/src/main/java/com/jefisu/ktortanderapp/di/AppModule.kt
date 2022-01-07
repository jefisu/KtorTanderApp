package com.jefisu.ktortanderapp.di

import com.jefisu.ktortanderapp.features.data.repository.TanderRepositoryImp
import com.jefisu.ktortanderapp.features.domain.repository.TanderRepository
import com.jefisu.ktortanderapp.features.domain.use_cases.GetMember
import com.jefisu.ktortanderapp.features.domain.use_cases.GetMembers
import com.jefisu.ktortanderapp.features.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideService(): TanderRepository {
        return TanderRepositoryImp(
            client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
            }
        )
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: TanderRepository): UseCases {
        return UseCases(
            getMembers = GetMembers(repository),
            getMemberById = GetMember(repository)
        )
    }
}