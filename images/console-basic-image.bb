SUMMARY = "A basic image with wifi and ssh"

include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "package-management splash"

IMAGE_INSTALL_append = " crankshaft-packagegroup"

export IMAGE_BASENAME = "console-basic-image"