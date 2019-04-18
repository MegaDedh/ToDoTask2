

internal data class TaskItem constructor(val taskText: String,
                                         val taskPriority: Byte) {

    var taskItemText: String = taskText
    var taskItemPriority: Byte = taskPriority

 //set и get по умолчанию
  //      get() = field
   //     get() = this.taskText


    private var _isDone: Boolean = false
    var isDone: Boolean
        get() = _isDone
        set(value) {
            _isDone = value
        }

}