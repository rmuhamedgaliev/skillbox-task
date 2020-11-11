plugins {
    application
}

repositories {
    flatDir {
        dirs("lib")
    }
    jcenter()
}

val lombokVersion = "1.18.14";

dependencies {

    implementation(":airport-1.0.1")

    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
}

application {
    // Define the main class for the application.
    mainClass.set("dev.rmuhamedgaliev.App")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
