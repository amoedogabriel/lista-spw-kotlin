fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinhoA = spw.carrinhoA
    val carrinhoB = spw.carrinhoB

    val itensDoEstoque = estoque.getItens().toList()


    itensDoEstoque.forEach { item ->
        if (item.valido()) {
            carrinhoA.adicionaItem(item, estoque)
        } else {
            carrinhoB.adicionaItem(item, estoque)
        }
    }


    println("###### ESTADO FINAL DOS CARRINHOS E ESTOQUE ######\n")

    println("--- Carrinho A (Itens Válidos) ---")
    println("Quantidade: ${carrinhoA.getItens().size}")
    carrinhoA.getItens().forEach {
        println("  Cód: ${it.getCodigo()}, Nome: ${it.getProduto().nome}, Validade: ${it.getValidade()}")
    }
    println("Total a Pagar (Carrinho A): R$${"%.2f".format(carrinhoA.totalAPagar())}\n")

    println("--- Carrinho B (Itens Inválidos) ---")
    println("Quantidade: ${carrinhoB.getItens().size}")
    carrinhoB.getItens().forEach {
        println("  Cód: ${it.getCodigo()}, Nome: ${it.getProduto().nome}, Validade: ${it.getValidade()}")
    }
    println("\n")

    println("--- Estoque (Restante) ---")
    println("Quantidade: ${estoque.qtdItens()}")
}