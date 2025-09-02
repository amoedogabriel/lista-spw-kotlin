fun main() {
    val spw = SupermercadoWeb()

    print("Digite o nome de uma marca para buscar: ")
    val nomeMarca = readLine()

    if (nomeMarca.isNullOrBlank()) {
        println("Nome de marca inválido.")
        return
    }

    val marcaEncontrada = spw.getMarcas().find { it.nome.equals(nomeMarca, ignoreCase = true) }

    if (marcaEncontrada == null) {
        println("Marca não encontrada.")
        return
    }

    val itensEncontrados = spw.estoque.getItens(marcaEncontrada).filter { it.valido() }

    println("\n###### ITENS VÁLIDOS DA MARCA: ${marcaEncontrada.nome} ######")
    if (itensEncontrados.isNotEmpty()) {
        itensEncontrados.forEach { item ->
            val p = item.getProduto()
            println("Cód: ${item.getCodigo()}, Nome: ${p.nome}, Preço: R$${"%.2f".format(p.preco)}, Validade: ${item.getValidade()}")
        }
        println("--------------------------------------------------")
        println("Total de itens encontrados: ${itensEncontrados.size}")
    } else {
        println("Nenhum item válido encontrado para esta marca.")
    }
}