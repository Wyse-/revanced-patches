package wyse.patches.isybank

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object DexguardFingerprintB : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("Ljb/a\$a;") && methodDef.name == "b"
    }
)
