package com.br.gook.scheduler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import java.util.*

@SpringBootApplication
@ComponentScan("com.br.gook")
class GookSchedulerApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"))
            runApplication<GookSchedulerApplication>(*args)
        }
    }
}
