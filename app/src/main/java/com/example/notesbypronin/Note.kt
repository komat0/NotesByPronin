package com.example.notesbypronin

import java.time.LocalDateTime

class Note {
    val currentTime = LocalDateTime.now()
    private var id: Long = 0
    private var date: LocalDateTime
    private var header: String
    private var note: String

    constructor() {
        this.id = id++
        this.date = currentTime
        this.header = ""
        this.note = ""
    }

    fun getDate(): LocalDateTime {
        return this.date
    }

    fun getHeader(): String {
        return this.header
    }

    fun getNote(): String {
        return this.note
    }

    fun setGate(d: LocalDateTime) {
        this.date = d
    }

    fun setHeader(h: String) {
        this.header = h
    }

    fun setNote(n: String) {
        this.note = n
    }

}