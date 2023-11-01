package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.CarController

class InputTest {

    private val carController = CarController()

    @Test
    fun `자동차 이름 입력 시 처음에 쉼표(,)가 오는 경우 예외가 발생한다`() {
        val input = ",pobi,woni,jun"

        assertThrows<IllegalArgumentException> { carController.inputCarNameFromUser(input) }
    }

    @Test
    fun `자동차 이름 입력 시 마지막에 쉼표(,)가 오는 경우 예외가 발생한다`() {
        val input = "pobi,woni,jun,"

        assertThrows<IllegalArgumentException> { carController.inputCarNameFromUser(input) }
    }

    @Test
    fun `자동차 이름이 6자이상인 경우 예외가 발생한다`() {
        val input = "pobbbi,woni,jun"

        assertThrows<IllegalArgumentException> { carController.validCreateCars(input) }
    }

    @Test
    fun `자동차의 총 개수가 11이상인 경우 예외가 발생한다`() {
        val input = "유스,연어,아커,윤생,오션,두둠,쥬니,베로,아크,민트,베베,허브"

        assertThrows<IllegalArgumentException> { carController.inputCarNameFromUser(input) }
    }

    @Test
    fun `자동차 이름이 공백인 경우 예외가 발생한다`() {
        val input = "pobi,   ,woni,jun"

        assertThrows<IllegalArgumentException> { carController.validCreateCars(input) }
    }
}