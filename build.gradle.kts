plugins {
    id("java")
}

repositories {
    mavenLocal()
}

group = "org.sa"
version = "1.0.0"
description = "git-branch-deleter"

dependencies {
    implementation(project(":util"))
}