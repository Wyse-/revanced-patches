package wyse.patches.isybank

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object TamperCheckFingerprintA : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("TamperCheck;") && methodDef.name == "a"
    }
)
