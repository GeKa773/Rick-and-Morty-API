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
include(":character:database")
include(":character:domain")
include(":character:data")
include(":character:presentation")

include(":base:utils")
include(":base:android")
include(":base:models:api")
include(":base:models:data")
