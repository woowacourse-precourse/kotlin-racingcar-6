package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun make_frame(): List<String>{
    val sentence = Console.readLine().split(",")
    for (car in sentence){
        if (car.length > 3 || car.isEmpty()){
            throw IllegalArgumentException()
        }
    }
    return sentence
}

fun move(record:IntArray):IntArray{
    for (i in 0 until record.size){
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            record[i] += 1
        }
    }
    return record
}

fun main() {
    val cars = make_frame()
    val record = IntArray(cars.size){0}
    move(record)
    println(record.joinToString(","))
}
