package org.example.zfinalFIleGenerator

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

fun main() {
    val baseSourcePath = "/Users/guptatilak/Documents/Sapient/kotlin/Kotlin/src/main/kotlin"
    val baseTestPath = "/Users/guptatilak/Documents/Sapient/kotlin/Kotlin/src/test/kotlin"
    val packageName = "dynamicProgramming"

    val sourcePath = Paths.get(baseSourcePath, packageName)
    val testPath = Paths.get(baseTestPath, packageName)

    // Ensure the test directory exists
    Files.createDirectories(testPath)

    val bearerToken = "ya29.a0AeDClZCTC-1EuHnSGQkp_-pHbXYhIYm4ei7RV0zAVI019OAYIc1jHYuibXGPHwLdoEw2AlQFeUvGA9NI6I2pxK7WnyBthF9yOmiOjFdYnKhIhVUGRHwsy7VXTjP09cNtr3dIANEppAk5Tua4n3F4_kR2_L5jdmcXzj43-aX2N1ek9SAaCgYKAd0SARISFQHGX2Mi25bxO_uNrwik5ToTQ1jJ1Q0182"
    val llmClient = LlmApiClient(bearerToken)
    val promptGenerator = PromptGenerator()
    val testGenerator = TestGenerator(llmClient, promptGenerator)

    // Get all Kotlin files in the specified package
    val kotlinFiles = Files.walk(sourcePath)
        .filter { it.toString().endsWith(".kt") }
        .toList()

    kotlinFiles.forEach { file ->
        val sourceFileName = file.fileName.toString()
        val testFileName = "${sourceFileName.removeSuffix(".kt")}SapientGeneratedTest.kt"
        val sourceCode = Files.readString(file)

        val config = TestConfig(
            sourceFileName = sourceFileName,
            testFileName = testFileName,
            sourceCode = sourceCode,
            testFramework = "JUnit 5"
        )

        val outputPath = testPath.resolve(testFileName).toString()

        try {
            testGenerator.generateAndSaveTest(config, outputPath)
            println("Test file has been generated and saved to: $outputPath")
        } catch (e: Exception) {
            println("Error generating test for $sourceFileName: ${e.message}")
            e.printStackTrace()
        }
    }
}