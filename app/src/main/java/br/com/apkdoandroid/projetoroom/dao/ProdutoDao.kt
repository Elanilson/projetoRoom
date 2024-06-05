package br.com.apkdoandroid.projetoroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import br.com.apkdoandroid.projetoroom.entities.Produto
import br.com.apkdoandroid.projetoroom.entities.ProdutoDetalhe
import br.com.apkdoandroid.projetoroom.entities.relation.ProdutoEProdutoDetalhe

@Dao
interface ProdutoDao {
    @Insert
    fun salvar(produto: Produto) : Long
    @Insert
    fun salvarProdutoDetalhe(produtodetalhe: ProdutoDetalhe) : Long
    @Update
    fun update(produto: Produto) : Int
    @Delete
    fun delete(produto: Produto) : Int

    @Query("SELECT * FROM produtos")
    fun listar() : List<Produto>

    @Query("SELECT * FROM produtos_detalhes")
    fun listarProdutoDeTalhes() : List<ProdutoDetalhe>

    @Transaction
    @Query("SELECT * FROM produtos")
    fun listarprodutosEProdutoDeTalhes() : List<ProdutoEProdutoDetalhe>

  /*  @Query("SELECT * FROM usuarios WHERE id = :search ORDER BY nome ASC")
    fun filtrar(search : String) : List<Usuario>*/
}