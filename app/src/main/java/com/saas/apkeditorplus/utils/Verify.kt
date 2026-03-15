package com.saas.apkeditorplus.utils

import com.android.apksig.ApkVerifier
import java.io.File
import java.security.MessageDigest
import java.security.cert.X509Certificate
import java.util.Locale

object Verify {

    fun verify(apkPath: String): String {
        val result = StringBuilder()
        try {
            val apkFile = File(apkPath)
            val verifier = ApkVerifier.Builder(apkFile).build()
            val verificationResult = verifier.verify()

            if (verificationResult.isVerified) {
                result.append("APK Signature is VALID\n\n")
            } else {
                result.append("APK Signature is INVALID/INCOMPLETE\n\n")
            }

            // Get all signer certificates
            val certificates = verificationResult.signerCertificates
            if (certificates.isEmpty()) {
                result.append("No signer certificates found.\n")
            } else {
                for ((index, cert) in certificates.withIndex()) {
                    result.append("Signer #").append(index + 1).append(":\n")
                    appendCertificateInfo(cert, result)
                    result.append("--------------------------\n")
                }
            }

            // Signature Schemes
            result.append("\nSignature Schemes:\n")
            result.append("v1 (JAR signing): ").append(if (verificationResult.isVerifiedUsingV1Scheme) "Yes" else "No").append("\n")
            result.append("v2 (APK Signature Scheme v2): ").append(if (verificationResult.isVerifiedUsingV2Scheme) "Yes" else "No").append("\n")
            result.append("v3 (APK Signature Scheme v3): ").append(if (verificationResult.isVerifiedUsingV3Scheme) "Yes" else "No").append("\n")
            result.append("v4 (APK Signature Scheme v4): ").append(if (verificationResult.isVerifiedUsingV4Scheme) "Yes" else "No").append("\n")

        } catch (e: Exception) {
            result.append("Error verifying APK: ").append(e.message)
        }
        return result.toString()
    }

    private fun appendCertificateInfo(cert: X509Certificate, sb: StringBuilder) {
        sb.append("Owner: ").append(cert.subjectX500Principal.name).append("\n")
        sb.append("Issuer: ").append(cert.issuerX500Principal.name).append("\n")
        sb.append("Serial Number: ").append(cert.serialNumber.toString(16)).append("\n")
        sb.append("Valid from: ").append(cert.notBefore).append("\n")
        sb.append("Valid until: ").append(cert.notAfter).append("\n")
        
        // Fingerprints
        sb.append("\nFingerprints:\n")
        sb.append("  MD5:    ").append(getFingerprint(cert, "MD5")).append("\n")
        sb.append("  SHA-1:  ").append(getFingerprint(cert, "SHA-1")).append("\n")
        sb.append("  SHA-256: ").append(getFingerprint(cert, "SHA-256")).append("\n")
    }

    private fun getFingerprint(cert: X509Certificate, algorithm: String): String {
        return try {
            val md = MessageDigest.getInstance(algorithm)
            val publicKey = cert.encoded
            val hexString = StringBuilder()
            val digest = md.digest(publicKey)
            for (i in digest.indices) {
                val hex = Integer.toHexString(0xff and digest[i].toInt())
                if (hex.length == 1) hexString.append('0')
                hexString.append(hex.uppercase(Locale.ROOT))
                if (i < digest.size - 1) hexString.append(":")
            }
            hexString.toString()
        } catch (e: Exception) {
            "Error"
        }
    }
}
