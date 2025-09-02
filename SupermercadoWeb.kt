import kotlin.random.Random

class SupermercadoWeb {
    val estoque: Estoque
    val carrinho: Carrinho
    val carrinhoA: Carrinho
    val carrinhoB: Carrinho
    private val generos: List<Genero>
    private val marcas: List<Marca>
    private val produtos: List<Produto>

    init {
        estoque = Estoque()
        carrinho = Carrinho()
        carrinhoA = Carrinho()
        carrinhoB = Carrinho()

        generos = listOf(Leite(), Achocolatado(), Presunto())


        marcas = listOf(
            Marca("Laticínios Aurora"), Marca("Fazenda Feliz"), Marca("Via Láctea"),
            Marca("Doce Sabor"), Marca("ChocoBom"), Marca("Cacau Real"),
            Marca("Frios Premium"), Marca("Serrano"), Marca("Delibom")
        )


        produtos = listOf(
            Produto(101, "Leite Fresco", 7.50f, marcas[0], generos[0]),
            Produto(102, "Leite Pasto Verde", 8.20f, marcas[1], generos[0]),
            Produto(103, "Leite Galáxia", 9.00f, marcas[2], generos[0]),
            Produto(201, "Achocolatado Manhã", 11.30f, marcas[3], generos[1]),
            Produto(202, "Choco Power", 14.50f, marcas[4], generos[1]),
            Produto(203, "Puro Cacau", 16.00f, marcas[5], generos[1]),
            Produto(301, "Presunto Fatiado", 6.80f, marcas[6], generos[2]),
            Produto(302, "Presunto Montanha", 7.90f, marcas[7], generos[2]),
            Produto(303, "Presunto Defumado", 8.50f, marcas[8], generos[2])
        )

        iniciaSupermercado()
    }

    fun getMarcas(): List<Marca> = marcas
    fun getProdutos(): List<Produto> = produtos
    fun getGeneros(): List<Genero> = generos

    private fun iniciaSupermercado() {
        var itemCodigo: Long = 1001
        val random = Random(System.currentTimeMillis())


        val produtosLeite = produtos.filter { it.getGenero() is Leite }
        repeat(10) {
            val produto = produtosLeite.random(random)
            val ano = random.nextInt(2025, 2028)
            val mes = random.nextInt(1, 13)
            val dia = random.nextInt(1, 29)
            estoque.entraItem(ItemProduto(itemCodigo++, Data(dia, mes, ano), produto))
        }


        val produtosAchocolatado = produtos.filter { it.getGenero() is Achocolatado }
        repeat(10) {
            val produto = produtosAchocolatado.random(random)
            val ano = random.nextInt(2025, 2028)
            val mes = random.nextInt(1, 13)
            val dia = random.nextInt(1, 29)
            estoque.entraItem(ItemProduto(itemCodigo++, Data(dia, mes, ano), produto))
        }


        val produtosPresunto = produtos.filter { it.getGenero() is Presunto }
        repeat(10) {
            val produto = produtosPresunto.random(random)
            val ano = random.nextInt(2025, 2028)
            val mes = random.nextInt(1, 13)
            val dia = random.nextInt(1, 29)
            estoque.entraItem(ItemProduto(itemCodigo++, Data(dia, mes, ano), produto))
        }
    }
}