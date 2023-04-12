package com.example.chess.hilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton
import com.avingard.echo.client.GrpcClient
import dagger.hilt.android.qualifiers.ApplicationContext
import io.grpc.ManagedChannelBuilder
import io.grpc.android.AndroidChannelBuilder

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob())
    }

    @Provides
    @Singleton
    fun provideGrpcClient(scope: CoroutineScope, @ApplicationContext context: Context): GrpcClient {
        val managedChannelBuilder = ManagedChannelBuilder
            .forTarget("192.168.100.3:8080")
            .usePlaintext()

        val androidManagedChannelBuilder = AndroidChannelBuilder
            .usingBuilder(managedChannelBuilder)
            .context(context)

        return GrpcClient(scope, androidManagedChannelBuilder)
    }
}