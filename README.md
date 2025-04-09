## Prints
<image width=300 src="https://github.com/user-attachments/assets/bbbb2c7c-0111-410c-a353-f311f5100036"/>
<image width=300 src="https://github.com/user-attachments/assets/180e9b8f-b83b-4372-966a-9f0f9d133f5c"/>
<image width=300 src="https://github.com/user-attachments/assets/7f2fed7c-aa8b-4ec7-a0e5-bb4ed4f35922"/>

<image width=300 src="https://github.com/user-attachments/assets/10823d32-77b5-4b8f-9330-888ff2dee169"/>
<image width=300 src="https://github.com/user-attachments/assets/20ac8740-0dc9-4196-b0f1-23b73666845e"/>
<image width=300 src="https://github.com/user-attachments/assets/d6cb9461-9104-439b-8bc9-a9a6b50943c5"/>


This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
