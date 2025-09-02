class Produto(
    val codigo: Int,
    val nome: String,
    val preco: Float,
    private val marca: Marca,
    private val genero: Genero
) {
    fun getMarca(): Marca = marca
    fun getGenero(): Genero = genero
}