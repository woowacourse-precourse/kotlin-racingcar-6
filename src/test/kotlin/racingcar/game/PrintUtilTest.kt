package racingcar.game

import org.assertj.core.api.Assertions.assertThat
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
        // given
        PrintUtil.printStartMessage()
        // when
        val expectedStartMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        // then
        assertThat(output()).contains(expectedStartMessage)
    }

    @Test
    fun `printAskAttempts 메서드 출력 테스팅`() {
        // given
        PrintUtil.printAskAttempts()
        // when
        val expectedStartMessage = "시도할 횟수는 몇 회인가요?"
        // then
        assertThat(output()).contains(expectedStartMessage)
    }

    @Test
    fun `printExecutionResult 메서드 출력 테스팅`() {
        // given
        PrintUtil.printExecutionResult()
        // when
        val expectedStartMessage = "실행 결과"
        // then
        assertThat(output()).contains(expectedStartMessage)
    }

    @Test
    fun `printRacingCars 메서드 출력 테스팅`() {

    }

    @Test
    fun `printWinnerList 메서드 출력 테스팅 - 우승자가 한명일 때`() {
        // given
        PrintUtil.printWinnerList(mutableListOf(Car("bamin")))
        // when
        val expectedWinnerMessageSole = "최종 우승자 : bamin"
        // then
        assertThat(output()).contains(expectedWinnerMessageSole)
    }

    @Test
    fun `printWinnerList 메서드 출력 테스팅 - 우승자가 여러명일 때`() {
        // given
        PrintUtil.printWinnerList(mutableListOf(Car("bamin"), Car("pobi"), Car("woni")))
        // when
        val expectedWinnerMessageMultiple = "최종 우승자 : bamin, pobi, woni"
        // then
        assertThat(output()).contains(expectedWinnerMessageMultiple)
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