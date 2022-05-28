package com.example.compose_test_3

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {

   //     myService.doAThing()
    }

  //  @Inject lateinit var myService: MyServiceWitHilt
}


class MyServiceWitHilt
    constructor(public val scope: CoroutineScope)  {

    fun doAThing() {
        scope.launch {
            println("[foo] MyServiceWitHilt")
        }
    }
}

/*
@Module
@InstallIn(SingletonComponent::class)
abstract class myOtherModule {
    @Binds
    abstract fun providesMyService(myService: MyServiceWitHilt): MyServiceWitHilt
}
*/
