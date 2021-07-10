# Extend the base recipe search path to $HERE/init-ifupdown
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_append () {
	install -m 0644 ${WORKDIR}/interfaces ${D}/${sysconfdir}/
}