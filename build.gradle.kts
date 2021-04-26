
plugins {
	kotlin("multiplatform") version "1.4.32"
	`maven-publish`
	id("nebula.release") version "15.3.1"
	id("ru.capjack.reposit") version "0.3.0"
}

group = "ru.capjack.tool"

repositories {
	mavenCentral()
}

kotlin {
	
	jvm {
		compilations.all { kotlinOptions.jvmTarget = "11" }
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

publishing {
	repositories {
		mavenCapjackPublic(reposit)
	}
}