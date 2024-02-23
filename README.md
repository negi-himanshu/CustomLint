# Custom Lint

Lint is a static code analysis tool which scans the source code for potential bugs or optimisation.
This project demonstrates how to enforce custom rules to your android application. It restricts
the usage of Text composable which can be used to enforce the usage of design system components.

Image below shows how the IDE flags the usage of restricted component.
![ide-error-sample](https://github.com/negi-himanshu/CustomLint/blob/1573200200e26dcb8273342913660521bcee6ff2/assets/ide-error-sample.png?raw=true)

To get the error report, run `./gradlew lint`
