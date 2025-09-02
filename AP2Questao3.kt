fun main() {
    val spw = SupermercadoWeb()
    val itensValidos = spw.estoque.getItens().filter { it.valido() }
    val itensAgrupados = itensValidos.groupBy { it.getProduto().getGenero().nome to it.getProduto().getMarca().nome }

    println("###### ESTOQUE POR GÊNERO E MARCA (VÁLIDOS) ######")
    println("CÓD NOME GENERO MARCA PREÇO VALIDADE VÁLIDO?")
    println("--------------------------------------------------------------------------")

    itensAgrupados.forEach { (_, itens) ->
        itens.forEach { item ->
            val produto = item.getProduto()
            println(
                "${item.getCodigo()} ${produto.nome} ${produto.getGenero().nome} ${produto.getMarca().nome} " +
                        "R$${"%.2f".format(produto.preco)} ${item.getValidade()} sim"
            )
        }
    }
    println("--------------------------------------------------------------------------")
    println("TOTAL: ${itensValidos.size} itens.")
}