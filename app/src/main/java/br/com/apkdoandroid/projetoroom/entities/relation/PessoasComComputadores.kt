package br.com.apkdoandroid.projetoroom.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import br.com.apkdoandroid.projetoroom.entities.Cliente
import br.com.apkdoandroid.projetoroom.entities.Computador
import br.com.apkdoandroid.projetoroom.entities.Pedido
import br.com.apkdoandroid.projetoroom.entities.Pessoa
import br.com.apkdoandroid.projetoroom.entities.PessoaComputador

data class PessoasComComputadores (
    @Embedded
    val pessoa : Pessoa,
    @Relation(
        parentColumn = "id_pessoa", //chave primeira
        entityColumn = "id_computador", //chave estrangeira
        entity = Computador::class,
        associateBy = Junction(PessoaComputador::class)
    )
    val computadores : List<Computador>
)