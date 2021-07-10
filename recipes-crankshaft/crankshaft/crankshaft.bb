DESCRIPTION = "Scripts from crankshaft"
SECTION = "libs"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://../git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
HOMEPAGE = "http://getcrankshaft.com"

DEPENDS = ""

PR = "r2"
SRC_URI = "git://github.com/opencardev/crankshaft.git;protocol=https;branch=crankshaft-ng; \
           file://0001-Update-to-new-paths-for-yocto-build.patch \
           file://0001-Fix-paths.-Need-to-run-wpa_supplicant-in-order-to-co.patch \
           "
SRCREV = "393f6733d89b3a2f233ddeaf49bdc84cdc7ae097"
inherit systemd

S = "${WORKDIR}/git"

do_install() {
	# /boot
	install -d "${D}/boot/crankshaft"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/boot/crankshaft/gpio2kbd.cfg                       "${D}/boot/crankshaft/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/boot/crankshaft/openauto.ini                       "${D}/boot/crankshaft/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/boot/crankshaft/startup.py                         "${D}/boot/crankshaft/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/boot/crankshaft/startup.sh                         "${D}/boot/crankshaft/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/boot/crankshaft/triggerhappy.conf                  "${D}/boot/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_default_env.sh           "${D}/boot/crankshaft/crankshaft_env.sh"
	install -d "${D}/boot/crankshaft/custom"

	# /etc
	install -d "${D}/etc/pulse"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/pulse/csng_daemon.conf                         "${D}/etc/pulse/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/pulse/csng_default.pa                          "${D}/etc/pulse/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/pulse/csng_system.pa                           "${D}/etc/pulse/"
	install -d "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/openauto.service                "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/btservice.service               "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/crankshaft.service              "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/daymode.service                 "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/daymode.timer                   "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/devmode.service                 "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/debugmode.service               "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/disconnect.service              "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/disconnect.timer                "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/display.service                 "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/gpio2kbd.service                "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/gpiotrigger.service             "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/shutdown.service                "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/shutdown.timer                  "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/tap2wake.service                "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/timerstart.service              "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/update.service                  "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/update.timer                    "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/usbrestore.service              "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/usbdetect.service               "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/usbunmount.service              "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/rpicamserver.service            "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/hwclock-load.service            "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/nightmode.service               "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/nightmode.timer                 "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/user_startup.service            "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/hotspot.service                 "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/hotspot-monitor.service         "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/regensshkeys.service            "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/custombrightness.service        "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/pulseaudio.service              "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/pulseaudio-debug.service        "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/alsastaterestore.service        "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/lightsensor.service             "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/i2ccheck.service                "${D}${systemd_system_unitdir}"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/wpa-monitor.service             "${D}${systemd_system_unitdir}"
	install -d "${D}${systemd_system_unitdir}systemd-udevd.service.d"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/systemd/system/systemd-udevd.service.d/override.conf "${D}${systemd_system_unitdir}systemd-udevd.service.d"
	install -d "${D}/etc/udev/rules.d"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/10-gpio2kbd.rules                 "${D}/etc/udev/rules.d/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/51-android.rules                  "${D}/etc/udev/rules.d/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/51-android.master                 "${D}/etc/udev/rules.d/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/udev/rules.d/10-automount.rules                "${D}/etc/udev/rules.d/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/etc/rc.local                                       "${D}/etc/"
	#install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/issue                                          "${D}/etc/"
	#install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/issue.net                                      "${D}/etc/"
	#install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/motd                                           "${D}/etc/"
	install -d "${D}/etc/rsyslog.d/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/rsyslog.d/disable-logspam.conf                 "${D}/etc/rsyslog.d/"

	install -d "${D}/etc/initramfs-tools/conf.d"
	install -d "${D}/etc/initramfs-tools/hooks"
	install -d "${D}/etc/initramfs-tools/scripts/local-top"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/initramfs-tools/conf.d/local.conf              "${D}/etc/initramfs-tools/conf.d/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/etc/initramfs-tools/hooks/pv                       "${D}/etc/initramfs-tools/hooks/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/etc/initramfs-tools/scripts/local-top/local.sh     "${D}/etc/initramfs-tools/scripts/local-top/"

	install -d "${D}/etc/default/"
	install -d "${D}/etc/hostapd/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/default/hostapd                                "${D}/etc/default/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/hostapd/hostapd.conf                           "${D}/etc/hostapd/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/dnsmasq.conf                                   "${D}/etc/"

	install -d "${D}/etc/samba"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/etc/samba/smb.conf                                 "${D}/etc/samba/"

	# /opt
	install -d "${D}/opt/crankshaft"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_default_env.sh           "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_system_env.sh            "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_crankshaft.sh               "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/cameraserver.py                     "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/cameracontrol.py                    "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_debugmode.sh                "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_devmode.sh                  "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_display.sh                  "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_daynight.sh                 "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_gpiotrigger.sh              "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_openauto.sh                 "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_tap2wake.sh                 "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_timerstart.sh               "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_wifisetup.sh                "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_usbrestore.sh               "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_usbdetect.sh                "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_usbunmount.sh               "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_user_startup.sh             "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_hotspot.sh                  "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_hostapdchange.sh            "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_custombrightness.sh         "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_pacheck.sh                  "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_hwclock.sh                  "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_lightsensor.py              "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_i2ccheck.sh                 "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/service_wpachange.sh                "${D}/opt/crankshaft/"
	#install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/gpio2kbd                            "${D}/opt/crankshaft/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/triggerhappy.conf                   "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/usb_action.sh                       "${D}/opt/crankshaft/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/aa_device_state.sh                  "${D}/opt/crankshaft/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/start_order                         "${D}/opt/crankshaft/"

	install -d "${D}/opt/crankshaft/wallpaper"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/wallpaper.png                   "${D}/opt/crankshaft/wallpaper/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/wallpaper-night.png             "${D}/opt/crankshaft/wallpaper/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/wallpaper-classic.png           "${D}/opt/crankshaft/wallpaper/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/wallpaper-classic-night.png     "${D}/opt/crankshaft/wallpaper/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/wallpaper-christmas.png         "${D}/opt/crankshaft/wallpaper/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/wallpaper-firework.png          "${D}/opt/crankshaft/wallpaper/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/camera-overlay.png              "${D}/opt/crankshaft/wallpaper/"
	#install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/cam_overlay/overlay.png                   "${D}/opt/crankshaft/wallpaper/usbcamera-overlay.png"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/wallpaper/wallpaper-eq.png                "${D}/opt/crankshaft/wallpaper/"

	#install -d "${D}/opt/crankshaft/cam_overlay"
	#install -m 0755 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/cam_overlay/cam_overlay.bin   "${D}/opt/crankshaft/cam_overlay/"

	#install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/cam_overlay/shader-YUYV.frag  "${D}/opt/crankshaft/cam_overlay/"
	#install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/cam_overlay/shader.frag       "${D}/opt/crankshaft/cam_overlay/"
	#install -m 0644 ${S}/stage3/03-crankshaft-base/files/opt/crankshaft/cam_overlay/shader.vert       "${D}/opt/crankshaft/cam_overlay/"
	# /usr 
	#install -d "${D}/usr/local/bin/"
	#install -m 0755 ${S}/stage3/03-crankshaft-base/files/usr/local/bin/usbreset                             "${D}/usr/local/bin/"
	# /lib
	install -d "${D}/lib/udev/"
	install -m 0755 ${S}/stage3/03-crankshaft-base/files/lib/udev/hwclock-set                               "${D}/lib/udev/"

	# custom resolv.conf hook
	install -d "${D}/lib/dhcpcd/dhcpcd-hooks/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/lib/dhcpcd/dhcpcd-hooks/20-resolv.conf             "${D}/lib/dhcpcd/dhcpcd-hooks/"

	# custom dhcpcd service withh added pre wifisetup
	install -d "${D}/lib/systemd/system/"
	install -m 0644 ${S}/stage3/03-crankshaft-base/files/lib/systemd/system/dhcpcd.service                  "${D}/lib/systemd/system/"

}

FILES_${PN} += "\
	/boot/crankshaft/ \
	/etc/pulse/ \
	/etc/ \
	/etc/initramfs-tools \
	/opt/crankshaft/ \
	${systemd_system_unitdir} \
	/etc/udev/rules.d/ \
	/usr/local/bin/ \
	/lib/dhcpcd/dhcpcd-hooks/ \
	/lib/udev/ \
	/lib/systemd/ \
"

INSANE_SKIP_${PN} = "file-rdeps"
