package com.colddelight.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.colddelight.database.model.DayExerciseEntity
import com.colddelight.database.model.ExerciseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DayExerciseDao {


    @Query("SELECT * FROM day_exercise JOIN exercise ON day_exercise.exercise_id = exercise.id")
    fun getAllDayExercise(): Flow<Map<DayExerciseEntity, ExerciseEntity>>


    @Query("SELECT * FROM day_exercise JOIN exercise ON day_exercise.exercise_id = exercise.id WHERE day_exercise.routine_day_id=(:routineDayId)")
    fun getDayExercise(routineDayId: Int): Flow<Map<DayExerciseEntity, ExerciseEntity>>

    @Query("SELECT * FROM day_exercise  WHERE day_exercise.routine_day_id=(:routineDayId)")
    fun getSimpleDayExercise(routineDayId: Int): Flow<List<DayExerciseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDayExercise(dayExerciseEntity: DayExerciseEntity): Long


    @Query("DELETE FROM day_exercise WHERE id = :dayExerciseId")
    suspend fun deleteDayExerciseById(dayExerciseId: Int)

    @Query("SELECT * FROM day_exercise WHERE routine_day_id = :routineDayId")
    fun getDayExercisesByRoutineDayId(routineDayId: Int): Flow<List<DayExerciseEntity>>

    // Delete day exercises by routine_day_id
    @Query("DELETE FROM day_exercise WHERE routine_day_id = :routineDayId")
    fun deleteDayExercisesByRoutineDayId(routineDayId: Int)

    @Query("UPDATE day_exercise SET kg_list = :kgList, reps_list = :repsList WHERE id = :id")
    suspend fun updateKgRepsById(id: Int, kgList: List<Int>, repsList: List<Int>)

}