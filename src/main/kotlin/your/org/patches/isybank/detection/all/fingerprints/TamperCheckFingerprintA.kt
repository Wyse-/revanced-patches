package your.org.patches.example

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object TamperCheckFingerprintA : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("TamperCheck;") && methodDef.name == "a"
    }
)
