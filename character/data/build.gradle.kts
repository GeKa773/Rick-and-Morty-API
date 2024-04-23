plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.kotlinSerialization)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    implementation(project(":character:domain"))
    implementation(project(":base:models:domain"))
    implementation(project(":base:models:data"))

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.annatation)
    implementation(libs.kotlinx.coroutines.core)
}