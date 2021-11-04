package com.ebsintegrator.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.util.*

class LocalizationsKtPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        project.tasks.create("updateLocalization") {
            it.doLast {
                project.exec { exec ->
                    exec.workingDir = File("./")
                    val file = File(filePath)
                    if (System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("windows")) {
                        if (!file.isDirectory) {
                            println(message)
                            val p = Runtime.getRuntime().exec("cmd /c $installCommand")
                            p.waitFor()
                        }
                        exec.commandLine("cmd", "/c", script)
                    } else {
                        if (!file.isDirectory) {
                            println(message)
                            val p = Runtime.getRuntime().exec(installCommand)
                            p.waitFor()
                        }
                        exec.commandLine("sh", "-c", script)
                    }
                }
            }.apply {
                group = "ebs plugins"
            }
        }
    }

    companion object {
        const val script = "node update_localizations.js"
        const val installCommand = "npm install --prefix . ebs-integrator/localize-with-spreadsheet"
        const val filePath = "node_modules/localize-with-spreadsheet"
        const val message = "localize-with-spreadsheet script is installing..."
    }
}


