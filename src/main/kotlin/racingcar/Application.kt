import kotlin.random.Random

// 자동차를 나타내는 클래스
class Car(val name: String) {
    var distance = 0

    // 자동차가 전진하는 조건을 체크하고 전진할 경우 distance를 1 증가시킨다.
    fun move() {
        if (Random.nextInt(10) >= 4) {
            distance++
        }
    }

    // 자동차의 현재 상태를 출력하기 위한 함수
    fun printStatus() {
        println("$name : ${"-".repeat(distance)}")
    }
}

fun main() {
    // 사용자로부터 자동차 이름을 입력받는다.
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputNames = readLine() ?: ""
    val carNames = inputNames.split(",")

    // 자동차 이름이 5자를 초과하는 경우 예외를 발생시킨다.
    for (name in carNames) {
        if (name.length > 5) {
            println("자동차 이름은 5자 이하만 가능합니다.")
            return
        }
    }

    // 사용자로부터 경주할 횟수를 입력받는다.
    println("시도할 횟수는 몇 회인가요?")
    val trialInput = readLine() ?: ""
    val trials = trialInput.toIntOrNull()
    if (trials == null) {
        println("정수를 입력해주세요.")
        return
    }

    // 입력받은 자동차 이름으로 Car 객체 리스트를 생성한다.
    val cars = mutableListOf<Car>()
    for (name in carNames) {
        cars.add(Car(name))
    }

    println("\n실행 결과")
    for (i in 0 until trials) {
        for (car in cars) {
            car.move()
            car.printStatus()
        }
        println()
    }

    // 우승자를 찾기 위한 로직
    var maxDistance = 0
    for (car in cars) {
        if (car.distance > maxDistance) {
            maxDistance = car.distance
        }
    }

    val winners = mutableListOf<String>()
    for (car in cars) {
        if (car.distance == maxDistance) {
            winners.add(car.name)
        }
    }

    println("최종 우승자 : ${winners.joinToString()}")
}
