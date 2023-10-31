package car

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `자동차 이름이 다섯글자보다 클 때 예외를 던진다`() {
        val names = listOf("pobi", "wonny", " jiyeon")
        assertThrows<IllegalArgumentException>("자동차 이름은 5자 이하만 입력 가능합니다.") {
            require(!names.any { it.length > 5 })
        }
    }

    @Test
    fun `이름의 시작 부분에 공백이 입력되었을때 예외발생`() {
        val names = listOf("pobi", "woni", " kite")
        assertThrows<IllegalArgumentException>("이름의 시작 부분에는 공백 입력이 불가능합니다.") {
            require(!names.any { it.startsWith(' ') })
        }
    }

    @Test
    fun `이름의 끝 부분에 공백이 입력되었을때 예외발생`() {
        val names = listOf("pobi", "woni", "kite ")
        assertThrows<IllegalArgumentException>("이름의 끝 부분에는 공백 입력이 불가능합니다.") {
            require(!names.any { it.endsWith(' ') })
        }
    }

    @Test
    fun `자동차의 개수가 2대보다 작을 때 예외를 던진다`() {
        val names = listOf("kite")
        assertThrows<IllegalArgumentException>("최소 2대이상의 자동차 이름이 입력되어야 게임 진행이 가능합니다.") {
            require(names.size >= 2)
        }
    }

    @Test
    fun `이름의 입력이 콤마로 시작할 때 예외를 던진다`() {
        val input = ",pobi,woni,kite"
        assertThrows<IllegalArgumentException>("처음에 콤마가 추가되었습니다. 콤마로 입력을 시작해서는 안됩니다.") {
            require(!input.startsWith(","))
        }
    }

    @Test
    fun `이름의 입력이 콤마로 끝날 때 예외를 던진다`() {
        val input = "pobi,woni,kite,"
        assertThrows<IllegalArgumentException>("콤마로 입력이 끝나서는 안됩니다.") {
            require(!input.endsWith(','))
        }
    }

    @Test
    fun `중복된 이름이 존재할 때 예외를 던진다`() {
        val names = listOf("james", "james", "lea")
        assertThrows<IllegalArgumentException>("중복된 이름이 있으면 안됩니다.") {
            require(names.toSet().size == names.size)
        }
    }

}