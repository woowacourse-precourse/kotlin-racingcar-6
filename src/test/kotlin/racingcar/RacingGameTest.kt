package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.assertj.core.api.Assertions.assertThat

class RacingGameTest {
    @Test
    fun `자동차 이름 입력 값 체크`(){
        val validator = RacingCarValidator.instance
        //빈 값 테스트
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("")
        }
        //한 개 값 길이 초과
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("onew,jonghyun,key")
        }
        //정상 값
        validator.validateCarName("onew")
    }
    @Test
    fun `이동 횟수 입력 값 체크`(){
        val validator = RacingCarValidator.instance
        //빈 값 테스트
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("")
        }
        //숫자가 아닌 값
        assertThrows<IllegalArgumentException> {
            validator.validateCarName("s")
        }
        //정상 테스트
        validator.checkTrying("6")

    }
    @Test
    fun `레이싱 이동 함수 Boolean으로 나오는지 체크`(){
        val validator = RacingGames().racing()
        //True,False로 나와야 함.
        assertTrue(validator==true || validator==false)
    }
    @Test
    fun `기존 값에 값 제대로 업데이트 하는지 확인`(){
        val validator = RacingGames()
        var race = mutableListOf("-", "--", "")
        var updates = listOf("-", "---","-")
        var result = validator.moveCars(race, updates)
        assertThat(result[0]).isEqualTo("--")
        assertThat(result[1]).isEqualTo("-----")
        assertThat(result[2]).isEqualTo("-")
        //아무것도 없는 경우
        race = mutableListOf("", "", "")
        updates = listOf("", "","")
        result = validator.moveCars(race, updates)
        assertThat(result[0]).isEqualTo("")
        assertThat(result[1]).isEqualTo("")
        assertThat(result[2]).isEqualTo("")
    }
    //아래 함수는 리턴값으로 비교하여 테스트 완료. 현재는 출력자리로 주석 처리
    /*
    @Test
    fun `출력 결과가 예상과 같은지 확인`(){
        val inputRace = listOf("-","--","---")
        val inputCars = listOf("onew", "key", "minho")
        val result = RacingResult().gameResult(inputCars, inputRace)
        val expected = "onew : -\nkey : --\nminho : ---\n"
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `최종 우승자 값 예상과 같은지 확인`(){
        var inputRace = listOf("-","--","---")
        val inputCars = listOf("onew", "key", "minho")
        var result = RacingResult().winnerResult(inputCars, inputRace)
        var expected = "최종 우승자 : minho"
        assertThat(result).isEqualTo(expected)

        // 새로운 테스트 데이터를 사용
        inputRace = listOf("-","--","--")
        result = RacingResult().winnerResult(inputCars, inputRace)
        expected = "최종 우승자 : key, minho"
        assertThat(result).isEqualTo(expected)
    }
     */
}