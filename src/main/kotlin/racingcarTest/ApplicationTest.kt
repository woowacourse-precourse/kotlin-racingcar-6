package racingcarTest

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.io.TempDir

import racingcar.main

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

import java.io.File
import java.io.PrintStream

class ApplicationTest { // main은 테스트코드를 어떻게 짜죠..?ㅠㅠ

    @TempDir
    lateinit var tempDir: File

    @Test
    fun `main should run the game with valid input`() {
        val inputText = "pobi, woni, jun\n5\n"
        val inputFile = File(tempDir, "input.txt")
        inputFile.writeText(inputText)

        val standardInput = System.`in`
        System.setIn(ByteArrayInputStream(inputText.toByteArray()))

        val outputStreamCaptor = System.out

        try {
            val capturedOutput = ByteArrayOutputStream()
            System.setOut(PrintStream(capturedOutput))

            main()

            val expectedOutput = """
                |경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                |시도할 횟수는 몇 회인가요?
                |
                |실행 결과
                |pobi : -
                |woni : 
                |jun : -
                |
                |pobi : --
                |woni : -
                |jun : --
                |
                |pobi : ---
                |woni : --
                |jun : ---
                |
                |pobi : ----
                |woni : ---
                |jun : ----
                |
                |pobi : -----
                |woni : --
                |jun : -----
                |
                |최종 우승자: pobi, jun
                |""".trimMargin()

            assertThat(capturedOutput.toString().trim()).isEqualTo(expectedOutput.trim())
        } finally {
            System.setIn(standardInput)
            System.setOut(outputStreamCaptor)
        }
    }
}
