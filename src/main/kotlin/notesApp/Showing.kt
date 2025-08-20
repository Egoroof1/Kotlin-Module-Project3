package notesApp

class Showing {
    private val archivesMap: MutableMap<Int, Archive> = mutableMapOf()

    private fun putArchive () {
        while (true){
            println("=== Введите название архива ===")
            val inputTitle = readlnOrNull() ?: ""


            if (isNotDuplicate(inputTitle)) {
                if (inputTitle.isNotEmpty()) {
                    archivesMap[archivesMap.size + 1] = Archive(inputTitle)
                    println("=== Архив $inputTitle создан ===")
                    break
                } else {
                    println("Название не может быть пустым")
                    continue
                }
            }
        }
    }

    fun isNotDuplicate (str: String): Boolean{
        for (i in archivesMap){
            if (i.value.title == str) {
                println("Архив с таким именем уже существует")
                return false
            }
        }
        return true
    }


    private fun showNote(archive: Archive, note: Note){
        while (true){
            println("----------------------------------------------------------------------------\n" +
                    "Арихив: ${archive.title}")
            println("$note")

            println("1. Назад")

            print("Ввод => ")

            val input = readlnOrNull()?.toIntOrNull() ?: -1

            when (input) {
                1 -> return
                else -> println("----------------------------------------------------------------------------" +
                        "\nВведите номер из меню")
            }

        }
    }

    private fun showNotes(archive: Archive){
        while (true){
            println("----------------------------------------------------------------------------\n" +
                    "Арихив: ${archive.title}")
            println("Список заметок:")
            println("0. Создать заметку")

            for ((k, v) in archive.getNotes()){
                println("${k}. ${v.title}")
            }

            println("${archive.getNotes().size + 1}. Назад")

            print("Ввод => ")
            val input = readlnOrNull()?.toIntOrNull() ?: -1


            when (input) {
                0 -> archive.addNote()
                in 1..archive.getNotes().size -> showNote(archive, archive.getNotes()[input]!!)
                archive.getNotes().size+1 -> return
                else -> println("----------------------------------------------------------------------------" +
                        "\nВведите номер из меню")
            }

        }
    }

    fun showArchives(){
        while (true){
            println("Список архивов:")
            println("0. Создать архив")

            for ((k, v) in archivesMap){
                println("${k}. ${v.title}")
            }

            println("${archivesMap.size + 1}. Выход")

            print("Ввод => ")
            val input = readlnOrNull()?.toIntOrNull() ?: -1


            when (input) {
                0 -> putArchive()
                in 1..archivesMap.size -> {
                    showNotes(archivesMap[input]!!)
                }
                archivesMap.size+1 -> return
                else -> println("----------------------------------------------------------------------------" +
                        "\nВведите номер из меню")
            }

            println("----------------------------------------------------------------------------")

        }
    }

}