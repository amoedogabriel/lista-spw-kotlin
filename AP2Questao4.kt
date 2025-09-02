fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val todosOsItens = estoque.getItens()

    val itensValidos = todosOsItens.count { it.valido() }
    val itensVencidos = todosOsItens.count { !it.valido() }
    val totalItens = estoque.qtdItens()

    println("###### BALANÇO DE VALIDADE DO ESTOQUE ######")
    println("Itens válidos (não vencidos): $itensValidos")
    println("Itens vencidos: $itensVencidos")
    println("Soma (Válidos + Vencidos): ${itensValidos + itensVencidos}")
    println("Total de itens no estoque: $totalItens")
    println("-------------------------------------------------")
    if ((itensValidos + itensVencidos) == totalItens) {
        println("A verificação bate: a soma de itens válidos e vencidos é igual ao total.")
    } else {
        println("A verificação não bate: a soma está incorreta.")
    }
}