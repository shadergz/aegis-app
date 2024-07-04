cmake_minimum_required(VERSION 3.16)

project(Native)
set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

add_library(aegis MODULE)
target_sources(aegis PRIVATE
    jni_application.cpp
    external_functions.cpp
    application.cpp
    vm_manager.cpp
)
target_link_libraries(aegis PRIVATE android)

target_include_directories(aegis PRIVATE ${CMAKE_SOURCE_DIR})
