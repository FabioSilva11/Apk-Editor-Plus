package com.saas.apkeditorplus.engine.axml

class ManifestInfo {
    var label: String? = null
    var versionName: String? = null
    var packageName: String? = null
    var applicationName: String? = null
    
    var versionCode: Int = -1
    var installLocation: Int = -1
    var minSdkVersion: Int = -1
    var targetSdkVersion: Int = -1
    var maxSdkVersion: Int = -1
    
    var labelStringId: Int = -1
    var versionNameStringId: Int = -1
    var packageStringId: Int = -1
    var iconStringId: Int = -1
    var labelResourceId: Int = -1
    
    val stringPool = mutableListOf<String>()
    val componentNames = mutableListOf<Int>()
    val componentTypeMap = mutableMapOf<Int, Int>()
    val permissions = mutableMapOf<Int, String>()
    val providers = mutableListOf<ProviderInfo>()
    val launcherActivities = mutableListOf<Int>()
    val activityAliasMap = mutableMapOf<Int, Int>()
    val usesPermissions = mutableSetOf<String>()

    class ProviderInfo {
        var name: String? = null
        var authorities: String? = null
        var nameId: Int = -1
        var authoritiesId: Int = -1
    }
}
