import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Note(
    private var currentTime: LocalDateTime,
    private var header: String,
    private var note: String,
) {

    fun getDate(): LocalDateTime {
        return this.currentTime
    }

    fun getHeader(): String {
        return this.header
    }

    fun getNote(): String {
        return this.note
    }

    fun setCurrentTime(currentTime: LocalDateTime) {
        this.currentTime = currentTime
    }

    fun setHeader(header: String) {
        this.header = header
    }

    fun setNote(note: String) {
        this.note = note
    }

    companion object {
        fun currentDateTime(): String {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            return current.format(formatter)
        }
    }
}
