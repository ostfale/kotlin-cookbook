package de.ostfale.kotlin.test.tmpfiles

import java.nio.file.Files
import java.nio.file.Path

// https://arturdryomov.dev/posts/testing-files-without-files/
interface Packages {
    fun pack(files: Iterable<Path>): Path

    class Impl(private val packagesRoot: Path) : Packages {

        override fun pack(files: Iterable<Path>): Path {
            val packageFile = packagesRoot.resolve("package.tar")
            return packageFile.apply { Files.createFile(this) }
        }
    }
}

