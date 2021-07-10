# Extend the base recipe search path to $HERE/init-ifupdown
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant-wlan0.conf"

do_install_append () {
	install -d ${D}/${sysconfdir}/wpa_supplicant
	install -m 0644 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}/${sysconfdir}/wpa_supplicant/
	rm ${D}/${sysconfdir}/wpa_supplicant.conf
}