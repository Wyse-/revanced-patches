package your.org.patches.example

import app.revanced.patcher.fingerprint.MethodFingerprint

internal object AllDetectionsFingerprint : MethodFingerprint(
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("Ljb/a$a;") && methodDef.name == "a"
    }
)
