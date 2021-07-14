SUMMARY = "OpenAuto Yocto Recipe"
DESCRIPTION = "OpenAuto" 
LICENSE = "GPL-3.0" 
LIC_FILES_CHKSUM = "file://Readme.md;md5=32ef6748de2f0d2a39f812e1f6a0cb78"
SRC_URI = "git://github.com/matt2005/openauto.git;protocol=https;branch=yocto \
           file://0001-Fix-compile-errors.patch \
           "
SRCREV = "yocto"

DEPENDS += " aasdk pulseaudio gpsd taglib util-linux librtaudio qtbase qtconnectivity qtmultimedia"

inherit cmake_qt5
EXTRA_OECMAKE += " -DCMAKE_BUILD_TYPE=Release -DRPI3_BUILD=FALSE \
    -DCMAKE_SKIP_INSTALL_RPATH=YES \
    -DCMAKE_SKIP_RPATH=YES \
"
 
# this is a revision number that should be updated every time you alter this recipe
PR = "r3" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/git"

INSANE_SKIP_${PN} += "dev-deps"
INSANE_SKIP_${PN} += "dev-elf"
do_compile[progress] = "percent"