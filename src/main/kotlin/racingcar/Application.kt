package racingcar

import camp.nextstep.edu.missionutils.Console
fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val nameInput = Console.readLine()
    val carList = nameInput.split(",");

    val carlistSize = carList.size
    for( i in 0..carlistSize-1){
        if(carList[i].length>5 || carList[i].isNullOrBlank()){
            throw IllegalArgumentException("입력 오류")
        }
    }

    val carInfo = Array<Car?>(carlistSize){null}
    for(i in 0..carlistSize-1){
        carInfo[i] = Car(carList[i])
    }
    var playTime = 0
    println("시도할 횟수는 몇 회인가요?")
    try {
        playTime = readLine()?.toInt() ?: throw NumberFormatException("유효하지 않은 입력")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("수로 변환 할 수 없습니다.")
    }

    println("\n실행 결과")
    for(i in 1..playTime){
        playGame(carInfo)
    }

    val winners = findWinner(carInfo)
    val dap = winners.joinToString(", ")
    println("최종 우승자 : $dap")
}

fun playGame(car: Array<Car?>){
    for(i in 0..car.size-1){
        car[i]?.getRandomNum()
        car[i]?.isGo()
        car[i]?.curLocation()
    }
    println("")
}

fun findWinner(car: Array<Car?>): List<String>{
    val winner = car.maxByOrNull{ it!!.getMoveCnt()}
    val longDistance = winner?.getMoveCnt()
    val winners = car.filter{it!!.getMoveCnt() == longDistance}.map{it!!.name}
    return winners
}
