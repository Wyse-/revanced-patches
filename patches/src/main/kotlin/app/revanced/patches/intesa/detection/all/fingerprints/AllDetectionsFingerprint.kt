package wyse.patches.intesa

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object AllDetectionsFingerprint : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("DexguardDelegate;") && methodDef.name == "a"
    }
)
