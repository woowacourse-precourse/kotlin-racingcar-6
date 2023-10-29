package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import racingcar.exception.ExceptionChecker
import racingcar.io.Input
import racingcar.io.UserInterface
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream
import java.lang.IllegalArgumentException


class IoTest {
    private val originalSystemIn = System.`in`
    private val originalSystemOut = System.out

    private val carNameInput1 = ByteArrayInputStream("aaa,bbb,ccc,ddd".toByteArray())

    private val tryNumberInput1 = ByteArrayInputStream("5".toByteArray())

    private val outputStream = ByteArrayOutputStream()
    private lateinit var ui: UserInterface


    @BeforeEach
    fun setUp() {
        ui = UserInterface()
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        Console.close()
        System.setOut(originalSystemOut)
        System.setIn(originalSystemIn)
    }


    @Test
    fun `자동차 이름 입력 받기 함수`() {

        System.setIn(carNameInput1)

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


    @Test
    fun `시도할 횟수 입력 테스트`() {
        //val ui = UserInterface()
        System.setIn(tryNumberInput1)


        val tryNumbers = ui.enterTryNumbers()

        val expected = 5
        val expectedOutput = "시도할 횟수는 몇 회인가요?"

        val consoleOutput = outputStream.toString().trim()


        assertThat(consoleOutput).isEqualTo(expectedOutput)
        assertThat(tryNumbers).isEqualTo(expected)
    }


    @Test
    fun `시도할 횟수 입력 예외 테스트1`() {
        val checker = ExceptionChecker()
        val tryNumber = "-1"
        assertThrows<IllegalArgumentException> {
            checker.checkTryNumber(tryNumber)
        }
    }

    @Test
    fun `시도할 횟수 입력 예외 테스트2`() {
        val checker = ExceptionChecker()
        val tryNumber = ""
        assertThrows<IllegalArgumentException> {
            checker.checkTryNumber(tryNumber)
        }
    }

    @Test
    fun `시도할 횟수 입력 예외 테스트3`() {
        val checker = ExceptionChecker()
        val tryNumber = "a"
        assertThrows<IllegalArgumentException> {
            checker.checkTryNumber(tryNumber)
        }
    }

    @Test
    fun `시도할 횟수 입력 예외 테스트4`() {
        val checker = ExceptionChecker()
        val tryNumber = "0"
        assertThrows<IllegalArgumentException> {
            checker.checkTryNumber(tryNumber)
        }
    }


}