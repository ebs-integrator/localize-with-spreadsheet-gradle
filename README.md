# localizations-gradle-plugin

This is a Gradle project to install the localize-with-spreadsheet configurations in our projects and create a gradle  task to update localizations from a Google spreadsheet.

## Publishing the plugin

1. Setup IntelliJ IDEA (https://www.jetbrains.com/idea/download/#section=mac).

2. Download and open localizations-gradle-plugin project on IntelliJ IDEA.

3. Once the project is build, go to View -> Tool Windows -> Gradle.

4. Double click the following task: Tasks -> publishing -> publishToMavenLocal.

## Applying the plugin

> The below steps must be applied to the top-level build.gradle file.
> 
> Node.js must me installed to use this script

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
        classpath 'com.ebsintegrator.plugins:localizations-kt:1.0.0'
    }
}
```

2. Apply the plugin

`apply plugin: 'com.ebsintegrator.plugins.localizations-kt'`



3. Create an `update-localization.js` file. Follow Step 1-4 instructions from: https://github.com/ebs-integrator/localize-with-spreadsheet

4. Place this file into the root directory of your project

5. Run localization task: Tasks -> ebs plugins -> updateLocalization

