package br.com.apkdoandroid.projetoroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import br.com.apkdoandroid.projetoroom.entities.Endereco

@Dao
interface EnderecoDao {
    @Insert
    fun salvar(endereco: Endereco) : Long
    @Update
    fun update(endereco: Endereco) : Int
    @Delete
    fun delete(endereco: Endereco) : Int

 /*   @Query("SELECT * FROM usuarios ORDER BY nome ASC")
    fun listar() : List<Usuario>

    @Query("SELECT * FROM usuarios WHERE id = :search ORDER BY nome ASC")
    fun filtrar(search : String) : List<Usuario>*/
}