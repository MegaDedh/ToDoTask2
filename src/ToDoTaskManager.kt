
internal class ToDoTaskManager {

    private val arrayOfTaskList: ArrayList<TaskList> = arrayListOf()

    fun addNewTaskList(nameTaskList: String): String{
        arrayOfTaskList.add(TaskList(nameTaskList))
        return "Группа задач \"$nameTaskList\" добавлена"
    }

    fun showTaskList(): String? {

        var tmpString = ""
        var i = 0
        arrayOfTaskList.forEach() {
            i++
            tmpString = tmpString + "["+i+"] " + it.taskName + "\n"
        }
        tmpString = tmpString.substring(0, tmpString.length - 1)
        return tmpString
    }

    fun addNewTaskItemInTaskList(index: Int, text: String, priority: Byte): String? {
        if (priority in 0..10) {


            try {
                return arrayOfTaskList.get(index - 1).addTaskItem(text, priority)
            } catch (e: IndexOutOfBoundsException) {
                return "Список задач с таким номером отсутствует. Для проверки используйте showGroup"
            } catch (e: Exception) {
                return "Ошибка выполнения. Что-то пошло не так"
            }
        }
        else
            return "Неверно введён приоритет. Значение должно быть в диапазоне [0-10]"
    }

    fun showTaskItemsInTaskList(index: Int): String? {
      try {
            return this.arrayOfTaskList.get(index-1).getTaskItemsInTaskList()
        }
        catch (e: IndexOutOfBoundsException){
            return "Спискок задач с таким номером отсутствует"
        }
        catch (e: Exception){
            return "Ошибка выполнения. Что-то пошло не так"
        }
    }


    fun changeTaskStatus(indexTaskList: Int, indexTaskItem: Int): String? {
        try {
            return this.arrayOfTaskList.get(indexTaskList-1).setTaskIsDone(indexTaskItem-1)
        }
        catch (e: IndexOutOfBoundsException){
            return "Задача либо группа задач с таким номером отсутствует. Для проверки используйте showGroup"
        }
        catch (e: Exception){
            return "Ошибка выполнения. Что-то пошло не так"
        }
    }


}