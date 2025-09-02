import java.time.LocalDate

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {

    fun getDia(): Int {
        return dia
    }

    fun getMes(): Int {
        return mes
    }

    fun getAno(): Int {
        return ano
    }

    fun setData(dia: Int, mes: Int, ano: Int) {
        this.dia = dia
        this.mes = mes
        this.ano = ano
    }

    override fun toString(): String {
        return "${"%02d".format(dia)}/${"%02d".format(mes)}/$ano"
    }

    fun antes(outraData: Data): Boolean {
        if (this.ano < outraData.ano) return true
        if (this.ano == outraData.ano && this.mes < outraData.mes) return true
        if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia < outraData.dia) return true
        return false
    }

    fun depois(outraData: Data): Boolean {
        if (this.ano > outraData.ano) return true
        if (this.ano == outraData.ano && this.mes > outraData.mes) return true
        if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia > outraData.dia) return true
        return false
    }

    fun igual(outraData: Data): Boolean {
        return this.dia == outraData.dia && this.mes == outraData.mes && this.ano == outraData.ano
    }

    companion object {
        fun dataHoje(): Data {
            val hoje = LocalDate.now()
            return Data(hoje.dayOfMonth, hoje.monthValue, hoje.year)
        }
    }
}