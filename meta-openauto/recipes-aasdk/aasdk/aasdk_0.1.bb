SUMMARY = "AndroidAuto SDK Yocto Recipe"
DESCRIPTION = "AndroidAuto SDK" 
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://../git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
SRC_URI = "git://github.com/opencardev/aasdk.git;protocol=https;branch=development"
SRCREV = "development"

DEPENDS += " protobuf protobuf-native boost libusb"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"
# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# TODO fix this path
S="${WORKDIR}/git"

do_install_append () {
	install -d ${D}${includedir}/aasdk_proto
	cp -R --no-dereference --preserve=mode,links -v  ${S}/include/f1x ${D}${includedir}/
	install -m 0644 ${S}/../build/aasdk_proto/*.h ${D}${includedir}/aasdk_proto
}
do_compile[progress] = "percent"