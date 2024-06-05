package br.com.apkdoandroid.projetoroom.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import br.com.apkdoandroid.projetoroom.entities.Produto
import br.com.apkdoandroid.projetoroom.entities.ProdutoDetalhe

data class ProdutoEProdutoDetalhe(
    @Embedded
    val produto : Produto,
    @Relation(
        parentColumn = "id_produto", //chave primeira
        entityColumn = "id_produto", //chave estrangeira
        entity = ProdutoDetalhe::class,
    )
    val produtoDetalhe: ProdutoDetalhe
)