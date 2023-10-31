package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrinterTest : NsTest() {

    @Test
    fun `경주 자동차 이름 입력 안내 메시지 테스트`() {
        val printer = Printer()
        printer.printInputRacingCarNamesMessage()
        Assertions.assertThat(output()).contains(Messages.INPUT_RACING_CAR_NAMES)
    }

    @Test
    fun `시도 횟수 입력 안내 메시지 테스트`() {
        val printer = Printer()
        printer.printInputTryTimeMessage()
        Assertions.assertThat(output()).contains(Messages.INPUT_TRY_TIME)
    }

    @Test
    fun `경주 자동차 상태 출력 테스트`() {
        val printer = Printer()
        val cars = listOf(
            RacingCar.createOrThrow("pobi"),
            RacingCar.createOrThrow("mando")
        )
        repeat(3) {
            cars[1].move()
        }
        printer.printRacingCarStates(cars)
        Assertions.assertThat(output()).contains(Messages.TRY_RESULT, "pobi : ", "mando : ---")
    }

    @Test
    fun `우승자 출력 테스트`() {
        val printer = Printer()
        val names = listOf("pobi", "mando")
        printer.printWinners(names)
        Assertions.assertThat(output()).contains("${Messages.WINNER}pobi, mando")
    }

    override fun runMain() {
    }
}