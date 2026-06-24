package com.maxrave.windmusic.expect

actual fun getDownloadFolderPath(): String = System.getProperty("user.home") + "/Downloads"