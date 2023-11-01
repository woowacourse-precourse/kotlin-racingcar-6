package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class RacingGameTest {
    private lateinit var standardOut: PrintStream
    private lateinit var captor: OutputStream

    @BeforeEach
    fun init() {
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    @AfterEach
    fun printOutput() {
        System.setOut(standardOut)
        println(output())
    }

    fun output(): String {
        return captor.toString().trim { it <= ' ' }
    }

    @Test
    fun `inputCarName 정상 입력`() {
        val input = "a,b,c"
        val carList = input.split(",").map { Car(it.trim()) }
        assertThat(inputCarName { input }).isEqualTo(carList)
    }

    @Test
    fun `inputCarName 빈칸 입력 예외 발생`() {
        val input = ""
        assertThrows<IllegalArgumentException> { inputCarName { input } }
    }

    @Test
    fun `inputCarName 5자 이상 입력 예외 발생`() {
        val input = "hello,abc,wrongName"
        assertThrows<IllegalArgumentException> { inputCarName { input } }
    }

    @Test
    fun `inputTryNumber 정상 입력`() {
        val input = "5"
        assertThat(inputTryNumber { input }).isEqualTo(5)
    }

    @Test
    fun `inputTryNumber 빈칸 입력 예외 발생`() {
        val input = ""
        assertThrows<IllegalArgumentException> { inputTryNumber { input } }
    }

    @Test
    fun `inputTryNumber 문자 입력 예외 발생`() {
        val input = "a"
        assertThrows<IllegalArgumentException> { inputTryNumber { input } }
    }

    @Test
    fun `printRacing 결과 출력`() {
        val carList = listOf(Car("a"), Car("b"), Car("c"))
        val tryNumber = 1
        val pickNumberInRange = { _: Int, _: Int -> 4 }
        printRacing(carList, tryNumber, pickNumberInRange)
        for (car in carList) {
            val expectedOutput = "${car.name} : ${"-".repeat(tryNumber)}"
            assertThat(output()).contains(expectedOutput)
        }
    }

    @Test
    fun `raceCar 정상 처리`() {
        val carList = listOf(Car("a"), Car("b"), Car("c"))
        val pickNumberInRange = { _: Int, _: Int -> 4 }
        raceCar(carList, pickNumberInRange)
        for (car in carList) {
            assertThat(car.distanceLength).isEqualTo(1)
        }
    }

    @Test
    fun `driveCar 랜덤 숫자 4이상 정상 처리`() {
        val car = Car("a")
        val randomNumber = 4
        driveCar(car, randomNumber)
        assertThat(car.distanceLength).isEqualTo(1)
    }

    @Test
    fun `driveCar 랜덤 숫자 4미만 정상 처리`() {
        val car = Car("a")
        val randomNumber = 2
        driveCar(car, randomNumber)
        assertThat(car.distanceLength).isEqualTo(0)
    }

    @Test
    fun `printCurrentRace 결과 출력`() {
        val carList = listOf(Car("a"), Car("b"), Car("c"))
        printCurrentRace(carList)
        assertThat(output()).contains("a : ", "b : ", "c :")
    }

    @Test
    fun `decideWinnerNameList 한 명 정상 처리`() {
        val carList = listOf(Car("a"), Car("b"), Car("c"))
        carList[0].drive()
        val expectList = listOf("a")
        assertThat(decideWinnerNameList(carList)).isEqualTo(expectList)
    }

    @Test
    fun `decideWinnerNameList 여러 명 정상 처리`() {
        val carList = listOf(Car("a"), Car("b"), Car("c"))
        carList[0].drive()
        carList[1].drive()
        val expectList = listOf("a", "b")
        assertThat(decideWinnerNameList(carList)).isEqualTo(expectList)
    }

    @Test
    fun `printWinner 한 명 결과 출력`() {
        val winnerList = listOf("a")
        printWinner(winnerList)
        val expectedOutput = "최종 우승자 : a"
        assertThat(output()).contains(expectedOutput)
    }

    @Test
    fun `printWinner 여러 명 결과 출력`() {
        val winnerList = listOf("a", "b")
        printWinner(winnerList)
        val expectedOutput = "최종 우승자 : a, b"
        assertThat(output()).contains(expectedOutput)
    }
}