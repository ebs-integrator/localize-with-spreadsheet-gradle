package com.ebs.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.*

class LocalizationsKtPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("localizations-kt") { task ->
            task.doLast {
                println("LocalizationsKtPlugin apply doLast")
                project.exec { exec ->
                    val file = File(filePath)
                    if (System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("windows")) {
                        if (!file.isDirectory) {
                            println(message)
                            val install = "cmd /c $installCommand"
                            exec.commandLine(install)
                        }
                        exec.commandLine("cmd", "/c", script)
                    } else {
                        if (!file.isDirectory) {
                            println(message)
                            exec.commandLine(installCommand)
                        }
                        exec.commandLine("sh", "-c", script)
                    }
                }
            }
        }.apply {
            group = "ebs plugins"
        }
    }
    companion object {
        const val script = "node update_localizations.js"
        const val installCommand = "npm install --prefix . ebs-integrator/localize-with-spreadsheet"
        const val filePath = "node_modules/localize-with-spreadsheet"
        const val message = "localize-with-spreadsheet script is installing..."
    }
}

/* abstract class LocalizationsTask : DefaultTask() {
    @Input
    val greeting = "hello from GreetingTask"

    @TaskAction
    fun greet(exec: Exec) {
        println(greeting)
    }
} */
