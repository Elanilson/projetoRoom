package br.com.apkdoandroid.projetoroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import br.com.apkdoandroid.projetoroom.entities.Cliente
import br.com.apkdoandroid.projetoroom.entities.Computador
import br.com.apkdoandroid.projetoroom.entities.Pedido
import br.com.apkdoandroid.projetoroom.entities.Pessoa
import br.com.apkdoandroid.projetoroom.entities.PessoaComputador
import br.com.apkdoandroid.projetoroom.entities.Produto
import br.com.apkdoandroid.projetoroom.entities.ProdutoDetalhe
import br.com.apkdoandroid.projetoroom.entities.relation.ClientesComPedidos
import br.com.apkdoandroid.projetoroom.entities.relation.PessoasComComputadores

@Dao
interface PessoaComputadorDao {
    @Insert
    fun salvar(pessoa: Pessoa) : Long
    @Insert
    fun salvarComputador(computador: Computador) : Long
    @Insert
    fun salvarPessoaComputador(pessoaComputador: PessoaComputador) : Long
    @Update
    fun update(cliente: Cliente) : Int
    @Delete
    fun delete(cliente: Cliente) : Int


    @Transaction
    @Query("SELECT * FROM pessoas")
    fun pessoasComCumputadores() : List<PessoasComComputadores>

  /*  @Query("SELECT * FROM usuarios WHERE id = :search ORDER BY nome ASC")
    fun filtrar(search : String) : List<Usuario>*/
}