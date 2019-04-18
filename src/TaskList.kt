

internal data class TaskList constructor(val taskName: String) {
    private val taskTitle: String = taskName
    //  get() = field
    //  val strvarib : String

    private val arrayOfTaskItems: ArrayList<TaskItem> = arrayListOf()
    //get() = field


    fun addTaskItem(taskText: String, taskPriority: Byte): String? {

        arrayOfTaskItems.add(TaskItem(taskText, taskPriority))
        return "Задача \"$taskText\" добавлена"
    }

  //  fun getTaskItemList() = arrayOfTaskItems


    fun getTaskItemsInTaskList(): String? {

        var tmpString = "Задачи из списка $taskTitle:\n"
        var i = 0

        if (arrayOfTaskItems.isEmpty()){
            tmpString = "${tmpString}В списке ещё не создано ни одной задачи"
            return tmpString
        }

        arrayOfTaskItems.forEach() {
            i++
            val isDone : Char
            if (it.isDone){
                isDone='V'
            }
            else{
                isDone='X'
            }
            tmpString = "$tmpString[$i] ${it.taskItemText}; Важность (${it.taskItemPriority}); Выполнена ($isDone)\n"
        }
        tmpString = tmpString.substring(0, tmpString.length - 1)
        return tmpString
    }

    fun setTaskIsDone(index: Int): String? {
        try {
            arrayOfTaskItems.get(index).isDone = !arrayOfTaskItems.get(index).isDone
            return "Статус задачи успешно изменён"
        }
        catch (e: IndexOutOfBoundsException){
            return "Ошибка изменения статуса. Задача с таким номером отсутствует"
        }
        catch (e: Exception){
            return "Ошибка выполнения. Что-то пошло не так"
        }

    }

}
