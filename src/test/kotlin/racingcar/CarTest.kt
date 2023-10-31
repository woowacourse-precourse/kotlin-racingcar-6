package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarTest {
    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
        private const val MOVE = "-"
    }

    private val inputView = InputView()
    private val outputView = OutputView()
    private val outputStream = ByteArrayOutputStream()
    private val race = Race()

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

    @Test
    fun `자동차 리스트 만들기`() {
        val racingCarNameList = listOf("pobi", "woni")

        val racingCarList = race.getRacingCarList(racingCarNameList)

        assertThat(racingCarList).contains(Car("woni"), Car("pobi"))
        assertThat(racingCarList).containsExactly(Car("pobi"), Car("woni"))
    }

    @Test
    fun `무작위 값 구하기`() {
        val randomNumber = race.getRandomNumber()

        assertThat(randomNumber).isBetween(1, 9)
    }

    @Test
    fun `전진 판단하기`() {
        val movingCar = Car("pobi")

        race.moveOrStop(movingCar, MOVING_FORWARD)

        assertThat(movingCar).isEqualTo(Car("pobi", 1))
    }

    @Test
    fun `정지 판단하기`() {
        val stoppedCar = Car("pobi")

        race.moveOrStop(stoppedCar, STOP)

        assertThat(stoppedCar).isEqualTo(Car("pobi", 0))
    }

    @Test
    fun `전진 실행 결과 출력하기`() {
        val car = Car("pobi", 1)

        outputView.printCurrentMove(car)

        assertThat(outputStream.toString().trim()).isEqualTo("pobi : $MOVE")
    }

    @Test
    fun `정지 실행 결과 출력하기`() {
        val car = Car("pobi", 0)

        outputView.printCurrentMove(car)

        assertThat(outputStream.toString().trim()).isEqualTo("pobi :")
    }

    @Test
    fun `우승자 1명 찾기`() {
        val carLists = listOf(Car("pobi", 1), Car("woni", 0))

        val winner = race.getWinnerList(carLists)

        assertThat(winner).contains(Car("pobi", 1))
    }

    @Test
    fun `우승자 여러명 찾기`() {
        val carLists = listOf(Car("pobi", 1), Car("woni", 1))

        val winner = race.getWinnerList(carLists)

        assertThat(winner).contains(Car("pobi", 1), Car("woni", 1))
    }

    @Test
    fun `우승자 1명 안내하기`() {
        val carLists = listOf(Car("pobi", 1), Car("woni", 0))

        outputView.printWinner(race.getWinnerList(carLists))

        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun `우승자 여러명 안내하기`() {
        val carLists = listOf(Car("pobi", 1), Car("woni", 1))

        outputView.printWinner(race.getWinnerList(carLists))

        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, woni")
    }
}