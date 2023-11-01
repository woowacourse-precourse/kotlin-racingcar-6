package racingcar.command

class CommandInvoker {
    companion object {
        private val commands = mutableListOf<Command>()

        fun addCommand(command: Command) {
            commands.add(command)
        }

        fun executeCommands() {
            for (command in commands) {
                command.execute()
            }
        }

        fun clearCommands() {
            commands.clear()
        }
    }
}