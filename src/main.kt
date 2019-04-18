var groupIndex: Int = 0

fun main() {
    val ToDoTaskManager = ToDoTaskManager()

//////////////////////БЛОК ЗАПОЛНЕНИЯ ДАННЫМИ ДЛЯ ТЕСТА begin///////////////////////////////////////////
    ToDoTaskManager.addNewTaskList("Разработка под Android")
    ToDoTaskManager.addNewTaskList("Автомобиль")
    ToDoTaskManager.addNewTaskList("Поход на Алтай")
    ToDoTaskManager.addNewTaskList("Зохватить весь Мир)")

    ToDoTaskManager.addNewTaskItemInTaskList(1,"Пойти на FocusStart",0)
    ToDoTaskManager.addNewTaskItemInTaskList(1,"Освоить Kotlin",1)
    ToDoTaskManager.changeTaskStatus(1,1)
    ToDoTaskManager.addNewTaskItemInTaskList(2,"Заменить масло в ДВС",2)
    ToDoTaskManager.addNewTaskItemInTaskList(2,"Заменить масло в АККП",3)
    ToDoTaskManager.addNewTaskItemInTaskList(2,"Починить тормоза!",0)
    ToDoTaskManager.addNewTaskItemInTaskList(2,"Заменить свечи",4)
    ToDoTaskManager.addNewTaskItemInTaskList(2,"Помыть машину",5)

    //   println(ToDoTaskManager.showTaskItemsInTaskList(2))
    //   println(ToDoTaskManager.changeTaskStatus(2,6))
    //   println(ToDoTaskManager.showTaskItemsInTaskList(2))
//////////////////////БЛОК ЗАПОЛНЕНИЯ ДАННЫМИ ДЛЯ ТЕСТА end///////////////////////////////////////////



    println("Список групп задач:")
    println(ToDoTaskManager.showTaskList())
    println("Для получения списка команд наберите \"?\"")





    var readString: String
   while (true){
       readString = readLine()!!

       if ("showList" in readString){
           println("Список групп задач:")
           println(ToDoTaskManager.showTaskList())
       }

       else if ("addList" in readString){
           val addName = readString.substringAfter(' ')
           println(ToDoTaskManager.addNewTaskList(addName))
       }

       else if ("showGroup" in readString){
           try {
               groupIndex = readString.substringAfter(' ').toInt()
               println(ToDoTaskManager.showTaskItemsInTaskList(groupIndex))
           }
           catch (e: NumberFormatException){
               println("Невозможно выполнить команду. Возможно команда введена некорректно")
           }
           catch (e: Exception){
               println("Ошибка выполнения. Что-то пошло не так")
           }
       }

       else if ("addTask" in readString){
           println("Введите важность задачи (от 0 до 10)")


           val addName = readString.substringAfter(' ')
           try {
               val priority = readLine()!!.toByte()
               val result = ToDoTaskManager.addNewTaskItemInTaskList(groupIndex, addName, priority)
               println(result)
           }
           catch (e: NumberFormatException){
               println("Невозможно выполнить команду. Возможно команда введена некорректно")
           }
           catch (e: Exception){
               println("Ошибка выполнения. Что-то пошло не так")
           }
       }

       else if ("changeStatus" in readString){
           try {
               val taskIndex = readString.substringAfter(' ').toInt()
               println(ToDoTaskManager.changeTaskStatus(groupIndex,taskIndex))
           }
           catch (e: NumberFormatException){
               println("Невозможно выполнить команду. Возможно команда введена некорректно")
           }
           catch (e: Exception){
               println("Ошибка выполнения. Что-то пошло не так")
           }
       }




       else if (readString=="?") println("""showList - показать список групп
addList [название группы] - добавить группу задач
addTask [название задачи] - добавить задачу в последнюю просмотренную группу
showGroup [номер группы задач] - просмотр содержимого группы задач
changeStatus [номер задачи] - изменить статус выполнения задачи из последней просмотренной группы
exit - выход из программы""")
       else if (readString=="exit") break
       else println("Вы пытаетесь выполнить неведомую команду. Для получения списка команд наберите \"?\"")


   }


}


