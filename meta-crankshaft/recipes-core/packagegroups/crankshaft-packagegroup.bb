DESCRIPTION = "Crankshaft package group"
SUMMARY = "Crankshaft package group"

PACKAGE_ARCH = "${MACHINE_ARCH}"
INSANE_SKIP_${PN} = "dev-deps"

inherit packagegroup

CORE_OS = " \
    libinput-dev openssh openssh-keygen openssh-sftp-server \
"

WIFI_SUPPORT = " \
	packagegroup-base \
	iw \
	linux-firmware-bcm43430\
	wpa-supplicant \
	init-ifupdown \
	wpa-supplicant \
"

QT_DEV = " \
	qtbase-dev \
	qtbase-mkspecs \
	qtdeclarative \
	qtmultimedia \
	qtquickcontrols \
	qtquickcontrols-dev \
	qtquickcontrols-mkspecs \
	qtquickcontrols2 \
	qtquickcontrols2-dev \
	qtquickcontrols2-mkspecs \
	qtquickcontrols \
	qtbase-plugins \
	qtconnectivity-dev \
	qtconnectivity-mkspecs \
	qtmultimedia-dev \
	qtmultimedia-mkspecs \
	qtmultimedia-plugins \
"

GST_DEV = " \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
	gstreamer1.0-plugins-ugly \
"

RDEPENDS_${PN} = " \
	${CORE_OS} \
	${WIFI_SUPPORT} \
	${GST_DEV} \
	${QT_DEV} \
	librtaudio \
	openauto \
	sudo \
	hostapd \
	dnsmasq \
	crankshaft \
	crankshaft-helpers \
	dhcpcd \
	zip \
	crda \
"

INSANE_SKIP_${PN} = "dev-deps"