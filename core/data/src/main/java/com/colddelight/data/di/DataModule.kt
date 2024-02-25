package com.colddelight.data.di

import com.colddelight.data.repository.DayExerciseRepository
import com.colddelight.data.repository.DayExerciseRepositoryImpl
import com.colddelight.data.repository.ExerciseRepository
import com.colddelight.data.repository.ExerciseRepository2
import com.colddelight.data.repository.ExerciseRepository2Impl
import com.colddelight.data.repository.ExerciseRepositoryImpl
import com.colddelight.data.repository.HistoryExerciseRepository
import com.colddelight.data.repository.HistoryExerciseRepositoryImpl
import com.colddelight.data.repository.HistoryRepository
import com.colddelight.data.repository.HistoryRepositoryImpl
import com.colddelight.data.repository.RoutineDayRepository
import com.colddelight.data.repository.RoutineDayRepositoryImpl
import com.colddelight.data.repository.RoutineRepository
import com.colddelight.data.repository.RoutineRepositoryImpl
import com.colddelight.datastore.datasource.TokenPreferencesDataSource
import com.colddelight.datastore.datasource.TokenPreferencesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    abstract fun bindLocalDataSource(
        dataSource: TokenPreferencesDataSourceImpl,
    ): TokenPreferencesDataSource

    @Binds
    fun bindsExercise2Repository(
        exerciseRepository2: ExerciseRepository2Impl
    ): ExerciseRepository2

    @Binds
    fun bindsExerciseRepository(
        exerciseRepository: ExerciseRepositoryImpl
    ): ExerciseRepository
    @Binds
    fun bindsRoutineRepository(
        routineRepository: RoutineRepositoryImpl
    ): RoutineRepository

    @Binds
    fun bindsRoutineDayRepository(
        routineDayRepository: RoutineDayRepositoryImpl
    ): RoutineDayRepository


    @Binds
    fun bindsDayExerciseRepository(
        dayExerciseRepository: DayExerciseRepositoryImpl
    ): DayExerciseRepository

    @Binds
    fun bindsHistoryExerciseRepository(
        historyExerciseRepository: HistoryExerciseRepositoryImpl
    ): HistoryExerciseRepository

    @Binds
    fun bindsHistoryRepository(
        historyRepository: HistoryRepositoryImpl
    ): HistoryRepository


}
