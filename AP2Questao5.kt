fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinho = spw.carrinho

    val itensParaMover = estoque.getItens().filter { it.getCodigo() % 2 != 0L }
    itensParaMover.forEach { item ->
        carrinho.adicionaItem(item, estoque)
    }

    println("###### ITENS NO CARRINHO (CÓDIGO ÍMPAR) ######")
    carrinho.getItens().forEach { item ->
        val p = item.getProduto()
        println("Cód: ${item.getCodigo()}, Nome: ${p.nome}, Preço: R$${"%.2f".format(p.preco)}")
    }
    println("--------------------------------------------------")
    println("Quantidade de itens no carrinho: ${carrinho.getItens().size}")
    println("Total a pagar: R$${"%.2f".format(carrinho.totalAPagar())}")
    println("\n")

    println("###### ITENS RESTANTES NO ESTOQUE ######")
    estoque.getItens().forEach { item ->
        val p = item.getProduto()
        println("Cód: ${item.getCodigo()}, Nome: ${p.nome}, Gênero: ${p.getGenero().nome}")
    }
    println("--------------------------------------------------")
    println("Total de itens restantes no estoque: ${estoque.qtdItens()}")
}