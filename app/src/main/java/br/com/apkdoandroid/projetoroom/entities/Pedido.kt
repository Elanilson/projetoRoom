package br.com.apkdoandroid.projetoroom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "pedidos",
    foreignKeys = [ForeignKey(
        entity = Cliente::class,
        parentColumns = ["id_cliente"],
        childColumns = ["id_cliente"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
class Pedido (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pedido")
    val idPedido : Long,
    @ColumnInfo(name = "id_cliente")
    val idCliente : Long,
    val produto : String,
    val preco : Double,

    )