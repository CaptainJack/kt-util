plugins {
	kotlin("multiplatform") version "1.3.41"
	id("nebula.release") version "10.1.2"
	id("ru.capjack.bintray") version "0.18.1"
}

group = "ru.capjack.tool"

repositories {
	jcenter()
}

kotlin {
	
	jvm().compilations.all { kotlinOptions.jvmTarget = "1.8" }
	js()
	
	sourceSets {
		get("commonMain").dependencies {
			implementation(kotlin("stdlib-common"))
		}
		
		get("jvmMain").dependencies {
			implementation(kotlin("stdlib-jdk8"))
		}
		
		get("jsMain").dependencies {
			implementation(kotlin("stdlib-js"))
		}
	}
}
