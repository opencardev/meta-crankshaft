SUMMARY = "IVI image sata"

include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "package-management splash "

IMAGE_INSTALL_append += " packagegroup-core-x11-base"
