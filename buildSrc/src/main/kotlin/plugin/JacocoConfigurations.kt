/*
* Copyright 2019 RadityaLabs.
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package plugin

import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.register
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport
import java.io.File

fun Project.configureJacocoMultiplatform() {
    configureJacoco {
        tasks.register<JacocoReport>(this) {
            setDependsOn(setOf("jvmTest"))
            group = "verification"
            description = "Runs jacoco test report for jvm multiplatform"

            val debugTree = fileTree("${project.buildDir}/classes/kotlin/jvm/")
            val mainSrc = "${project.projectDir}/src/commonMain/kotlin"

            sourceDirectories.setFrom(files(mainSrc))
            classDirectories.setFrom(files(debugTree))

            executionData.setFrom(fileTree(buildDir).apply {
                setIncludes(setOf("jacoco/jvmTest.exec"))
            })
        }
    }
}

fun Project.configureJacocoAndroid() {
    configureJacoco {
        tasks.register<JacocoReport>(this) {
            setDependsOn(setOf("testDebugUnitTest", "createDebugCoverageReport"))
            group = "verification"
            description = "Runs jacoco test report for android"

            val debugTree = fileTree("${project.buildDir}/tmp/kotlin-classes/debug")
            val mainSrc = "${project.projectDir}/src/main/kotlin"

            sourceDirectories.setFrom(files(mainSrc))
            classDirectories.setFrom(files(debugTree))

            executionData.setFrom(fileTree(buildDir).apply {
                setIncludes(setOf("jacoco/testDebugUnitTest.exec", "outputs/code-coverage/connected/*coverage.ec"))
            })
        }
    }
}

fun Project.configureJacocoJvm() {
    configureJacoco {
        tasks.named<JacocoReport>(this).configure {
            dependsOn(tasks.named("test"))
        }
    }
}

private fun Project.configureJacoco(configuration: String.() -> Unit) {
    apply<JacocoPlugin>()

    extensions.getByType(JacocoPluginExtension::class.java).toolVersion = versions.jacoco

    val task = "jacocoTestReport"

    task.configuration()

    tasks.named<JacocoReport>(task).configure {
        reports.apply {
            xml.apply {
                isEnabled = true
                destination = File("${project.buildDir}/reports/jacocoTestReport.xml")
            }
            html.apply {
                isEnabled = true
                destination = File("${project.buildDir}/reports/jacoco")
            }
        }
    }
}
