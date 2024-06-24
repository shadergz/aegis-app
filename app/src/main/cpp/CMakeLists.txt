cmake_minimum_required(VERSION 3.16)

project(Native)

add_library(aegis MODULE)
target_sources(aegis PRIVATE kotlin_misc.cpp)
target_link_libraries(aegis PRIVATE android)
