package com.br.gook.scheduler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScans

@SpringBootApplication
class GookSchedulerApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<GookSchedulerApplication>(*args)
        }
    }
}
