package br.com.apkdoandroid.projetoroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.apkdoandroid.projetoroom.entities.Usuario

@Dao
interface UsuarioDao {
    @Insert
    fun salvar(usuario: Usuario) : Long
    @Update
    fun update(usuario: Usuario) : Int
    @Delete
    fun delete(usuario: Usuario) : Int

    @Query("SELECT * FROM usuarios ORDER BY nome ASC")
    fun listar() : List<Usuario>

    @Query("SELECT * FROM usuarios WHERE id = :search ORDER BY nome ASC")
    fun filtrar(search : String) : List<Usuario>
}