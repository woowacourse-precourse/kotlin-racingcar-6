package racingcar

class ExceptionManager {
    fun nameException( name : List<String>){
        for (index in name){
            if (index.length>5){
                throw IllegalArgumentException("이름을 5자 이하로 입력해주세요")
            }

        }
        if (name.distinct().size != name.size) {
            throw IllegalArgumentException("동일한 이름이 중복되었습니다.")
        }
    }
    fun repeatException(num : String){
        if (num.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자를 입력해주세요.")
        }
    }
}