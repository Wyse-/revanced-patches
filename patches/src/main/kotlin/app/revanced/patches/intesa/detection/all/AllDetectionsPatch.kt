package wyse.patches.intesa

import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions
import app.revanced.patcher.patch.PatchException

@Patch(
    name = "Remove all detections",
    description = "Removes all checks (certificate, debug key signature, emulator, installation origin).",
    compatiblePackages = [CompatiblePackage("com.latuabancaperandroid")]
)
@Suppress("unused")
object AllDetectionsPatch : BytecodePatch(
    setOf(AllDetectionsFingerprint)
) {
    override fun execute(context: BytecodeContext) = AllDetectionsFingerprint.result?.mutableMethod?.replaceInstructions(
        0,
        """
            return-void
        """
    ) ?: throw PatchException("Failed to resolve ${this.javaClass.simpleName}")
}
