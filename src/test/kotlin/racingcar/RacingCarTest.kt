package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingCarTest {
    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
        private const val MOVE = "-"
    }

    private val inputView = InputView()
    private val outputView = OutputView()
    private val outputStream = ByteArrayOutputStream()
    private val racingCarController = RacingCarController(inputView, outputView)

    @BeforeEach
    fun init() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(System.out)
    }

    @Test
    fun `자동차 이름 5자 초과 입력 예외 처리`() {
        val racingCarNameList = "pobi,pobibic".split(",")

        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(racingCarNameList) }
    }

    @Test
    fun `자동차 이름 쉼표(,) 뒤 빈값 예외 처리`() {
        val racingCarNameList = "pobi,woni,".split(",")

        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(racingCarNameList) }
    }

    @Test
    fun `자동차 이름 첫글자 공백 입력 예외 처리`() {
        val racingCarNameList = "pobi, woni".split(",")

        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(racingCarNameList) }
    }

    @Test
    fun `자동차 이름 0개 입력 예외 처리`() {
        val racingCarNameList = emptyList<String>()

        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(racingCarNameList) }
    }

    @Test
    fun `시도 횟수 1미만 입력 예외 처리`() {
        val attemptNumber = "0"

        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(attemptNumber) }
    }

    @Test
    fun `시도 횟수 숫자아닌 값 입력 예외 처리`() {
        val attemptNumber = "one"

        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(attemptNumber) }
    }

    /*@Test
    fun `자동차 리스트 만들기`() {
        val racingCarNameList = listOf("pobi", "woni")

        val racingCarList = racingCarController.getRacingCarList(racingCarNameList)

        assertThat(racingCarList).contains(RacingCar("woni"), RacingCar("pobi"))
        assertThat(racingCarList).containsExactly(RacingCar("pobi"), RacingCar("woni"))
    }*/

    @Test
    fun `무작위 값 구하기`() {
        val randomNumber = racingCarController.getRandomNumber()

        assertThat(randomNumber).isBetween(1, 9)
    }

    /*@Test
    fun `전진 판단하기`() {
        val movingCar = RacingCar("pobi")

        racingCarController.moveOrStop(movingCar, MOVING_FORWARD)

        assertThat(movingCar).isEqualTo(RacingCar("pobi", 1))
    }*/

    /*@Test
    fun `정지 판단하기`() {
        val stoppedCar = RacingCar("pobi")

        racingCarController.moveOrStop(stoppedCar, STOP)

        assertThat(stoppedCar).isEqualTo(RacingCar("pobi", 0))
    }*/

    @Test
    fun `전진 실행 결과 출력하기`() {
        val racingCar = RacingCar("pobi", 1)

        outputView.printCurrentMove(racingCar)

        assertThat(outputStream.toString().trim()).isEqualTo("pobi : $MOVE")
    }

    @Test
    fun `정지 실행 결과 출력하기`() {
        val racingCar = RacingCar("pobi", 0)

        outputView.printCurrentMove(racingCar)

        assertThat(outputStream.toString().trim()).isEqualTo("pobi :")
    }

    /*@Test
    fun `우승자 1명 찾기`() {
        val racingCarList = listOf(RacingCar("pobi", 1), RacingCar("woni", 0))

        val winner = racingCarController.getWinnerList(racingCarList)

        assertThat(winner).contains(RacingCar("pobi", 1))
    }*/

    /*@Test
    fun `우승자 여러명 찾기`() {
        val racingCarList = listOf(RacingCar("pobi", 1), RacingCar("woni", 1))

        val winner = racingCarController.getWinnerList(racingCarList)

        assertThat(winner).contains(RacingCar("pobi", 1), RacingCar("woni", 1))
    }*/

    @Test
    fun `우승자 1명 안내하기`() {
        val racingCarList = listOf(RacingCar("pobi", 1), RacingCar("woni", 0))

        outputView.printWinner(racingCarController.getWinnerList(racingCarList))

        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun `우승자 여러명 안내하기`() {
        val racingCarList = listOf(RacingCar("pobi", 1), RacingCar("woni", 1))

        outputView.printWinner(racingCarController.getWinnerList(racingCarList))

        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, woni")
    }
}