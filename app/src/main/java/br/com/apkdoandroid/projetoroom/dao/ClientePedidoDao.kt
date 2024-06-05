package br.com.apkdoandroid.projetoroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import br.com.apkdoandroid.projetoroom.entities.Cliente
import br.com.apkdoandroid.projetoroom.entities.Pedido
import br.com.apkdoandroid.projetoroom.entities.Produto
import br.com.apkdoandroid.projetoroom.entities.ProdutoDetalhe
import br.com.apkdoandroid.projetoroom.entities.relation.ClientesComPedidos

@Dao
interface ClientePedidoDao {
    @Insert
    fun salvar(cliente: Cliente) : Long
    @Insert
    fun salvarPedido(pedido: Pedido) : Long
    @Update
    fun update(cliente: Cliente) : Int
    @Delete
    fun delete(cliente: Cliente) : Int

    @Query("SELECT * FROM produtos")
    fun listar() : List<Produto>

    @Query("SELECT * FROM produtos_detalhes")
    fun listarProdutoDeTalhes() : List<ProdutoDetalhe>

    @Transaction
    @Query("SELECT * FROM clientes")
    fun listarClientesComPedidos() : List<ClientesComPedidos>

  /*  @Query("SELECT * FROM usuarios WHERE id = :search ORDER BY nome ASC")
    fun filtrar(search : String) : List<Usuario>*/
}