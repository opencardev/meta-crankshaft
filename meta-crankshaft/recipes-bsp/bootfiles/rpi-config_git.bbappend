do_deploy_append() {
	# audio on local jack
	echo "hdmi_force_hotplug=1" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}