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

    implementation(project(":base:models:api"))
    implementation(project(":base:models:data"))
    implementation(project(":character:data"))

    implementation(libs.retrofit)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.annatation)
    implementation(libs.retrofit.converter.kotlinx.serialization)
    implementation(libs.retrofit.result.adapter)
    implementation(libs.okhttp.logging.interceptor)
}