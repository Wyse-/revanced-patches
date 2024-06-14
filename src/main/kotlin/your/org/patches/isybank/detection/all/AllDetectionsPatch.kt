package wyse.patches.isybank

import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.PatchException

@Patch(
    name = "Remove all detections",
    description = "Removes all checks (certificate, debug key signature, emulator, installation origin).",
    compatiblePackages = [CompatiblePackage("com.intesasanpaolo.isybank.mobile")]
)
@Suppress("unused")
object AllDetectionsPatch : BytecodePatch(
    setOf(DexguardFingerprintA, DexguardFingerprintB, TamperCheckFingerprintA, TamperCheckFingerprintB)
) {
    override fun execute(context: BytecodeContext) =
        setOf(DexguardFingerprintA, DexguardFingerprintB, TamperCheckFingerprintA, TamperCheckFingerprintB).forEach { fingerprint ->
            fingerprint.result?.mutableMethod?.replaceInstruction(0, "return-void")
                ?: throw PatchException("Failed to resolve ${this.javaClass.simpleName}"
        }
}
