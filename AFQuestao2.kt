fun main() {
    val spw = SupermercadoWeb()

    try {
        print("Digite uma data de referência (dd/mm/aaaa): ")
        val input = readLine()!!.split("/")
        val dia = input[0].toInt()
        val mes = input[1].toInt()
        val ano = input[2].toInt()
        val dataReferencia = Data(dia, mes, ano)

        val itensVencidosRef = spw.estoque.getItens().filter {
            it.getValidade().antes(dataReferencia)
        }

        println("\n###### ITENS VENCIDOS ANTES DE ${dataReferencia} ######")
        if (itensVencidosRef.isNotEmpty()) {
            itensVencidosRef.forEach { item ->
                val p = item.getProduto()
                println(
                    "Cód: ${item.getCodigo()}, Nome: ${p.nome}, " +
                            "Marca: ${p.getMarca().nome}, Validade: ${item.getValidade()}"
                )
            }
            println("-----------------------------------------------------")
            println("Quantidade total: ${itensVencidosRef.size}")
        } else {
            println("Nenhum item encontrado com validade anterior à data fornecida.")
        }

    } catch (e: Exception) {
        println("Formato de data inválido. Use dd/mm/aaaa.")
    }
}