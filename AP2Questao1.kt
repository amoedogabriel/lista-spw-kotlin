fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    println("###### ESTOQUE ######")
    println("CÓD NOME MARCA GENERO PREÇO VALIDADE VÁLIDO?")
    println("--------------------------------------------------------------------------")

    estoque.getItens().forEach { item ->
        val produto = item.getProduto()
        val valido = if (item.valido()) "sim" else "não"
        println(
            "${item.getCodigo()} ${produto.nome} ${produto.getMarca().nome} ${produto.getGenero().nome} " +
                    "R$${"%.2f".format(produto.preco)} ${item.getValidade()} $valido"
        )
    }

    println("--------------------------------------------------------------------------")
    println("TOTAL: ${estoque.qtdItens()} itens.")
}