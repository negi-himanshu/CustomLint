plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    compileOnly("com.android.tools.lint:lint-api:31.2.2")
    compileOnly("com.android.tools.lint:lint-checks:31.2.2")
    compileOnly("com.android.tools.lint:lint-tests:31.2.2")
}