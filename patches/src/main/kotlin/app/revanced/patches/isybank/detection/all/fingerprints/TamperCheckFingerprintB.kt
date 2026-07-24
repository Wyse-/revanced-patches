package wyse.patches.isybank

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object TamperCheckFingerprintB : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("TamperCheck;") && methodDef.name == "b"
    }
)
