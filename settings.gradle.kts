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

rootProject.name = "Rick and Morty"
include(":app")

include(":character:api")
include(":character:storage:database")
include(":character:storage:object_storage")
include(":character:domain")
include(":character:data")
include(":character:presentation")
include(":character:di")

include(":base:utils")
include(":base:android")
include(":base:models:api")
include(":base:models:data")
include(":base:models:domain")
include(":base:models:database")
