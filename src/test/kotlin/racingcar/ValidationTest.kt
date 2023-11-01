package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {

    private val validation = Validation()

    @Test
    fun `차량 이름을 정상적으로 입력했을 때`() {
        val carNames = "fubao,aibao,러바오,731"
        val carList = listOf(Car("fubao"), Car("aibao"), Car("러바오"), Car("731"))

        validation.isValidCarName(carNames, carList)
    }

    @Test
    fun `차량 이름을 2대 이상 입력하지 않았을 때`() {
        val carList = listOf(Car("fubao"))

        assertThrows<IllegalArgumentException> {
            validation.isValidNumberOfCars(carList)
        }
    }

    @Test
    fun `공백이 있거나 자동차 이름을 쉼표로 구분하지 않았을 때`() {
        val carNames = "aibao fubao"

        assertThrows<IllegalArgumentException> {
            validation.checkContainsSpace(carNames)
        }
    }

    @Test
    fun `중복된 이름이 있을 때`() {
        val carList = listOf(Car("fubao"), Car("fubao"))

        assertThrows<IllegalArgumentException> {
            validation.checkCarNameDuplication(carList)
        }
    }

    @Test
    fun `자동차 이름 5자 초과 했을 때`() {
        val carList = listOf(Car("huibao"), Car("bao"))

        assertThrows<IllegalArgumentException> {
            validation.checkCarNameLength(carList)
        }
    }

    @Test
    fun `자동차 이름 공란일 때`() {
        val carList = listOf(Car("fubao"), Car(""), Car("bao"))

        assertThrows<IllegalArgumentException> {
            validation.checkCarNameBlank(carList)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "3", "6", "10"])
    fun `시도 횟수를 정상적으로 입력했을 때`(invalidNum: String) {
        validation.isValidNumberOfAttempt(invalidNum)
    }

    @Test
    fun `시도 횟수를 입력하지 않았을 때`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            validation.checkNumberBlank(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "-", "abc", "ㅇ"])
    fun `시도 횟수 입력 시 문자를 입력했을 때`(input: String) {
        assertThrows<IllegalArgumentException> {
            validation.checkNumberOrNot(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -5, -10])
    fun `1보다 작은 수를 입력했을 때`(invalidNum: Int) {
        assertThrows<IllegalArgumentException> {
            validation.checkNumberOfAttemptOneAndMore(invalidNum)
        }
    }

}