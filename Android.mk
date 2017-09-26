LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_JAVA_LIBRARIES := bouncycastle conscrypt telephony-common
LOCAL_STATIC_JAVA_LIBRARIES := \
	android-support-v4 \
	android-support-v13 \
	android-support-v7-preference \
    	android-support-v7-appcompat \
   	android-support-v14-preference \
        android-support-customtabs \
        android-support-design

LOCAL_RESOURCE_DIR := \
    $(LOCAL_PATH)/res \
    frameworks/support/v7/preference/res \
    frameworks/support/v14/preference/res \
    frameworks/support/v7/appcompat/res \
    frameworks/support/v7/recyclerview/res \
    frameworks/support/design/res

LOCAL_AAPT_FLAGS := --auto-add-overlay \
    --extra-packages android.support.v7.preference \
    --extra-packages android.support.v14.preference \
    --extra-packages android.support.v17.preference \
    --extra-packages android.support.v7.appcompat \
    --extra-packages android.support.v7.recyclerview \
    --extra-packages android.support.design \
    --extra-packages com.google.android.gms

LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-java-files-under, src)
#LOCAL_ASSET_DIR := $(LOCAL_PATH)/assets
LOCAL_PACKAGE_NAME := TestRom
LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true
#LOCAL_PROGUARD_FLAG_FILES := proguard.flags
include $(BUILD_PACKAGE)
# Use the folloing include to make our test apk.
# include $(call all-makefiles-under,$(LOCAL_PATH))
