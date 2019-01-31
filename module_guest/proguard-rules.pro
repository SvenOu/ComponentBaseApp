# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in F:\Android\program\AndroidStudioSdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


# 主要业务,需要以后处理
-dontwarn com.tts.**
-keep class com.tts.** { *; }

-dontwarn com.igexin.**
-keep class com.igexin.** { *; }

-keep class com.google.** { *; }
-keep class com.fasterxml.jackson.** { *; }
-keep class com.facebook.** { *; }

-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.** { *; }

-keep class com.digits.sdk.** { *; }
-keep class com.rengwuxian.materialedittext.** { *; }
-keep class com.eprize.mobile.eprizemobilesdk.** { *; }
-keep class com.twitter.sdk.android.** { *; }
-keep class com.nineoldandroids.** { *; }
-keep class com.crashlytics.android.answers.** { *; }
-keep class com.nostra13.universalimageloader.** { *; }
-keep class com.squareup.** { *; }
-keep class com.melnykov.fab.** { *; }
-keep class com.umeng.analytics.** { *; }
-keep class com.makeramen.roundedimageview.** { *; }
-keep class com.github.kayvannj.permission_utils.** { *; }
-keep class com.lsjwzh.widget.recyclerviewpager.** { *; }
-keep class java.** { *; }

-dontwarn org.**
-keep class org.** { *; }

-keep class bolts.** { *; }
-keep class io.fabric.sdk.android.** { *; }
-keep class butterknife.** { *; }
-keep class jp.co.cyberagent.android.** { *; }
-keep class retrofit.** { *; }
-keep class javax.** { *; }
-keep class uk.co.chrisjenx.** { *; }
-keep class dagger.** { *; }
-keep class u.aly.** { *; }
-keep class flex.messaging.** { *; }
-keep class dalvik.system.** { *; }
-keep class springfox.documentation.** { *; }
-keep class jxl.** { *; }
-keep class rx.** { *; }
-keep class net.sf.json.** { *; }
-keep class junit.framework.** { *; }