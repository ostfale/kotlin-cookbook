package de.ostfale.kotlin.test

import com.google.common.jimfs.Jimfs
import de.ostfale.kotlin.test.tmpfiles.Packages
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.nio.file.FileSystem
import java.nio.file.Files
import kotlin.io.path.exists
import kotlin.test.assertTrue

// https://github.com/google/jimfs
class PackagesTests {

    private lateinit var packagesFileSystem: FileSystem
    private lateinit var packages: Packages

    @BeforeEach
    fun setUp() {
        packagesFileSystem = Jimfs.newFileSystem()

        packages = Packages.Impl(
            packagesRoot = packagesFileSystem.getPath("packages").apply {
                Files.createDirectory(this)
            },
        )
    }

    @AfterEach
    fun tearDown() {
        packagesFileSystem.close()
    }

    @Test
    fun pack() {
        val files = (0..10)
            .map { packagesFileSystem.getPath("$it.txt") }
            .onEach { Files.createFile(it) }

        assertTrue(packages.pack(files).exists())
    }
}