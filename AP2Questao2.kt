fun main() {
    val spw = SupermercadoWeb()

    println("###### ESTOQUE POR GÊNERO ######")
    println("CÓD NOME GENERO MARCA PREÇO VALIDADE VÁLIDO?")
    println("--------------------------------------------------------------------------")

    val generos = spw.getGeneros()
    generos.forEach { genero ->
        val itensPorGenero = spw.estoque.getItens(genero)
        if (itensPorGenero.isNotEmpty()) {
            itensPorGenero.forEach { item ->
                val produto = item.getProduto()
                val valido = if (item.valido()) "sim" else "não"
                println(
                    "${item.getCodigo()} ${produto.nome} ${produto.getGenero().nome} ${produto.getMarca().nome} " +
                            "R$${"%.2f".format(produto.preco)} ${item.getValidade()} $valido"
                )
            }
            println("TOTAL GENERO: ${itensPorGenero.size} itens.")
            println("--------------------------------------------------------------------------")
        }
    }
    println("TOTAL GERAL: ${spw.estoque.qtdItens()} itens.")
}