SUMMARY = "Crankshaft host production image"

include core-image-base.bb

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_Crankshaft-Host-Image-Yocto"

IMAGE_INSTALL:append = " crankshaft-host-packagegroup"
