package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setup() {
        lotto = Lotto()
    }

    @Test
    fun `로또가 발행될 때 번호가 발급된다`() {
        lotto.processLotto(listOf(1, 1, 1, 1, 1, 1))
        assertThat(lotto.numbers.size).isEqualTo(6)
        assertThat(lotto.numbers[1]).isNotEqualTo(0)
    }

    @Test
    fun `당첨 번호와 로또 번호가 일치한 양를 반환한다`() {
        lotto.processLotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getContainLottoNumberSameCount(listOf(2, 9, 3, 11, 10, 1))).isEqualTo(3)
    }

    @ParameterizedTest
    @CsvSource("3,5000", "4,50000", "5,1500000", "6,2000000000", "2,0")
    fun `로또 번호와 당첨 번호가 3개 일치한다면 5000원으로 교환한다`(sameCount: Int, winningMoney: Int) {
        assertThat(lotto.exchangeWinningMoney(sameCount)).isEqualTo(winningMoney)
    }
}