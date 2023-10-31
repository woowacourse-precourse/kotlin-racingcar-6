import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// 경주용 자동차 정보 클래스
class RacingCar(val name: String) {
    var distance = 0

    // 예외 설정 (자동차 이름 5자 초과인 경우)
    init {
        if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.")
    }

    // 자동차의 전진 조건
    fun move() {
        // 0 ~ 9사이 임의의 값 중에 4이상 이면 전진하기
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }
}

// 자동차 경주 게임 클래스
class RacingGame(val cars: List<RacingCar>) {
    // 게임 진행 메소드
    fun race() {
        cars.forEach { it.move() }
    }

    // 우승자 찾기 (가장 멀리간 자동차 찾기)
    fun racingWinner(): List<String> {
        val goalDistance = cars.maxByOrNull { it.distance }?.distance ?: 0
        return cars.filter { it.distance == goalDistance }.map { it.name }
    }
}

// 메인 함수
fun main() {
    // 사용자는 자동차 이름 입력하기
    val carName = carNames()
    val cars = carName.map { RacingCar(it) }

    // 사용자는 레이싱할 횟수 입력하기
    val laps = lapCounts()

    // 레이싱 시작
    val racingGame = RacingGame(cars)

    // 실행 결과 보여주기
    println("\n실행 결과")
    for (i in 0 until laps) {
        racingGame.race()
        raceStatus(cars)
    }

    // 최종 우승자 출력하기
    val winners = racingGame.racingWinner()
    finalWinner(winners)
}

// 자동차의 현재 상태 출력하기
fun raceStatus(cars: List<RacingCar>) {
    cars.forEach { car ->
        println("${car.name} : ${"-".repeat(car.distance)}")
    }
    println()
}

// 최종 결과 출력하기
fun finalWinner(winners: List<String>) {
    println("최종 우승자 : ${winners.joinToString()}")
}

// 사용자가 입력하는 부분 (자동차가 2대 이상인 경우, 쉼표로 구분)
fun carNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine()?.split(",") ?: throw IllegalArgumentException("잘못 입력하였습니다.")
}

// 사용자가 게임 횟수 지정하기
fun lapCounts(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException("잘못 입력하였습니다.")
}

// JUnit 5와 AssertJ를 이용한 기능 테스트
class RacingGameTest {
    @Test
    fun `자동차 이름이 5자를 초과하면 예외를 발생시킨다`() {
        val longName = "woowacon"
        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            RacingCar(longName)
        }
        assertThat(exception.message).isEqualTo("자동차 이름은 5자 이하여야 합니다.")
    }

    @Test
    fun `자동차 경주에서 우승자를 정확히 찾는다`() {
        val carA = RacingCar("pobi").apply { distance = 8 }
        val carB = RacingCar("woni").apply { distance = 7 }
        val carC = RacingCar("jun").apply { distance = 8 }

        val racingGame = RacingGame(listOf(carA, carB, carC))
        val winners = racingGame.racingWinner()

        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun")
    }
}

