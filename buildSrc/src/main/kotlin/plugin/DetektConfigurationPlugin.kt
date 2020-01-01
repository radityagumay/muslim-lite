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

import deps
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.detekt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import versions

class DetektConfigurationPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.apply<DetektPlugin>()

        project.afterEvaluate {
            val configFile = "$rootDir/buildSrc/detekt/detekt.yml"

            detekt {
                toolVersion = versions.detekt
                input = files(
                    "src/main/kotlin",
                    "src/test/kotlin",
                    "src/androidTest/kotlin"
                )
                config = files(configFile)
                reports {
                    xml {
                        enabled = true
                        destination = file("${rootDir}/report/${project.name}/detekt/detekt.xml")
                    }
                    html {
                        enabled = true
                        destination = file("${rootDir}/report/${project.name}/detekt/detekt.html")
                    }
                }
            }

            dependencies {
                add("detekt", deps.detekt.cli)
                add("detektPlugins", deps.detekt.lint)
            }
        }
    }
}