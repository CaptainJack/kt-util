plugins {
	kotlin("multiplatform") version "1.7.10"
	id("ru.capjack.publisher") version "1.0.0"
}

group = "ru.capjack.tool"

repositories {
	mavenCentral()
}

kotlin {
	jvm {
		compilations.all { kotlinOptions.jvmTarget = "17" }
	}
	js(IR) {
		browser()
	}
	
	sourceSets {
		get("commonTest").dependencies {
			implementation(kotlin("test"))
		}
	}
}
