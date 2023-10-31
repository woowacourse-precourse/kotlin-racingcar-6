package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarTest {
    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
        private const val NORMAL_NAME_1 = "pobi"
        private const val NORMAL_NAME_2 = "woni"
        private const val ABNORMAL_NAME_LIST_LONG = "pobi,HoguOgu"
        private const val ABNORMAL_NAME_LIST_NONAME_AFTER = "pobi,woni,"
        private const val ABNORMAL_NAME_LIST_NOT_LETTER = "pobi, woni"
        private const val ABNORMAL_ROUND_NUMBER_NOT_NUMBER = "One"
        private const val ABNORMAL_ROUND_NUMBER_UNDER_ONE = "0"
        private const val ABNORMAL_ROUND_NUMBER_EXCEED_INT_RANGE = "1000000000000"
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
        val carNameList = ABNORMAL_NAME_LIST_LONG.split(",")
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이름에 대한 예외처리(이름이 주어지지 않은 경우)`() {
        val carNameList = ABNORMAL_NAME_LIST_NONAME_AFTER.split(",")
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이름에 대한 예외처리(글자가 아닌 특수문자가 들어가는 경우 (공백 등))`() {
        val carNameList = ABNORMAL_NAME_LIST_NOT_LETTER.split(",")
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이름에 대한 예외처리(입력이 null인 경우)`() {
        val carNameList = emptyList<String>()
        assertThrows<IllegalArgumentException> { inputView.checkCarNameList(carNameList) }
    }

    @Test
    fun `이동 횟수 예외처리(숫자가 아닌 경우)`() {
        val roundNumber = ABNORMAL_ROUND_NUMBER_NOT_NUMBER
        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(roundNumber) }
    }

    @Test
    fun `이동 횟수 예외처리(0 이하인 경우)`() {
        val roundNumber = ABNORMAL_ROUND_NUMBER_UNDER_ONE
        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(roundNumber) }
    }

    @Test
    fun `이동 횟수 예외처리(Int 범위를 벗어나는 경우)`() {
        val roundNumber = ABNORMAL_ROUND_NUMBER_EXCEED_INT_RANGE
        assertThrows<IllegalArgumentException> { inputView.checkRoundNumber(roundNumber) }
    }

    @Test
    fun `전진 기능 확인`() {
        val car = Car(NORMAL_NAME_1)
        race.moveOrStop(car, MOVING_FORWARD)
        assertThat(car).isEqualTo(Car(NORMAL_NAME_1, 1))
    }

    @Test
    fun `정지 기능 확인`() {
        val car = Car(NORMAL_NAME_1)
        race.moveOrStop(car, STOP)
        assertThat(car).isEqualTo(Car(NORMAL_NAME_1, 0))
    }

    @Test
    fun `단독 우승자 출력 확인`() {
        val carLists = listOf(Car(NORMAL_NAME_1, 1), Car(NORMAL_NAME_2, 0))
        outputView.printWinner(race.getWinnerList(carLists))
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : $NORMAL_NAME_1")
    }

    @Test
    fun `공동 우승자 출력 확인`() {
        val carLists = listOf(Car(NORMAL_NAME_1, 1), Car(NORMAL_NAME_2, 1))
        outputView.printWinner(race.getWinnerList(carLists))
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : $NORMAL_NAME_1, $NORMAL_NAME_2")
    }
}