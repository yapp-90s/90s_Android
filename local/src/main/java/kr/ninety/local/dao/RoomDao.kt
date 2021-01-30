/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import io.reactivex.Completable
import io.reactivex.Single
import kr.ninety.local.model.RoomObject

interface RoomDao<T: RoomObject> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomObject: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomObjects: List<T>): Completable
    fun getAll(): Single<List<T>>
    fun getCount(): Single<Int>
    fun drop(): Completable
}
