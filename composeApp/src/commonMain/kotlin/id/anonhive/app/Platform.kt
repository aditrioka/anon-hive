package id.anonhive.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform