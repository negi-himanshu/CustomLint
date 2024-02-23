package com.example.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.example.lint.detector.MaterialTextDetector

class CustomLintIssueRegistry: IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(MaterialTextDetector.ISSUE)

    override val api: Int
        get() = CURRENT_API
}