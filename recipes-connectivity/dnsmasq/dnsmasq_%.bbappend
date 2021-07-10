# Extend the base recipe search path to $HERE
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://dnsmasq.conf"

do_install_append () {
	install -m 0644 ${WORKDIR}/dnsmasq.conf ${D}/${sysconfdir}/
}