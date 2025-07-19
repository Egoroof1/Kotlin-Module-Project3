package notesApp


class Archive (
    var title : String
) {
    private val notesMap: MutableMap<Int, Note> = mutableMapOf()

    fun addNote () {
        println("=== Введите название заметки ===")
        val inputTitle = readlnOrNull() ?: ""
        if (inputTitle.isNotEmpty()){

            while (true) {
                println("=== Введите текст заметки ===")
                val inputDescription = readlnOrNull() ?: ""

                if (inputDescription.isNotEmpty()) {
                    notesMap[notesMap.size + 1] = Note(inputTitle, inputDescription)
                    break
                } else {
                    println("Наполнение не может быть пустым")
                    continue
                }
            }
            println("=== Заметка $inputTitle создана ===")
        } else {
            println("Название не может быть пустым")
            addNote()
        }
    }

    fun getNotes(): Map<Int, Note>{
        return notesMap
    }
}