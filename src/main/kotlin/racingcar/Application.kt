import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingCar(val name: String) {
    var distance = 0

    fun move() {
        // Randoms의 pickNumberInRange() 메소드를 사용하여 랜덤값을 생성
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }
    // 자동차의 현재 상태 출력하기
    fun printStatus() {
        println("$name : ${"-".repeat(distance)}")
    }
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

    println("\n실행 결과")
    for (i in 0 until counts) {
        for (car in cars) {
            car.move()
            car.printStatus()
        }
        println()
    }
    // 우승자 찾기 (가장 멀리간 자동차 찾기)
    var goalDistance = 0
    for (car in cars) {
        if (car.distance > goalDistance) {
            goalDistance = car.distance
        }
    }
    // 우승자가 2명 이상인 경우
    val winners = mutableListOf<String>()
    for (car in cars) {
        if (car.distance == goalDistance) {
            winners.add(car.name)
        }
    }
    // 최종 결과 출력하기
    println("최종 우승자 : ${winners.joinToString()}")
}
