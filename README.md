# Custom Lint

### Overview
This project demonstrates how to enforce custom lint rules to your android application. Lint is a static code analysis tool which scans the source code for potential bugs or optimisation. By creating custom lint rules, developers can enforce project-specific coding conventions, improve code quality, and ensure adherence to best practices. This project restricts the usage of Text composable across the application, in a similar way developers can enforce the usage of design system components across the application.

This is how the IDE flags the usage of restricted component.
![ide-error-sample](https://github.com/negi-himanshu/CustomLint/blob/1573200200e26dcb8273342913660521bcee6ff2/assets/ide-error-sample.png?raw=true)

To get the error report, run `./gradlew lint`

### Installation
```
git clone https://github.com/negi-himanshu/CustomLint
```
