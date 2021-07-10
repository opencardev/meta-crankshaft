DESCRIPTION = "RtAudio is a set of C++ classes which provide a common API \
for realtime audio input/output across Linux (native ALSA, JACK, and OSS), \
Macintosh OS X, SGI, and Windows (DirectSound and ASIO) operating systems."
SECTION = "libs"
LICENSE = "rtaudio"
HOMEPAGE = "http://www.music.mcgill.ca/~gary/rtaudio"

DEPENDS = "alsa-lib"

PR = "r0"
LIC_FILES_CHKSUM = "file://ChangeLog;md5=11dcab5b31f55cab7c13058279c5e923"
SRC_URI = "git://github.com/thestk/rtaudio.git;protocol=https"
SRCREV = "${PV}"

S = "${WORKDIR}/git"

inherit cmake

FILES_${PN} += "${libdir}/* /usr/share"