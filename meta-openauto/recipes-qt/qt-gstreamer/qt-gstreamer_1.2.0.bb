require recipes-qt/qt5/qt5.inc

DESCRIPTION = "Qt plugins for GStreamer 1.0"
SECTION = "multimedia"
LICENSE = "LGPLv2.1"
DEPENDS = "glib-2.0-native gstreamer1.0 gstreamer1.0-plugins-base cmake boost qtbase qtdeclarative "

inherit cmake_qt5

PACKAGECONFIG ??= "examples"
PACKAGECONFIG[examples] = "-DQTGSTREAMER_EXAMPLES=ON, -DQTGSTREAMER_EXAMPLES=OFF"

LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = " \
    git://github.com/GStreamer/qt-gstreamer.git;branch=master;protocol=http \
    "
SRCREV = "6e4fb2f3fcfb453c5522c66457ac5ed8c3b1b05c"

S = "${WORKDIR}/git"

export EXTRA_OECMAKE = "-DQT_VERSION=5 \
    -DUSE_QT_PLUGIN_DIR=OFF \
    -DCMAKE_SKIP_INSTALL_RPATH=YES \
    -DCMAKE_SKIP_RPATH=YES \
"

EXTRA_OECONF += "--disable-rpath"

#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
#INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} += "\
    ${libdir}/gstreamer-1.0/* \
    ${libdir}/qt5/qml \
"

FILES_${PN}-dbg += "\
    ${libdir}/gstreamer-1.0/.debug/* \
"

FILES_${PN}-dev += "${libdir}/cmake/* \
                    ${libdir}/cmake/QtGStreamer/* \
                   "

FILES_${PN}-examples += " \
    /usr/share/qt5/examples \
"

do_install_append() {
    mkdir -p ${D}/usr/share/qt5/examples/qt-gstreamer/
    install ${B}/examples/qmlplayer2/qmlplayer2 ${D}/usr/share/qt5/examples/qt-gstreamer/
    install -d ${D}${datadir}/qt5/examples/${P}
    install -m 0755 ${B}/examples/qmlplayer2/qmlplayer2 ${D}${datadir}/qt5/examples/${P}
}
