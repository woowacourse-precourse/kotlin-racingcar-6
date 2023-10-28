package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.exception.ExceptionChecker
import racingcar.io.Input
import racingcar.io.UserInterface
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.IllegalArgumentException
import java.util.*

class IoTest {
    private val originalSystemIn = System.`in`
    private val originalSystemOut = System.out

    private val carNameInput1 = ByteArrayInputStream("aaa,bbb,ccc,ddd".toByteArray())

    private val tryNumberInput1 = ByteArrayInputStream("5".toByteArray())

    private val outputStream = ByteArrayOutputStream()


    @BeforeEach
    fun setUp() {

        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalSystemIn)
        System.setOut(originalSystemOut)
    }


    @Test
    fun `자동차 이름 입력 받기 함수`() {
        System.setIn(carNameInput1)
        val ui = UserInterface()

        val carNames = ui.enterCarNames()
        val expected = listOf("aaa", "bbb", "ccc", "ddd")
        val expectedOutput = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"

        val consoleOutput = outputStream.toString().trim()

        assertThat(consoleOutput).isEqualTo(expectedOutput)
        assertThat(carNames).isEqualTo(expected)
    }


    @Test
    fun `자동차 이름 입력 예외 테스트1`() {

        val checker = ExceptionChecker()
        val cars = listOf("abc", "123456")
        assertThrows<IllegalArgumentException>() {
            checker.checkCarNames(cars)
        }

    }


    @Test
    fun `자동차 이름 입력 예외 테스트2`() {


        val checker = ExceptionChecker()
        val cars = listOf("abc", "", "def", "aaa")
        assertThrows<IllegalArgumentException>() {
            checker.checkCarNames(cars)
        }

    }


    @Test
    fun `자동차 이름 입력 예외 테스트3`() {


        val checker = ExceptionChecker()
        val cars = listOf("   ", "abc", "aaa")
        assertThrows<IllegalArgumentException>() {
            checker.checkCarNames(cars)
        }

    }


}