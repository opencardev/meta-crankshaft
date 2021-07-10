SRC_URI_append = " https://raw.githubusercontent.com/opencardev/crankshaft/crankshaft-ng/stage3/03-crankshaft-base/files/opt/crankshaft/crankshaft_default_env.sh;downloadfilename=crankshaft_env.sh;name=csngdefaultcfg"
SRC_URI[csngdefaultcfg.md5sum] = "908cf6de76e9800261fe344ae572605b"
RDEPENDS_${PN} += "bash"

do_deploy_append() {
    install -d ${DEPLOYDIR}/${PN}/crankshaft
    install -m 0755 ${DL_DIR}/crankshaft_env.sh ${DEPLOYDIR}/${PN}/crankshaft/crankshaft_env.sh
}