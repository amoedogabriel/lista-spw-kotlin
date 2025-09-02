class ItemProduto(
    private val codigo: Long,
    private val validade: Data,
    private val produto: Produto
) {
    fun getCodigo(): Long = codigo
    fun getProduto(): Produto = produto
    fun getValidade(): Data = validade

    fun valido(): Boolean {
        return validade.depois(Data.dataHoje())
    }
}