package br.com.apkdoandroid.projetoroom.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.apkdoandroid.projetoroom.dao.ClientePedidoDao
import br.com.apkdoandroid.projetoroom.dao.EnderecoDao
import br.com.apkdoandroid.projetoroom.dao.PessoaComputadorDao
import br.com.apkdoandroid.projetoroom.dao.ProdutoDao
import br.com.apkdoandroid.projetoroom.dao.UsuarioDao
import br.com.apkdoandroid.projetoroom.entities.Cliente
import br.com.apkdoandroid.projetoroom.entities.Computador
import br.com.apkdoandroid.projetoroom.entities.Conversor
import br.com.apkdoandroid.projetoroom.entities.Endereco
import br.com.apkdoandroid.projetoroom.entities.Pedido
import br.com.apkdoandroid.projetoroom.entities.Pessoa
import br.com.apkdoandroid.projetoroom.entities.PessoaComputador
import br.com.apkdoandroid.projetoroom.entities.Produto
import br.com.apkdoandroid.projetoroom.entities.ProdutoDetalhe
import br.com.apkdoandroid.projetoroom.entities.Usuario

@Database(
    entities = [
        Usuario::class,Endereco::class,
        Produto::class,ProdutoDetalhe::class,
        Cliente::class,Pedido::class,
        Pessoa::class,Computador::class,PessoaComputador::class
               ],
    version = 6,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = BancoDados.Migration2To3::class),
        AutoMigration(from = 3, to = 4, spec = BancoDados.Migration3To4::class),
        AutoMigration(from = 4, to = 5, spec = BancoDados.Migration4To5::class),
    ]
)
@TypeConverters(Conversor::class)
 abstract class BancoDados : RoomDatabase() {

   // abstract  fun recuperaUsuarioDao() : UsuarioDao
    abstract val usuarioDao : UsuarioDao
    abstract val enderecoDao: EnderecoDao
    abstract val produtoDao : ProdutoDao
    abstract val clientePedidoDao : ClientePedidoDao
    abstract val pessoaComputadorDao : PessoaComputadorDao

     companion object{
         val migration5To6 = object : Migration(5,6){
             override fun migrate(db: SupportSQLiteDatabase) {
                 db.execSQL("CREATE TABLE IF NOT EXISTS enderecos(id_endereco INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                         "rua TEXT NOT NULL)")
             }

         }
         fun recuperarInstanciaRoom(context : Context) : BancoDados{
             return Room.databaseBuilder(
                 context,
                 BancoDados::class.java,
                 "projetoRoom.db"
             ).addMigrations(migration5To6)
                 .addTypeConverter(Conversor())
                 .build()
         }
     }

    @RenameColumn("usuarios","sexo","sexo_usuario")
    class Migration2To3 : AutoMigrationSpec
    @DeleteColumn("usuarios","sexo_usuario")
    class Migration3To4 : AutoMigrationSpec
    @DeleteColumn("usuarios","rua")
    @DeleteColumn("usuarios","numero")
    class Migration4To5 : AutoMigrationSpec
}