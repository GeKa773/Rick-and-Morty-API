plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    implementation(project(":base:models:database"))
    implementation(project(":base:models:data"))
    implementation(project(":character:data"))

    implementation(libs.kotlinx.coroutines.core)
}