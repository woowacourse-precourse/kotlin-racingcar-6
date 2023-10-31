package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Constants.NUMBER_ATTEMPTS_MSG
import racingcar.Constants.RACE_START_MSG

class ApplicationTest : NsTest() {
    private val racing: Racing = Racing()

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
    fun `이름 중복에 대한 예외 처리`() {
        assertSimpleTest {
            val carNames = listOf("abc", "abc", "aa", "bb")
            assertThrows<IllegalArgumentException> { isCarNameUnique(carNames) }
        }
    }

    @Test
    fun `이름 길이에 대한 예외 처리`() {
        assertSimpleTest {
            val carNames = listOf("hello", "sponge", "bob", "haha")
            assertThrows<IllegalArgumentException> {
                carNames.forEach { isCarNameLengthValid(it) }
            }
        }
    }

    @Test
    fun `이름 공백에 대한 예외 처리`() {
        assertSimpleTest {
            val carNames = listOf("hello", " ", "", "hey")
            assertThrows<IllegalArgumentException> {
                carNames.forEach { isCarNameNotEmpty(it) }
            }
        }
    }

    @Test
    fun `시도 횟수 입력에 대한 예외 처리`() {
        assertSimpleTest {
            val attempts = listOf("0", "", "2", "10", "a", "ㄱ")
            assertThrows<IllegalArgumentException> {
                attempts.forEach { isNumberAttemptsValid(it) }
            }
        }
    }

    @Test
    fun `전진 정지 판단`() {
        assertSimpleTest {
            val randomNumbers = listOf(1, 5, 4, 2, 6)
            val results: MutableList<Boolean> = MutableList<Boolean>(5) { false }
            randomNumbers.forEachIndexed { idx, i -> results[idx] = racing.determineMoveOrStop(i) }
            assertThat(results).isEqualTo(listOf(false, true, true, false, true))
        }
    }

    @Test
    fun `단일 우승자 판별`() {
        assertSimpleTest {
            val cars: List<Car> = listOf(Car("T1", 10), Car("KT", 2), Car("Gen.G", 7))
            val results = racing.getWinner(cars)
            assertThat(results).isEqualTo("T1")
        }
    }

    @Test
    fun `다중 우승자 판별`() {
        assertSimpleTest {
            val cars: List<Car> = listOf(Car("Bear", 3), Car("Dog", 6), Car("Cat", 7), Car("Tiger", 7))
            val results = racing.getWinner(cars)
            assertThat(results).isEqualTo("Cat, Tiger")
        }
    }

    @Test
    fun `움직인 거리 출력`() {
        assertSimpleTest {
            val attempts = 5
            val cars: List<Car> = listOf(Car("Bear", 0), Car("Dog", 0), Car("Cat", 0), Car("Tiger", 0))
            racing.getRacingDistances(attempts, cars)
        }
    }

    @Test
    fun `최종 우승자 출력`() {
        assertSimpleTest {
            run {
                val cars: List<Car> = listOf(Car("Bear", 3), Car("Dog", 6), Car("Cat", 7), Car("Tiger", 7))
                racing.printWinner(racing.getWinner(cars))
            }
            assertThat(output()).isEqualTo("최종 우승자 : Cat, Tiger")
        }
    }

    @Test
    fun `경기 과정 출력`() {
        assertSimpleTest {
            run {
                val cars: List<Car> = listOf(Car("Cat", 1),  Car("Dog", 3))
                racing.printMatchProgress(cars)
            }
            assertThat(output()).isEqualTo("Cat : -\n" + "Dog : ---" )
        }
    }

    @Test
    fun `경기 시작 출력`() {
        assertSimpleTest {
            run {
                printRaceStart(RACE_START_MSG)
            }
            assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.")
        }
    }

    @Test
    fun `시도 횟수 메세지 출력`() {
        assertSimpleTest {
            run {
                printNumberAttempts(NUMBER_ATTEMPTS_MSG)
            }
            assertThat(output()).isEqualTo("시도할 횟수는 몇 회인가요?")
        }
    }

    public override fun runMain() {
        main()
    }


    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
