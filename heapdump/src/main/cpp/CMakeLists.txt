
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

# Declares and names the project.

project("heapdump")

set(XHOOK_BASE_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../xhook)
set(KWAI_ANDROID_BASE_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../KOOM-master/koom-common/kwai-android-base)

include_directories(${CMAKE_SOURCE_DIR}/include
        ${XHOOK_BASE_DIR}/src/main/cpp/include
        ${KWAI_ANDROID_BASE_DIR}/src/main/cpp/include/
        ${KWAI_ANDROID_BASE_DIR}/src/main/cpp/liblog/include/)

#设置生成的so动态库最后输出到jniLibs目录
#set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI})

LINK_DIRECTORIES(../jniLibs/${ANDROID_ABI})

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             heapdump

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
            heapdump_bridge.cpp hprof_strip.cpp hprof_dump.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       heapdump

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} xhook kwai-android-base)
