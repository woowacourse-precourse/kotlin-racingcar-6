package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrinterTest : NsTest() {

    @Test
    fun `경주할 자동차 이름을 입력하세요 안내 문구`() {
        val printer = Printer()
        printer.printOutEnteringCarName()
        Assertions.assertThat(output()).contains(Message.ENTERING_CAR_NAME)
    }

    @Test
    fun `시도할 횟수는 몇 회인가요 안내 문구`() {
        val printer = Printer()
        printer.printOutEnteringAttemptsNumber()
        Assertions.assertThat(output()).contains(Message.ENTERING_ATTEMPTS_NUMBER)
    }

    @Test
    fun `실행결과 안내 문구 및 출력`() {
        val printer = Printer()
        val cars = listOf(
            Car("pobi"),
            Car("cop")
        )
        repeat(3) {
            cars[1].moveForward()
        }
        printer.printOutResultInformationText()
        printer.printOutCarsMoveResult(cars)
        Assertions.assertThat(output()).contains(Message.RESULT_INFORMATION_TEXT, "pobi : ", "cop : ---")
    }

    @Test
    fun `최종 우승자 여러명일 때 출력`() {
        val printer = Printer()
        val names = listOf(Car("cop"), Car("pobi"))
        printer.printOutRacingWinner(names)
        Assertions.assertThat(output()).contains("${Message.WINNERS}cop, pobi")
    }

    @Test
    fun `최종 우승자 한명일 때 출력`() {
        val printer = Printer()
        val names = listOf(Car("cop"))
        printer.printOutRacingWinner(names)
        Assertions.assertThat(output()).contains("${Message.WINNERS}cop")
    }

    override fun runMain() {
        TODO("Not yet implemented")
    }

}