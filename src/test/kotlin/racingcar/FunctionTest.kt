package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class FunctionTest : NsTest() {
    private val originalOut = System.out
    private lateinit var output: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
        output.close()
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }

    @Test
    fun `자동차 전진 결정 함수`() {
        val car = Car("test")

        car.generateRanNum()
        Assertions.assertThat(car.getPosition()).isGreaterThanOrEqualTo(0)
    }

    @Test
    fun `position이 0일 때 자동차 이름 출력 함수`() {
        val car = Car("Car1")
        car.printPosition()

        val expectedOutput = "Car1 : \n"
        org.junit.jupiter.api.Assertions.assertEquals(expectedOutput, output.toString())
    }

    @Test
    fun `position이 0이 아닐 때 자동차 이름 출력 함수`() {
        val car = Car("Car2")
        car.increasePosition()
        car.printPosition()

        val expectedOutput = "Car2 : -\n"
        org.junit.jupiter.api.Assertions.assertEquals(expectedOutput, output.toString())
    }

    @Test
    fun `우승자가 한 명이 아닐 때 우승자 출력 함수`() {
        val car1 = Car("Car1")
        val car2 = Car("Car2")
        val car3 = Car("Car3")

        car1.increasePosition()
        car2.increasePosition()
        car3.increasePosition()

        val carGame = CarGame()
        carGame.cars.add(car1)
        carGame.cars.add(car2)
        carGame.cars.add(car3)

        carGame.winner()

        val expectedOutput = "최종 우승자 : Car1, Car2, Car3\n"
        org.junit.jupiter.api.Assertions.assertEquals(expectedOutput, output.toString())
    }

    @Test
    fun `우승자가 한 명일 때 우승자 출력 함수`() {
        val car1 = Car("Car1")
        val car2 = Car("Car2")
        val car3 = Car("Car3")

        car1.increasePosition()
        car2.increasePosition()
        car3.increasePosition()
        car1.increasePosition()

        val carGame = CarGame()
        carGame.cars.add(car1)
        carGame.cars.add(car2)
        carGame.cars.add(car3)

        carGame.winner()

        val expectedOutput = "최종 우승자 : Car1\n"
        org.junit.jupiter.api.Assertions.assertEquals(expectedOutput, output.toString())
    }
}