package wyse.patches.isybank

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object DexguardFingerprintA : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("Ljb/a\$a;") && methodDef.name == "a"
    }
)
