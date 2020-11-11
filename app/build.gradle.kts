plugins {
    application
}

repositories {
    flatDir {
        dirs("lib")
    }
    jcenter()
}

dependencies {

    implementation(":airport-1.0.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

application {
    // Define the main class for the application.
    mainClass.set("dev.rmuhamedgaliev.App")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
