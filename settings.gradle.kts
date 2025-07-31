pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ComposeExample"
include(":app")
include(":core:model")
include(":feature:following")
include(":core:designsystem")
include(":feature:posts")

include(":feature:followers")
include(":core:database")
include(":core:data")
include(":redux")
include(":feature:home")
include(":core:common")
