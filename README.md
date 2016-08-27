AnimatedVectorDrawableCompat stop working after ProGuard issue demo
===

This project is a minimal demo code which reproduce the AnimatedVectorDrawableCompat's ProGuard related issue.

## How to reproduce the bug?

### 0. Prerequisites

- Android **4.4** / **5.0** / **5.1** device (*)
- Android SDK

(*) This issue **cannot be reprodueced on Android 6.0 / 7.0.** I confirmed the issue present on 4.4, 5.0 and 5.1. Maybe the issue also be reproduced on 3.0 - 4.3, but I have not tested on them.


### 1. Build & Installation

```bash
git clone https://github.com/h6ah4i/animatedvectordrawablecompatproguardissue
cd animatedvectordrawablecompatproguardissue
./gradlew installDebug
```

### 2. Launch LogCat
Open an another terminal window, then launch logcat.
```bash
adb logcat
```

### 2. Launch the app

```bash
com.h6ah4i.example.animatedvectordrawablecompatproguardissue
```

### 3. Check the app is not working

Launch the demo app, then tap the "Rotate!" button. However, nothing seems to be happened on the screen and the following message will be appeared on LogCat.

> W/PropertyValuesHolder(11624): Method setRotation() with type float not found on target class class android.support.a.a.p

### 4. Tweak ProGuard settings

Open `app/build.gradle` and modify the `buildTypes.debug` block like the following; (comment out the first `proguardFiles` line and uncommend the second one)

```gradle

buildTypes {
    debug {
        minifyEnabled true
        // proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules-fixed.pro'
    }
    release {
      ...
    }
  }
```
### 5. Launch the app again

```bash
com.h6ah4i.example.animatedvectordrawablecompatproguardissue
```

### 6. Check the app is working

Launch the demo app, then tap the "Rotate!" button again. You will see that the Android logo rotates 180 degrees. Yey!


## Original reported issue

- [GitHub - h6ah4i/android-advancedrecyclerview Help - Proguard issue related to ExpandableItemIndicator animation #299](https://github.com/h6ah4i/android-advancedrecyclerview/issues/299)
