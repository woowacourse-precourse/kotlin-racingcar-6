package racingcar.game

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

internal class PrintUtilTest {

    private lateinit var standardOut: PrintStream
    private lateinit var captor: OutputStream

    @Test
    fun `printStartMessage 메서드 출력 테스팅`() {
    }

    @Test
    fun `printAskAttempts 메서드 출력 테스팅`() {
    }

    @Test
    fun `printExecutionResult 메서드 출력 테스팅`() {
    }

    @Test
    fun `printRacingCars 메서드 출력 테스팅`() {
    }

    @Test
    fun `printWinnerList 메서드 출력 테스팅`() {
    }

    @BeforeEach
    private fun init() {
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    @AfterEach
    private fun printOutput() {
        System.setOut(standardOut)
        println(output())
    }

    private fun output(): String {
        return captor.toString().trim { it <= ' ' }
    }
}