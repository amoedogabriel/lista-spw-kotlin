class Carrinho {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun adicionaItem(item: ItemProduto, estoque: Estoque) {
        estoque.saiItem(item)?.let {
            itens.add(it)
        }
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itens.remove(item)) {
            estoque.entraItem(item)
        }
    }

    fun getItens(): List<ItemProduto> {
        return itens.toList()
    }

    fun totalAPagar(): Double {
        return itens.sumOf { it.getProduto().preco.toDouble() }
    }
}