package racingcar.view

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.util.NoSuchElementException

class InputViewTest {

    private fun command(vararg args: String) {
        val buf = java.lang.String.join("\n", *args).toByteArray()
        System.setIn(ByteArrayInputStream(buf))
    }

    @Test
    fun `inputCarNameList 정상 입력`() {
        try {
            val inputNum = "1,2,3"
            val view = InputView()

            command(inputNum)
            val outputNum = view.inputCarNameList()
            assertThat(outputNum).isEqualTo(inputNum.split(','))
        } finally {
            Console.close()
        }
    }

    @Test
    fun `inputCarNameList 비정상 입력`() {
        try {
            val inputString = ""
            val view = InputView()
            assertThrows<NoSuchElementException> {
                command(inputString)
                view.inputCarNameList()
            }
        } finally {
            Console.close()
        }
    }

    @Test
    fun `inputPlayCount 정상 입력`() {
        try {
            val inputNum = 123
            val view = InputView()

            command(inputNum.toString())
            val outputNum = view.inputPlayCount()
            assertThat(outputNum).isEqualTo(inputNum)
        } finally {
            Console.close()
        }
    }

    @Test
    fun `inputPlayCount 비정상 입력`() {
        try {
            val inputNumList = listOf("aaa", "", "123asd1")
            val view = InputView()
            inputNumList.forEach { inputNum: String ->
                assertThrows<Exception> {
                    command(inputNum)
                    view.inputPlayCount()
                }
            }
        } finally {
            Console.close()
        }
    }
}