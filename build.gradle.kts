plugins {
	kotlin("multiplatform") version "1.4.0"
	id("nebula.release") version "15.1.0"
	id("ru.capjack.bintray") version "1.0.0"
}

group = "ru.capjack.tool"

repositories {
	jcenter()
}

kotlin {
	
	jvm {
		compilations.all { kotlinOptions.jvmTarget = "1.8" }
	}
	js(IR) {
		browser()
	}
	
	sourceSets {
		get("commonTest").dependencies {
			implementation(kotlin("test-common"))
			implementation(kotlin("test-annotations-common"))
		}
		
		get("jvmTest").dependencies {
			implementation(kotlin("test-junit"))
		}
		
		get("jsTest").dependencies {
			implementation(kotlin("test-js"))
		}
	}
}
