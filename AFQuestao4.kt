fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque


    val lucroPotencial = estoque.getItens().sumOf { it.getProduto().preco.toDouble() }
    println("###### ESTOQUE COMPLETO E LUCRO POTENCIAL ######")
    println("Total de itens no estoque inicial: ${estoque.qtdItens()}")
    println("Lucro potencial com a venda de todos os itens: R$${"%.2f".format(lucroPotencial)}")
    println("----------------------------------------------------------\n")


    val itensVencidos = estoque.getItens().filter { !it.valido() }
    val prejuizo = itensVencidos.sumOf { it.getProduto().preco.toDouble() }

    itensVencidos.forEach { item ->
        estoque.saiItem(item)
    }


    println("###### ESTOQUE APÓS REMOÇÃO DE VENCIDOS ######")
    println("Total de itens no estoque agora: ${estoque.qtdItens()}")
    println("Prejuízo com itens vencidos descartados: R$${"%.2f".format(prejuizo)}")
    println("----------------------------------------------------------\n")


    val lucroReal = lucroPotencial - prejuizo
    println("###### LUCRO REAL ######")
    println("Lucro real (Potencial - Prejuízo): R$${"%.2f".format(lucroReal)}")
}