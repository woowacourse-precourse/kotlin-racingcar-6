package racingcar.global

enum class InformationMessage(val message: String) {
	INPUT_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ATTEMPT_NUMBER("시도할 횟수는 몇 회인가요?"),
	EXECUTION_RESULT("실행 결과"),
	FINAL_WINNER("최종 우승자 : ")
}