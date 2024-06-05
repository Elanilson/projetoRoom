package br.com.apkdoandroid.projetoroom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enderecos" )
data class Endereco(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_endereco")
    val idEndereco : Long,
    val rua : String
) {
    override fun toString(): String {
        return "Endereco(rua='$rua', )"
    }
}