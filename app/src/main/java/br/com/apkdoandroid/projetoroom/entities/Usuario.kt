package br.com.apkdoandroid.projetoroom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date

/**
 *  posso usar @Ignore ou ignoredColumns , para ignorar colunas para não serem criada as colunas que não quero
 */
@Entity(tableName = "usuarios" , ignoredColumns = ["imc"])
@TypeConverters(Conversor::class)
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val email : String,
    @ColumnInfo("nome", defaultValue = "--")
    val nome : String,
    val senha : String,
    val idade : Int,
    val peso : Double,
  //  @Ignore
    val imc : Double,
   // @Embedded
   // val endereco: Endereco,
    val data: Date,
  //  @ColumnInfo(name = "sexo_usuario", defaultValue = "")
 //   val sexoUsuario : String = ""
    ){

    // Construtor secundário para Room
    constructor(
        id: Long,
        email: String,
        nome: String,
        senha: String,
        idade: Int,
        peso: Double,
    //    endereco: Endereco,
        data: Date,
     //   sexoUsuario: String
    ) : this(id, email, nome, senha, idade, peso, 0.0,
      //  endereco,
        data,
      //  sexoUsuario
    )

    override fun toString(): String {
        return "Usuario(id=$id, email='$email', nome='$nome', senha='$senha', idade=$idade, peso=$peso, imc=$imc)"
    }


}