fun main() {
    val spw = SupermercadoWeb()

    print("Digite o nome de um gênero (Leite, Achocolatado, Presunto): ")
    val nomeGenero = readLine()

    val generoEscolhido: Genero? = when (nomeGenero?.trim()?.lowercase()) {
        "leite" -> Leite()
        "achocolatado" -> Achocolatado()
        "presunto" -> Presunto()
        else -> null
    }

    if (generoEscolhido == null) {
        println("Gênero inválido ou não encontrado.")
        return
    }

    val itensDoGenero = spw.estoque.getItens(generoEscolhido)

    println("\n###### ESTOQUE DO GÊNERO: ${generoEscolhido.nome} ######")
    println("CÓD NOME GENERO MARCA PREÇO VALIDADE VÁLIDO?")
    println("--------------------------------------------------------------------------")

    if (itensDoGenero.isNotEmpty()) {
        itensDoGenero.forEach { item ->
            val p = item.getProduto()
            val valido = if (item.valido()) "sim" else "não"
            println(
                "${item.getCodigo()} ${p.nome} ${p.getGenero().nome} ${p.getMarca().nome} " +
                        "R$${"%.2f".format(p.preco)} ${item.getValidade()} $valido"
            )
        }
    } else {
        println("Nenhum item encontrado para este gênero.")
    }
    println("--------------------------------------------------------------------------")
    println("TOTAL: ${itensDoGenero.size} itens.")
}