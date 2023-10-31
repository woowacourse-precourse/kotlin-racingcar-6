package racingcar.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.InputView

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarsTest {
    val inputView = InputView()

    @ParameterizedTest
    @ValueSource(strings = ["pobi, asd, 123"])
    @DisplayName("InputView: splitCarNamesByComma() - Multi")
    fun `여러 이름을 입력 받은 경우) ','로 분류하여 리스트 반환`(inputNames: String) {
        Assertions.assertThat(
            inputView.splitCarNamesByComma(inputNames)
        ).containsExactly("pobi", " asd", " 123")
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["asd", " 123", "pobi ", "  jun", "taeng"])
    @DisplayName("InputView: splitCarNamesByComma() - Single")
    fun `하나의 이름을 입력 받은 경우) 하나를 리스트에 넣고 반환`(inputNames: String) {
        Assertions.assertThat(
            inputView.splitCarNamesByComma(inputNames)
        ).isEqualTo(listOf(inputNames))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1234  ", "  1234", "Pobi12", "123456"])
    @DisplayName("Car(init): checkNameLength()")
    fun `차 이름이 1~5 이내 인지 검증`(inputName: String) {
        val exception = assertThrows<IllegalArgumentException> { // JUnit5 lib : assertThrows
            Car(inputName)
        }
        assertEquals(Car.CAR_NAME_LENGTH_ERROR, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Car!", "Car@2", "My!!!", "!! !!", "! !", "()_+"])
    @DisplayName("Car(init): checkNameLetter()")
    fun `차 이름이 한글, 영문, 숫자로 구성되어 있는지 검증`(inputName: String) {
        assertThatThrownBy { Car(inputName) } // AssertJ lib : assertThatThrownBy
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Car.CAR_NAME_FORMAT_ERROR)
    }

    @ParameterizedTest
    @MethodSource("duplicationTestdataGenerate")
    @DisplayName("Cars(init): fromNames() - Fail Case")
    fun `차 이름이 중복되지 않았는지 검증`(inputName: List<String>) {
        val exception = assertThrows<IllegalArgumentException> {
            Cars.fromNames(inputName)
        }

        assertEquals(Cars.CAR_NAME_DUPLICATE_ERROR, exception.message) // JUnit
        assertThat(Cars.CAR_NAME_DUPLICATE_ERROR).isEqualTo(exception.message) // AssertJ
    }

    @ParameterizedTest
    @MethodSource("CarsInstanceGenerateData")
    @DisplayName("Cars(init): fromNames() - Success Case")
    fun `Cars 객체(List(Car)) 생성한 뒤, size 및 carName 검증`(inputName: List<String>) {
        val cars = assertDoesNotThrow {
            Cars.fromNames(inputName)
        }

        assertThat(cars.carList.size).isEqualTo(inputName.size) // 사이즈 검증

        for ((index, carName) in inputName.withIndex()) {
            val carsInstanceCarName = cars.carList[index].name
            assertThat(carsInstanceCarName).isEqualTo(carName) // carName 검증
        }
    }

    companion object {
        @JvmStatic
        private fun duplicationTestdataGenerate() = listOf(
            listOf("1", "01", "1", "2"),
            listOf("010", "020", "010"),
            listOf("101", "102", "101"),
        )

        @JvmStatic
        private fun CarsInstanceGenerateData() = listOf(
            listOf("1", "2", "1232", "2123"),
            listOf("asd", "125s", "sd21"),
        )
    }
}