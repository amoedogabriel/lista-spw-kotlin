fun main() {
    val spw = SupermercadoWeb()

    println("###### PRODUTOS MAIS BARATOS POR GÊNERO (BASEADO NO ESTOQUE) ######")


    val todosOsItensNoEstoque = spw.estoque.getItens()


    spw.getGeneros().forEach { genero ->
        println("\n--- Gênero: ${genero.nome} ---")


        val itensDoGenero = todosOsItensNoEstoque.filter { it.getProduto().getGenero().nome == genero.nome }

        if (itensDoGenero.isEmpty()) {
            println("Nenhum item deste gênero foi encontrado no estoque.")
        } else {

            println("Itens encontrados no estoque:")
            itensDoGenero.forEach { item ->
                val produto = item.getProduto()
                println(
                    "  - ${produto.nome} (Marca: ${produto.getMarca().nome}) - R$${"%.2f".format(produto.preco)}"
                )
            }


            val itemMaisBarato = itensDoGenero.minByOrNull { it.getProduto().preco }


            if (itemMaisBarato != null) {
                val produtoMaisBarato = itemMaisBarato.getProduto()
                println("--------------------------------------------------")
                println(
                    ">> O MAIS BARATO: ${produtoMaisBarato.nome} " +
                            "(Marca: ${produtoMaisBarato.getMarca().nome}) - " +
                            "Preço: R$${"%.2f".format(produtoMaisBarato.preco)}"
                )
                println("--------------------------------------------------")
            }
        }
    }
}