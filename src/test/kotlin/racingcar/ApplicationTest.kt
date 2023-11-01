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
    fun `4이상의 숫자 입력 시 count 증가`() {
        var car = Car("pobi")
        var now = car.count
        car.move(5)
        var after = car.count
        assertThat(now+1).isEqualTo(after)
    }

    @Test
    fun `4미만의 숫자 입력 시 count 변화 없음`() {
        var car = Car("pobi")
        var now = car.count
        car.move(3)
        var after = car.count
        assertThat(now).isEqualTo(after)
    }

    @Test
    fun `count의 수 만큼 '-' 출력하기`(){
        var name = "pobi"
        var car = Car(name)
        car.move(5)
        car.move(6)
        car.move(7)
        var output = "pobi : ---"
        assertThat(output).isEqualTo("${car.name} : ${"-".repeat(car.count)}")
    }



    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}