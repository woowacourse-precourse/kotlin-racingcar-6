package racingcar.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차의 random 정수를 생성하기 위한 object RandomNumberGenerator에서")
class RandomNumberGeneratorTest {

    @Test
    @DisplayName("생성한 랜덤 정수는 0보다 크거나 같고 9보다 작거나 같다")
    fun randomNumberInCorrectRange() {
        //given
        //when
        //thenf
        Assertions.assertThat(RandomNumberGenerator.generateRandomNumber()).isLessThan(10).isGreaterThan(-1)
    }
}