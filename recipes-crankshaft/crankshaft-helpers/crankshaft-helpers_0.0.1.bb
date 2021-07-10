DESCRIPTION = "Crankshaft Helpers"
SECTION = "libs"
HOMEPAGE = "http://getcrankshaft.com"

DEPENDS = "crankshaft"
RDEPENDS_${PN} += "bash zip"
S="${WORKDIR}"

PR = "r2"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=650b869bd8ff2aed59c62bad2a22a821"
SRC_URI= "https://raw.githubusercontent.com/opencardev/prebuilts/master/csmt/crankshaft;name=crankshaft \
https://raw.githubusercontent.com/opencardev/prebuilts/master/openauto/autoapp_helper;name=autoapp_helper \
https://raw.githubusercontent.com/opencardev/prebuilts/master/LICENSE;name=LICENSE \
"
SRC_URI[crankshaft.sha256sum] = "c37bce42dc5c6c28b0ea91eff3881d09a2a675902348b2cb1792e2d3c785b30a"
SRC_URI[autoapp_helper.sha256sum] = "d2de76ac0afa3a5bd8d9202f30d76af6a84fe70aa63d55a1cef049db0bfefe14"
SRC_URI[LICENSE.sha256sum] = "7c34d28e784b202aa4998f477fd0aa9773146952d7f6fa5971369fcdda59cf48"

SRC_REV="5d5dd3db89ec087cec17a5acf3921feefc6dc1e6"

do_install() {
	install -d ${D}/usr/local/bin
	install -m 0755 ${S}/crankshaft ${D}/usr/local/bin
	install -m 0755 ${S}/autoapp_helper ${D}/usr/local/bin
}

FILES_${PN} += "\
	/usr/local/bin \
"
