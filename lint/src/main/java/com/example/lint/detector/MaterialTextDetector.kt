package com.example.lint.detector

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.SourceCodeScanner
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

class MaterialTextDetector: Detector(), SourceCodeScanner {

    override fun getApplicableMethodNames(): List<String> = listOf(TEXT_COMPOSABLE)

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        super.visitMethodCall(context, node, method)
        if (method.containingClass?.qualifiedName?.startsWith(COMPOSE_COMPONENT_PACKAGE_PREFIX) == true) {
            reportUsage(context, node)
        }
    }

    private fun reportUsage(
        context: JavaContext,
        node: UCallExpression
    ) {
        val restrictedElementName = node.methodName
        context.report(
            issue = ISSUE,
            scope = node,
            location = context.getCallLocation(
                call = node,
                includeReceiver = true,
                includeArguments = true
            ),
            message = "$restrictedElementName usage is forbidden"
        )
    }

    companion object {

        private val IMPLEMENTATION = Implementation(
            MaterialTextDetector::class.java,
            Scope.JAVA_FILE_SCOPE
        )

        private const val COMPOSE_COMPONENT_PACKAGE_PREFIX = "androidx.compose.material"

        val ISSUE: Issue = Issue
            .create(
                id = "MaterialTextUsage",
                briefDescription = "Material text component used directly",
                explanation = """
                This check highlights calls in code that uses Material composable directly instead
                 of custom wrapper.
            """.trimIndent(),
                category = Category.CUSTOM_LINT_CHECKS,
                priority = 7,
                severity = Severity.ERROR,
                implementation = IMPLEMENTATION
            )

        private const val TEXT_COMPOSABLE = "Text"
    }
}