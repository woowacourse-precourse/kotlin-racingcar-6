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
    fun `이름에 대한 예외처리(5자 초과 이름)`() {
        val carNameList = "pobi,HoguOgu".split(",")
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이름에 대한 예외처리(이름이 주어지지 않은 경우)`() {
        val carNameList = "pobi,woni,".split(",")
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이름에 대한 예외처리(글자가 아닌 특수문자가 들어가는 경우 (공백 등))`() {
        val carNameList = "pobi, woni".split(",")
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이름에 대한 예외처리(입력이 null인 경우)`() {
        val carNameList = emptyList<String>()
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이동 횟수 예외처리(숫자가 아닌 경우)`() {
        val attemptNumber = "One"
        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(attemptNumber) }
    }

    @Test
    fun `이동 횟수 예외처리(0 이하인 경우)`() {
        val roundNumber = "0"
        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(roundNumber) }
    }

    @Test
    fun `이동 횟수 예외처리(Int 범위를 벗어나는 경우)`() {
        val roundNumber = "1000000000000"
        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(roundNumber) }
    }

    @Test
    fun `자동차 리스트 만들기`() {
        val racingCarNameList = listOf("pobi", "woni")

        val racingCarList = race.getRacingCarList(racingCarNameList)

        assertThat(racingCarList).contains(Car("woni"), Car("pobi"))
        assertThat(racingCarList).containsExactly(Car("pobi"), Car("woni"))
    }

    @Test
    fun `전진 기능 확인`() {
        val car = Car("pobi")
        race.moveOrStop(car, MOVING_FORWARD)
        assertThat(car).isEqualTo(Car("pobi", 1))
    }

    @Test
    fun `정지 기능 확인`() {
        val car = Car("pobi")
        race.moveOrStop(car, STOP)
        assertThat(car).isEqualTo(Car("pobi", 0))
    }

    @Test
    fun `단독 우승자 출력 확인`() {
        val carLists = listOf(Car("pobi", 1), Car("woni", 0))
        outputView.printWinner(race.getWinnerList(carLists))
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun `공동 우승자 출력 확인`() {
        val carLists = listOf(Car("pobi", 1), Car("woni", 1))

        outputView.printWinner(race.getWinnerList(carLists))

        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, woni")
    }
}