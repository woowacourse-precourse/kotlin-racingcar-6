package racingcar.domain

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import racingcar.data.Car
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class IOHandlerTest {

    private val standardOut = System.out
    private lateinit var mockedValidator: Validator
    private lateinit var ioHandler: IOHandler

    @BeforeEach
    fun setUp() {
        mockedValidator = mock(Validator::class.java)
        ioHandler = IOHandler(mockedValidator)
    }

    @AfterEach
    fun tearDown() {
        Console.close()
        System.setOut(standardOut)
    }

    @Test
    fun `2칸 전진한 A, 0칸 전진한 B, 3칸 전진한 C의 현재 위치를 보여준다`() {
        // given
        val a = Car("A")
        repeat(2) {
            a.move()
        }
        val b = Car("B")
        val c = Car("C")
        repeat(3) {
            c.move()
        }
        val candidates = listOf(a, b, c)
        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showLocation(candidates)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = """
            A : --
            B : 
            C : ---
            
        """.trimIndent()
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `0칸 전진한 A, 0칸 전진한 B, 0칸 전진한 C의 현재 위치를 보여준다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        val c = Car("C")
        val candidates = listOf(a, b, c)
        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showLocation(candidates)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = """
            A : 
            B : 
            C : 
            
        """.trimIndent()
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `우승자 A를 보여준다`() {
        // given
        val a = Car("A")
        val winner = listOf(a)

        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showWinner(winner)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = "최종 우승자 : A"
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `우승자 A, B를 보여준다`() {
        // given
        val a = Car("A")
        val b = Car("B")
        val winner = listOf(a, b)

        val outputStream = ByteArrayOutputStream()
        setOutput(outputStream)

        // when
        ioHandler.showWinner(winner)
        val actual = outputStream.toString().replace("\r\n", "\n")

        // then
        val expected = "최종 우승자 : A, B"
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `ppoBi,영수,철수를 자동차 이름으로 입력하면 ppoBi와 영수와 철수로 된 list를 반환한다`() {
        // given
        val names = "ppoBi,영수,철수"
        setInput(names)
        Mockito.`when`(mockedValidator.checkCarName("ppoBi")).thenReturn(true)
        Mockito.`when`(mockedValidator.checkCarName("영수")).thenReturn(true)
        Mockito.`when`(mockedValidator.checkCarName("철수")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf("ppoBi", "영수", "철수")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `가"나"다를 자동차 이름으로 입력하면 가"나"다로 된 list를 반환한다`() {
        // given
        val name = "가\"나\"다"
        setInput(name)
        Mockito.`when`(mockedValidator.checkCarName("가\"나\"다")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()


        // then
        val expected = listOf("""가"나"다""")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `line break 문자열을 포함한 자동차 이름을 입력하면 line break이 포함된 list를 반환한다`() {
        // given
        val name = "이\\n름, 정상이름"
        setInput(name)
        Mockito.`when`(mockedValidator.checkCarName("이\\n름")).thenReturn(true)
        Mockito.`when`(mockedValidator.checkCarName(" 정상이름")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf("이\\n름", " 정상이름")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `빈 문자열을 자동차 이름으로 입력하면 IllegalArgumentException이 발생한다`() {
        // given
        val name = "\n"
        setInput(name)
        Mockito.`when`(mockedValidator.checkCarName("")).thenReturn(false)


        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getCarNames()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.NAME_LENGTH_IS_NOT_MATCHED
        Assertions.assertThat(actual).isInstanceOf(expectedClass)
        Assertions.assertThat(actual).hasMessageContaining(expectedErrorMessage)

    }

    @Test
    fun `"  "을 자동차 이름으로 입력하면 "  "를 리턴한다`() {
        // given
        val name = "  "
        setInput(name)
        Mockito.`when`(mockedValidator.checkCarName("  ")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf("  ")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `"김 치"를 자동차 이름으로 입력하면 "김 치"를 리턴한다`() {
        // given
        val name = "김 치"
        setInput(name)
        Mockito.`when`(mockedValidator.checkCarName("김 치")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf("김 치")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `"김 치 "를 자동차 이름으로 입력하면 "김 치 "를 리턴한다`() {
        // given
        val name = "김 치 "
        setInput(name)
        Mockito.`when`(mockedValidator.checkCarName("김 치 ")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf("김 치 ")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `" ,   ,  "를 자동차 이름으로 입력하면 " ", "   ","  "를 리턴한다`() {
        // given
        val name = " ,   ,  "
        setInput(name)
        Mockito.`when`(mockedValidator.checkCarName(" ")).thenReturn(true)
        Mockito.`when`(mockedValidator.checkCarName("   ")).thenReturn(true)
        Mockito.`when`(mockedValidator.checkCarName("  ")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf(" ", "   ", "  ")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `",  , "를 자동차 이름으로 입력하면 IllegalArgumentException이 발생한다`() {
        // given
        val names = ",  , "
        setInput(names)
        Mockito.`when`(mockedValidator.checkCarName("")).thenReturn(false)
        Mockito.`when`(mockedValidator.checkCarName("  ")).thenReturn(true)
        Mockito.`when`(mockedValidator.checkCarName(" ")).thenReturn(true)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getCarNames()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.NAME_LENGTH_IS_NOT_MATCHED
        Assertions.assertThat(actual).isInstanceOf(expectedClass)
        Assertions.assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `중복된 이름을 입력할 수 있다`() {
        // given
        val names = "아우디, 아우지,아우디"
        setInput(names)
        Mockito.`when`(mockedValidator.checkCarName("아우디")).thenReturn(true)
        Mockito.`when`(mockedValidator.checkCarName(" 아우지")).thenReturn(true)

        // when
        val actual = ioHandler.getCarNames()

        // then
        val expected = listOf("아우디", " 아우지", "아우디")
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `이동 횟수로 5를 입력 받으면 5를 리턴한다`() {
        // given
        val input = "5"
        setInput(input)
        Mockito.`when`(mockedValidator.checkMoveCount(5)).thenReturn(true)

        // when
        val actual = ioHandler.getMoveCount()

        // then
        val expected = 5
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `이동 횟수로 "열 번"을 입력 받으면 예외를 발생시킨다`() {
        // given
        val input = "열 번"
        setInput(input)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getMoveCount()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.INPUT_IS_NOT_NUM
        Assertions.assertThat(actual).isInstanceOf(expectedClass)
        Assertions.assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `이동 횟수로 "12삼4"를 입력 받으면 예외를 발생시킨다`() {
        // given
        val input = "12삼4"
        setInput(input)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getMoveCount()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.INPUT_IS_NOT_NUM
        Assertions.assertThat(actual).isInstanceOf(expectedClass)
        Assertions.assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `이동 횟수로 "-1"을 입력 받으면 예외를 발생시킨다`() {
        // given
        val input = "-1"
        setInput(input)
        Mockito.`when`(mockedValidator.checkMoveCount(-1)).thenReturn(false)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            ioHandler.getMoveCount()
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedErrorMessage = IOHandler.NOT_ALLOWED_COUNT
        Assertions.assertThat(actual).isInstanceOf(expectedClass)
        Assertions.assertThat(actual).hasMessageContaining(expectedErrorMessage)
    }

    @Test
    fun `이동 횟수로 "0"을 입력 받으면 0을 리턴한다`() {
        // given
        val input = "0"
        setInput(input)
        Mockito.`when`(mockedValidator.checkMoveCount(0)).thenReturn(true)

        // when
        val actual = ioHandler.getMoveCount()

        // then
        val expected = 0
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `이동 횟수로 "1,000,000"을 입력 받으면 1,000,000을 리턴한다`() {
        // given
        val input = "1000000"
        setInput(input)
        Mockito.`when`(mockedValidator.checkMoveCount(1_000_000)).thenReturn(true)

        // when
        val actual = ioHandler.getMoveCount()

        // then
        val expected = 1_000_000
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    private fun setInput(input: String) {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
    }

    private fun setOutput(output: ByteArrayOutputStream) {
        System.setOut(PrintStream(output))
    }
}