package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car

class ApplicationTest : NsTest() {
    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `askCarName 메서드로 이름 분리`() {
        //given
        val carNames: MutableList<Car> = mutableListOf()
        val input = "pobi,java,joon,car"

        //when
        val result = askCarName(carNames, input)

        //then
        assertThat(result).hasSize(4)
        assertThat(result[0].name).isEqualTo("pobi")
        assertThat(result[1].name).isEqualTo("java")
        assertThat(result[2].name).isEqualTo("joon")
        assertThat(result[3].name).isEqualTo("car")
    }

    @Test
    fun `askCarName 메서드 사용시 이름이 5자 이상일 때 예외 발생`() {
        //given
        val carNames: MutableList<Car> = mutableListOf()
        val input = "pobi,java,joontae,car"

        //then
        assertThrows<IllegalArgumentException>("String index out of range: 5")
        { askCarName(carNames, input) }
    }

    @Test
    fun `askNumber 메서드로 String형을 Int형으로`() {
        //given
        val input = "1"
        val result = 1

        //then
        assertThat(askNumber(input)).isEqualTo(1)
    }

    @Test
    fun `askNumber 메서드 문자 입력 시 예외 발생`() {
        //given
        val input = "1"
        val result = 1

        //then
        assertThat(askNumber(input)).isEqualTo(result)
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
