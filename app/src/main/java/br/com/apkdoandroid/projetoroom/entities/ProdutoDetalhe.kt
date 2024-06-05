package br.com.apkdoandroid.projetoroom.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey
@Entity(
    tableName = "produtos_detalhes",
    indices = [Index(value = ["id_produto"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = Produto::class,
        parentColumns = ["id_produto"],
        childColumns = ["id_produto"],
        onDelete = CASCADE,
        onUpdate = CASCADE
    )]
)
data class ProdutoDetalhe (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_produto_detalhe")
    val idProdutoDetalhe : Long,
    @ColumnInfo(name = "id_produto")
    val idProduto : Long,
    val marca : String,
    val descricao : String,
)