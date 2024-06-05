package br.com.apkdoandroid.projetoroom.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import br.com.apkdoandroid.projetoroom.entities.Cliente
import br.com.apkdoandroid.projetoroom.entities.Computador
import br.com.apkdoandroid.projetoroom.entities.Pedido
import br.com.apkdoandroid.projetoroom.entities.Pessoa
import br.com.apkdoandroid.projetoroom.entities.PessoaComputador

data class ComputadorComPessoas (
    @Embedded
    val computador : Computador,
    @Relation(
        parentColumn = "id_computador", //chave primeira
        entityColumn = "id_pessoa", //chave estrangeira
        entity = Pessoa::class,
        associateBy = Junction(PessoaComputador::class)
    )
    val pessoas : List<Pessoa>
)