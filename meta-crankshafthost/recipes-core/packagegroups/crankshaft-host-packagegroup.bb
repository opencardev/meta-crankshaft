DESCRIPTION = "Crankshaft host package group"
SUMMARY = "Crankshaft host package group"

PACKAGE_ARCH = "${MACHINE_ARCH}"
INSANE_SKIP_${PN} = "dev-deps"

inherit packagegroup

CORE_OS = " \
    libinput-dev openssh openssh-keygen openssh-sftp-server git \
"

WIFI_SUPPORT = " \
	packagegroup-base \
	iw \
	linux-firmware-bcm43430\
	wpa-supplicant \
	init-ifupdown \
	wpa-supplicant \
"

DOCKER_SUPPORT = " \
	docker \
	python3-docker-compose \
"