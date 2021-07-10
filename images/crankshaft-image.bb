SUMMARY = "Crankshaft production image"

include ivi-base-image.bb

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_Crankshaft-Image-Yocto"

IMAGE_INSTALL_append = " crankshaft-packagegroup"
