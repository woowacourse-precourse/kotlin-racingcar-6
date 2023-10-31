package racingcar.domain

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.assertThat
import race.PrintResult

class PrintResultTest {

    @Test
    fun testPrintMessage() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val printResult = PrintResult()
        val message = "Test Message"
        printResult.printMessage(message)

        val printedMessage = outputStream.toString().trim()
        System.setOut(System.out)
        assertThat(message).isEqualTo(printedMessage)
    }
}