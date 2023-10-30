package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.RacingCarController
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView


class RacingCarTest {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val racingCarController = RacingCarController(inputView, outputView)

    @Test
    fun `자동차 이름 5자 초과 입력 예외 처리`() {
        val racingCarNameList = "pobi,pobibic".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }


    @Test
    fun `자동차 이름 중복 입력 예외 처리`() {
        val racingCarNameList = "pobi,pobi".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }

    @Test
    fun `자동차 이름 쉼표(,) 뒤 빈값 예외 처리`() {
        val racingCarNameList = "pobi,woni,".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }

    @Test
    fun `자동차 이름 첫글자 공백 입력 예외 처리`() {
        val racingCarNameList = "pobi, woni".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }

    @Test
    fun `자동차 이름 한개 입력 입력 예외 처리`() {
        val racingCarNameList = "pobi".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }

    @Test
    fun `시도 횟수 1미만 입력 예외 처리`() {
        val attemptNumber = "0"

        assertThrows<IllegalArgumentException> { inputView.validateAttemptNumber(attemptNumber) }
    }

    @Test
    fun `시도 횟수 숫자아닌 값 입력 예외 처리`() {
        val attemptNumber = "one"

        assertThrows<IllegalArgumentException> { inputView.validateAttemptNumber(attemptNumber) }
    }

    @Test
    fun `자동차 리스트 만들기`() {
        val racingCarList = racingCarController.makeRacingCarList(listOf("pobi", "woni"))

        assertThat(racingCarList).contains(RacingCar("woni"), RacingCar("pobi"))
        assertThat(racingCarList).containsExactly(RacingCar("pobi"), RacingCar("woni"))
    }

    @Test
    fun `무작위 값 구하기`() {
        val randomNumber = racingCarController.generateRandomNumber()

        assertThat(randomNumber).isBetween(1, 9)
    }

    @Test
    fun `전진 판단하기`() {
        val movingCar = RacingCar("pobi")
        racingCarController.moveOrStop(movingCar, MOVING_FORWARD)

        assertThat(movingCar).isEqualTo(RacingCar("pobi", 1))
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}