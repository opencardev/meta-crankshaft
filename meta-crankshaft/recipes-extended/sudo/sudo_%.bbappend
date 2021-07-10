# Add pi user to sudoers

do_install_append () {
    echo "pi ALL=(ALL) ALL" > ${D}${sysconfdir}/sudoers.d/001_first
}