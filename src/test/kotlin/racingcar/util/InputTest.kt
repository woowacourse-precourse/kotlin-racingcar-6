package racingcar.util

import camp.nextstep.edu.missionutils.Console
import racingcar.presentation.Input
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

class InputTest {

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
        Console.close()
    }

    private fun output(): String = captor.toString().trim()
    private fun command(vararg args: String) {
        val buf = args.joinToString("\n").toByteArray()
        System.setIn(ByteArrayInputStream(buf))
    }

    @Test
    fun `문자열 파싱 테스트 정상`() {
        command("pobi, sss")
        val playerList = Input.getPlayerList()
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        assertThat(playerList).containsExactly("pobi", "sss")
    }

    @Test
    fun `문자열 파싱 테스트 공백 없음`() {
        command("pobi,sss")
        val playerList = Input.getPlayerList()
        assertThat(playerList).containsExactly("pobi", "sss")
    }

    @Test
    fun `문자열 파싱 테스트 공백 있음`() {
        command("  pobi   ,  sss   ")
        val playerList = Input.getPlayerList()
        assertThat(playerList).containsExactly("pobi", "sss")
    }

    @Test
    fun `문자열 파싱 테스트 빈칸`() {
        command("pobi, ,sss")
        val playerList = Input.getPlayerList()
        assertThat(playerList).containsExactly("pobi", "sss")
    }

    @Test
    fun `문자열 파싱 테스트 5자 이상`() {
        assertThrows<IllegalArgumentException> {
            command("pobiㄴㅇㄴㅇ, ,sss")
            Input.getPlayerList()
        }
    }

    @Test
    fun `문자열 파싱 테스트 공백만`() {
        assertThrows<IllegalArgumentException> {
            command(" , , ")
            Input.getPlayerList()
        }
    }
}