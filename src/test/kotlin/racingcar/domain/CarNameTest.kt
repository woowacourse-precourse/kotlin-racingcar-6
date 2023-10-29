package racingcar.domain

import org.junit.jupiter.api.*
import racingcar.CarNameConstants
import org.assertj.core.api.Assertions.assertThat


class CarNameTest{

    private lateinit var carName: CarName

    @BeforeEach
    fun setUp() {
        carName = CarName()
    }

    @Test
    fun `입력값이 없을 때`() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> {
            carName.validateInput(input)
        }
        Assertions.assertEquals(CarNameConstants.INPUT_IS_EMPTY, exception.message)
    }

    @Test
    fun `자동차 이름 1개만 입력 했을 때`() {
        val input = "pobi"
        val exception = assertThrows<IllegalArgumentException> {
            carName.validateInput(input)
        }
        Assertions.assertEquals(CarNameConstants.INPUT_ONLY_ONE, exception.message)
    }

    @Test
    fun `자동차 이름 중 빈값이 있을 때`() {
        val input = "pobi,,jason"
        val exception = assertThrows<IllegalArgumentException> {
            carName.validateInput(input)
        }
        Assertions.assertEquals(CarNameConstants.CAR_NAME_HAS_EMPTY, exception.message)
    }

    @Test
    fun `자동차 이름 중 공백이 있을 때`() {
        val input = "pobi, ,jason"
        val exception = assertThrows<IllegalArgumentException> {
            carName.validateInput(input)
        }
        Assertions.assertEquals(CarNameConstants.CAR_NAME_HAS_BLANK, exception.message)
    }

    @Test
    fun `자동차 이름 중 5자가 초과된 이름이 있을 때`() {
        val input = "pobi,jason,woowacourse"
        val exception = assertThrows<IllegalArgumentException> {
            carName.validateInput(input)
        }
        Assertions.assertEquals(CarNameConstants.CAR_NAME_HAS_OVER_5_CHARS, exception.message)
    }

    @Test
    fun `자동차 이름 중 공백이 포함되면서 5자가 초과된 이름이 있을 때`() {
        val input = "po  bi,jason,woowa"
        val exception = assertThrows<IllegalArgumentException> {
            carName.validateInput(input)
        }
        Assertions.assertEquals(CarNameConstants.CAR_NAME_HAS_OVER_5_CHARS, exception.message)
    }

    @Test
    fun `자동차 이름 중 중복된 이름이 있을 때`() {
        val input = "pobi,jason,woowa,woowa"
        val exception = assertThrows<IllegalArgumentException> {
            carName.validateInput(input)
        }
        Assertions.assertEquals(CarNameConstants.CAR_NAME_HAS_DUPLICATE, exception.message)
    }

    @Test
    fun `자동차 이름 2개 이상 입력 했을 때`() {
        val input = "pobi,jason,woowa"
        assertDoesNotThrow {
            carName.validateInput(input)
        }
    }

    @Test
    fun `자동차 이름에 한글, 영어, 숫자가 포함될 때`() {
        val input = "포비,j이슨,woo아,12345,일2sam"
        assertDoesNotThrow {
            carName.validateInput(input)
        }
    }

    @Test
    fun `자동차 이름에 특수문자가 포함 될 때`() {
        val input = "p@b!,jas@n,w@@wa"
        assertDoesNotThrow {
            carName.validateInput(input)
        }
    }

    @Test
    fun `자동차 이름에 공백이 포함된 이름이 있을 때`() {
        val input = "po bi,jason,woowa"
        assertDoesNotThrow {
            carName.validateInput(input)
        }
    }
}