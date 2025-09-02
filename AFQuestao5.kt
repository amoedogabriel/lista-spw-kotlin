import kotlin.random.Random

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinho = spw.carrinho


    println("###### 1. ESTADO INICIAL ######")
    println("Itens no Estoque: ${estoque.qtdItens()}")
    println("Itens no Carrinho: ${carrinho.getItens().size}\n")


    println("###### 2. MOVENDO 10 ITENS ALEATÓRIOS PARA O CARRINHO ######")
    val itensDisponiveis = estoque.getItens().toMutableList()
    val numItensParaAdicionar = minOf(10, itensDisponiveis.size)

    if (numItensParaAdicionar > 0) {
        repeat(numItensParaAdicionar) {
            val itemAleatorio = itensDisponiveis.random(Random)


            val p = itemAleatorio.getProduto()
            println("-> Movendo para o carrinho: Cód ${itemAleatorio.getCodigo()}, ${p.nome}, R$${"%.2f".format(p.preco)}")

            carrinho.adicionaItem(itemAleatorio, estoque)
            itensDisponiveis.remove(itemAleatorio)
        }
    }

    println("\n###### ESTADO APÓS ADICIONAR ITENS ######")
    println("Itens no Estoque: ${estoque.qtdItens()}")
    println("Itens no Carrinho: ${carrinho.getItens().size}\n")


    println("###### 3. DEVOLVENDO TODOS OS ITENS PARA O ESTOQUE ######")
    val itensNoCarrinho = carrinho.getItens().toList()

    itensNoCarrinho.forEach { item ->

        val p = item.getProduto()
        println("<- Devolvendo para o estoque: Cód ${item.getCodigo()}, ${p.nome}")

        carrinho.removeItem(item, estoque)
    }

    println("\n###### ESTADO FINAL ######")
    println("Itens no Estoque: ${estoque.qtdItens()}")
    println("Itens no Carrinho: ${carrinho.getItens().size}")
}