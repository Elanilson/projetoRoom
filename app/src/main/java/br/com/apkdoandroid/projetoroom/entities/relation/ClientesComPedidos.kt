package br.com.apkdoandroid.projetoroom.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import br.com.apkdoandroid.projetoroom.entities.Cliente
import br.com.apkdoandroid.projetoroom.entities.Pedido

data class ClientesComPedidos (
    @Embedded
    val cliente : Cliente,
    @Relation(
        parentColumn = "id_cliente", //chave primeira
        entityColumn = "id_cliente", //chave estrangeira
        entity = Pedido::class,
    )
    val pedidos : List<Pedido>
)