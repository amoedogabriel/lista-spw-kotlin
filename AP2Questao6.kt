import kotlin.random.Random

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinho = spw.carrinho

    val itensValidos = estoque.getItens().filter { it.valido() }.toMutableList()
    val quantidadeParaAdicionar = if (itensValidos.isNotEmpty()) Random.nextInt(1, itensValidos.size + 1) else 0

    repeat(quantidadeParaAdicionar) {
        if (itensValidos.isNotEmpty()) {
            val itemAleatorio = itensValidos.random()
            carrinho.adicionaItem(itemAleatorio, estoque)
            itensValidos.remove(itemAleatorio)
        }
    }

    println("###### ITENS NO CARRINHO (ALEATÓRIOS E VÁLIDOS) ######")
    carrinho.getItens().forEach { item ->
        val p = item.getProduto()
        println("Cód: ${item.getCodigo()}, Nome: ${p.nome}, Preço: R$${"%.2f".format(p.preco)}")
    }
    println("--------------------------------------------------")
    println("Quantidade de itens no carrinho: ${carrinho.getItens().size}")
    println("\n")

    println("###### ITENS RESTANTES NO ESTOQUE ######")
    estoque.getItens().forEach { item ->
        val p = item.getProduto()
        println("Cód: ${item.getCodigo()}, Nome: ${p.nome}, Gênero: ${p.getGenero().nome}")
    }
    println("--------------------------------------------------")
    println("Total de itens restantes no estoque: ${estoque.qtdItens()}")
}