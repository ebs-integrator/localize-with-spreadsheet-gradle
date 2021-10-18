# localizations-gradle-plugin

This is a Gradle project to install the localize-with-spreadsheet configurations in our projects.

## Publishing the plugin

1. Setup IntelliJ IDEA (https://www.jetbrains.com/idea/download/#section=mac).

2. Download and open localizations-gradle-plugin project on IntelliJ IDEA.

3. Once the project is build, go to View -> Tool Windows -> Gradle.

4. Double click the following task: Tasks -> publishing -> publishToMavenLocal.

## Applying the plugin

> The below steps must be applied to the top-level build.gradle file.

1. Add local repository of Maven and plugin's dependency:

```
buildscript {
    ...
    repositories {
        ...
        mavenLocal()
    }
    dependencies {
        ...
        classpath 'com.ebs.plugins:localizations-kt:0.0.1'
    }
}
```

2. Apply the plugin

`apply plugin: 'com.ebs.plugins.localizations-kt'`

3. Run localization task: Tasks -> ebs plugins -> localizations-kt

