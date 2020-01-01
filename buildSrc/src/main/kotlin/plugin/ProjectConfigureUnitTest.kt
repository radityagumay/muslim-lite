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

import com.android.build.gradle.BaseExtension
import deps
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureUnitTest() = this.extensions.getByType<BaseExtension>().run {
    dependencies {
        add("implementation", deps.android.test.junit)
        add("implementation", deps.android.test.mockitoCore)
        add("implementation", deps.android.test.mockitoKotlin)
    }
}