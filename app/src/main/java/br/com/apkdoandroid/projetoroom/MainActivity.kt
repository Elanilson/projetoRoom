package br.com.apkdoandroid.projetoroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.apkdoandroid.projetoroom.dao.ClientePedidoDao
import br.com.apkdoandroid.projetoroom.dao.EnderecoDao
import br.com.apkdoandroid.projetoroom.dao.PessoaComputadorDao
import br.com.apkdoandroid.projetoroom.dao.ProdutoDao
import br.com.apkdoandroid.projetoroom.dao.UsuarioDao
import br.com.apkdoandroid.projetoroom.data.BancoDados
import br.com.apkdoandroid.projetoroom.databinding.ActivityMainBinding
import br.com.apkdoandroid.projetoroom.entities.Cliente
import br.com.apkdoandroid.projetoroom.entities.Computador
import br.com.apkdoandroid.projetoroom.entities.Pedido
import br.com.apkdoandroid.projetoroom.entities.Pessoa
import br.com.apkdoandroid.projetoroom.entities.PessoaComputador
import br.com.apkdoandroid.projetoroom.entities.Produto
import br.com.apkdoandroid.projetoroom.entities.ProdutoDetalhe
import br.com.apkdoandroid.projetoroom.entities.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    private lateinit var bancoDados: BancoDados
    private lateinit var usuarioDao: UsuarioDao
    private lateinit var enderecoDao: EnderecoDao
    private lateinit var produtoDao: ProdutoDao
    private lateinit var clientePedidoDao: ClientePedidoDao
    private lateinit var pessoaComputadorDao: PessoaComputadorDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        bancoDados = BancoDados.recuperarInstanciaRoom(this)
        usuarioDao = bancoDados.usuarioDao
        enderecoDao = bancoDados.enderecoDao
        produtoDao = bancoDados.produtoDao
        clientePedidoDao = bancoDados.clientePedidoDao
        pessoaComputadorDao = bancoDados.pessoaComputadorDao

        binding.btnSalvar.setOnClickListener {
            val nome = binding.editNome.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val pessoa = Pessoa(0,"Fernanda","M")

                val idPessoa = pessoaComputadorDao.salvar(pessoa)

                val computador = Computador(0,"Dell","x")
                val computador2 = Computador(0,"Aper","x")

                val idComputador = pessoaComputadorDao.salvarComputador(computador)
                val idComputador2 = pessoaComputadorDao.salvarComputador(computador2)

                //
                val pessoaComputador = PessoaComputador(idPessoa,idComputador)
                val pessoaComputador2 = PessoaComputador(idPessoa,idComputador2)

                pessoaComputadorDao.salvarPessoaComputador(pessoaComputador)
                pessoaComputadorDao.salvarPessoaComputador(pessoaComputador2)

                withContext(Dispatchers.Main){
                    binding.editNome.setText("")
                }
            }

          /*  CoroutineScope(Dispatchers.IO).launch {
                val idCliente = clientePedidoDao.salvar(
                   Cliente(0,"Elanilson","Sousa")
                )

                repeat(3){numero ->
                    val pedido = Pedido(0,idCliente,"Produto(${numero})",200.90 + (150 * numero))
                clientePedidoDao.salvarPedido(
                    pedido
                )
                }
                withContext(Dispatchers.Main){
                    binding.editNome.setText("")
                }
            }*/

         /*   CoroutineScope(Dispatchers.IO).launch {
               val idProdutoInserido = produtoDao.salvar(
                   Produto(0,nome,1200.90)
               )
                produtoDao.salvarProdutoDetalhe(
                    ProdutoDetalhe(0,idProdutoInserido,"Acer","Descricao completa")
                )
                withContext(Dispatchers.Main){
                    binding.editNome.setText("")
                }
            }*/
          /*  val usuario = Usuario(
                0,
                "elanilsonpp@hotmail.com",
                nome,
                "123",
                28,
                59.80,
                27.00,
               // Endereco("x",10),
                Date(),
               // "M"
            )
            val endereco = Endereco(0,"xxt")
           CoroutineScope(Dispatchers.IO).launch {
               usuarioDao.salvar(usuario)
               enderecoDao.salvar(endereco)
              withContext(Dispatchers.Main){
                  binding.editNome.setText("")
              }
           }*/
        }
        binding.btnRemover.setOnClickListener {
            val usuario = Usuario(
                2,
                "elanilsonpp@hotmail.com",
                "Maria",
                "123",
                28,
                59.80,
                27.00,
              //  Endereco("x",10),
                Date(),
              //  "M"
            )
            CoroutineScope(Dispatchers.IO).launch {
                usuarioDao.delete(usuario)
            }
        }
        binding.btnAtualizar.setOnClickListener {
            val usuario = Usuario(
                3,
                "elanilsonpp@hotmail.com",
                "Atualizei",
                "123",
                28,
                59.80,
                27.00,
            //    Endereco("x",10),
                Date(),
              //  "M"
            )

            CoroutineScope(Dispatchers.IO).launch {
                usuarioDao.update(usuario)
            }
        }
        binding.btnListar.setOnClickListener {
          /*  CoroutineScope(Dispatchers.IO).launch {
           //   val listaUsuario =  usuarioDao.listar()
                val nome = binding.editNome.text.toString()
              val listaUsuario =  usuarioDao.filtrar(nome)
                val textiView = binding.textListaUsuarios
                var textoUsuario = ""

                listaUsuario.forEach {usuario->
                    val formatador = SimpleDateFormat("dd/MM/yyyy")
                    val dataFormatada = formatador.format(usuario.data)
                    textoUsuario += "${usuario.nome} - data ${dataFormatada} \n"
                    Log.d("MyProjeto",usuario.toString())
                }

                withContext(Dispatchers.Main){
                    textiView.text = textoUsuario
                }

            }*/

         /*   CoroutineScope(Dispatchers.IO).launch {
                //   val listaUsuario =  usuarioDao.listar()

                val lista =  produtoDao.listarprodutosEProdutoDeTalhes()
                val textiView = binding.textListaUsuarios
                var textoUsuario = ""

                lista.forEach {produto->
                    val idProduto = produto.produto.idProduto
                    val nome = produto.produto.nome
                    val marca = produto.produtoDetalhe.marca
                    val descricao = produto.produtoDetalhe.descricao

                    textoUsuario += "${idProduto} - data ${nome} \n" +
                            "${marca} - data ${descricao}"
                   // Log.d("MyProjeto",usuario.toString())
                }

                withContext(Dispatchers.Main){
                    textiView.text = textoUsuario
                }

            }*/

          /*  CoroutineScope(Dispatchers.IO).launch {
                //   val listaUsuario =  usuarioDao.listar()

                val lista =  clientePedidoDao.listarClientesComPedidos()
                val textiView = binding.textListaUsuarios
                var textoUsuario = ""

                lista.forEach {clientesComPedidos->
                    val idCliente = clientesComPedidos.cliente.idCliente
                    val nome = clientesComPedidos.cliente.nome
                    textoUsuario += "cliente - $idCliente - ${nome} \n"
                    val pedidos = clientesComPedidos.pedidos
                    pedidos.forEach { pedido ->
                        val id = pedido.idPedido
                        val nome = pedido.produto
                        textoUsuario += "+ id - $id - $nome \n"
                    }



                    // Log.d("MyProjeto",usuario.toString())
                }

                withContext(Dispatchers.Main){
                    textiView.text = textoUsuario
                }

            }*/

            CoroutineScope(Dispatchers.IO).launch {
                //   val listaUsuario =  usuarioDao.listar()

                val lista =  pessoaComputadorDao.pessoasComCumputadores()
                val textiView = binding.textListaUsuarios
                var textoUsuario = ""

                lista.forEach {pessoaCompc->
                    val idPessoa = pessoaCompc.pessoa.idPessoa
                    val nome = pessoaCompc.pessoa.nome
                    textoUsuario += "cliente - $idPessoa - ${nome} \n"
                    val pedidos = pessoaCompc.computadores
                    pedidos.forEach { comput ->
                        val id = comput.idComputador
                        val nome = comput.marca
                        textoUsuario += "+ id - $id - $nome \n"
                    }



                    // Log.d("MyProjeto",usuario.toString())
                }

                withContext(Dispatchers.Main){
                    textiView.text = textoUsuario
                }

            }
        }

    }
}