# Extend the base recipe search path to $HERE
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://dhcpcd.conf; \
			file://dhcpcd; \
			"

do_install_append () {
	install -d ${D}/${libdir}/dhcpcd5/

	install -m 0644 ${WORKDIR}/dhcpcd.conf ${D}/${sysconfdir}/
	install -m 0755 ${WORKDIR}/dhcpcd ${D}/${libdir}/dhcpcd5/
}

FILES_${PN} += "${libdir}/dhcpcd5"