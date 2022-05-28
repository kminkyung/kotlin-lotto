package lotto.model

import lotto.Const

class LottoNumber(
    private val value: Int
) {
    init {
        require(value in MIN_LOTTO_NUM..MAX_LOTTO_NUM) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
    }

    fun get() = value

    override fun equals(other: Any?): Boolean = (value == (other as? LottoNumber)?.value)

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        const val MIN_LOTTO_NUM = 1
        const val MAX_LOTTO_NUM = 45

        fun random(): LottoNumber {
            val number = (MIN_LOTTO_NUM..MAX_LOTTO_NUM).random()
            return LottoNumber(number)
        }
    }
}