package notesApp

class Showing {
    private val archivesMap: MutableMap<Int, Archive> = mutableMapOf()

    private fun putArchive () {
        println("=== Введите название архива ===")
        val inputTitle = readlnOrNull() ?: ""
        if (inputTitle.isNotEmpty()){
            archivesMap[archivesMap.size+1] = Archive(inputTitle)
            println("=== Архив $inputTitle создан ===")
        } else {
            println("Название не может быть пустым")
            putArchive()
        }

    }

    fun getArchives(): Map<Int, Archive>{
        return archivesMap
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

            menu(archivesMap, listMa = { input, map ->
                when (input) {
                    0 -> putArchive()
                    in 1..map.size -> {
                        showNotes(map[input] as Archive)
                    }

                    map.size+1 -> return
                    else -> println("----------------------------------------------------------------------------" +
                            "\nВведите номер из меню")
                }
            }
        }
    }

    private inline fun <reified T: Item> menu(map: MutableMap<Int, T>, listMa: (String, MutableMap<Int, Item>) -> Unit) {
        for ((k, v) in map){
            println("${k}. ${v.title}")
        }

        println("${map.size + 1}. Выход")

        print("Ввод => ")
        val input = readlnOrNull()?.toIntOrNull() ?: -1

        listMa(input, map)

        println("----------------------------------------------------------------------------")
    }
}