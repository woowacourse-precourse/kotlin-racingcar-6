package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    fun `inputString 을 쉼표 기준으로 nameList 변환`() {
        val inputString = "pobi,woni,jun"
        val nameList = inputString.split(",").map { it.trim() }
        assertThat(nameList).contains("pobi", "woni", "jun")
    }

    @Test
    fun `names(String) 을 cars(List) 로 변환 테스트`() {
        val inputString = "pobi,woni,jun"
        val nameList = inputString.split(",").map { it.trim() }
        val names = inputString.split(",").map { it.trim() }
        val cars: List<Car> = names.map { Car(it) }
        assertThat(cars.map { it.name }).isEqualTo(nameList)
    }

    fun List<Car>.toStatusString(): String {
        val progressCharacter = "-"
        return this.map { "${it.name} : ${progressCharacter.repeat(it.location)}" }.joinToString("\n")
    }

    @Test
    fun `cars(List of Car) 로부터 현재 상태 출력 테스트`() {
        val inputString = "pobi,woni,jun"
        val nameList = inputString.split(",").map { it.trim() }
        val names = inputString.split(",").map { it.trim() }
        val cars: List<Car> = names.map { Car(it) }
        assertThat(cars.toStatusString()).isEqualTo("pobi : \nwoni : \njun : ")
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
