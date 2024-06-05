package br.com.apkdoandroid.projetoroom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "pessoas_computadores",
    primaryKeys = ["id_pessoa","id_computador"]
)
data class PessoaComputador(
    @ColumnInfo(name = "id_pessoa")
    val idPessoa : Long,
    @ColumnInfo(name = "id_computador")
    val idComputador : Long,


)