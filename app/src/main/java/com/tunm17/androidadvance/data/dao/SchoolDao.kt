package com.tunm17.androidadvance.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.tunm17.androidadvance.data.entity.Course
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.data.entity.SchoolWithStudents
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSchool(school: School): Single<Long>

    @Query("SELECT * FROM school")
    fun getAllSchools(): Maybe<List<School>>

    @Query("SELECT * FROM school WHERE school_id = :schoolId")
    fun getSchoolById(schoolId: Int): Single<School>

    @Transaction
    @Query("SELECT * FROM school WHERE school_id = :schoolId")
    fun getSchoolWithStudents(schoolId: Int): Single<SchoolWithStudents>
}