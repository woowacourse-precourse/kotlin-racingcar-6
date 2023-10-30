import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// 경주용 자동차 정보 클래스
class RacingCar(val name: String) {
    var distance = 0

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

// 자동차의 현재 상태 출력하기
fun raceStatus(cars: List<RacingCar>) {
    cars.forEach {
        car -> println("$car.name : ${"-".repeat(car.distance)}")
    }
    println()
}

// 최종 결과 출력하기
fun finalWinner(winners: List<String>) {
    println("최종 우승자 : ${winners.joinToString()}")
}

fun main() {
    // 사용자가 자동차 이름 입력하기 (이름은 쉼표(,) 기준으로 구분)
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputNames = Console.readLine() ?: ""
    val carNames = inputNames.split(",")

    // 자동차 이름 5자 초과하는 경우 예외 발생
    for (name in carNames) {
        if (name.length > 5) {
            println("자동차 이름은 5자 이하만 가능합니다.")
            return
        }
    }
    // 사용자가 경주할 횟수 입력하기
    println("시도할 횟수는 몇 회인가요?")
    val cntInput = Console.readLine() ?: ""
    val counts = cntInput.toIntOrNull()
    if (counts == null) {
        println("정수를 입력해주세요.")
        return
    }
    // 입력받은 자동차 이름으로 Car 객체 리스트 생성
    val cars = mutableListOf<RacingCar>()
    for (name in carNames) {
        cars.add(RacingCar(name))
    }
    val racingGame = RacingGame(cars)

    println("\n실행 결과")
    for (i in 0 until counts) {
        racingGame.race()
        raceStatus(cars)
    }

    // 최종 우승자 출력하기
    val winners = racingGame.racingWinner()
    finalWinner(winners)
}
